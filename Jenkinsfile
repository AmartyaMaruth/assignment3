pipeline {
    agent any
    environment {
        DOCKER_IMAGE = "232183/survey-app:latest"
        DOCKER_CREDENTIALS_ID = 'docker_id'
        GIT_REPO = 'https://github.com/AmartyaMaruth/assignment3.git'
        KUBECONFIG_CREDENTIALS_ID = 'kubeconfig_id'
        AWS_CREDENTIALS_ID = 'AWS_CREDENTIALS_ID'
    }
    stages {
        stage('Clone Git Repository') {
            steps {
                script {
                    // Clone the repository into the workspace
                    dir('assignment3') {
                        sh "git clone ${GIT_REPO} ."
                    }
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image from the Dockerfile in the repo
                    dir('assignment3') {
                        sh "docker build -t ${DOCKER_IMAGE} ."
                    }
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    // Push Docker image to Docker Hub
                    withCredentials([usernamePassword(credentialsId: DOCKER_CREDENTIALS_ID, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                        sh "docker push ${DOCKER_IMAGE}"
                    }
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    // Use kubeconfig and AWS credentials for deployment
                    withCredentials([
                        file(credentialsId: KUBECONFIG_CREDENTIALS_ID, variable: 'KUBECONFIG')
                    ]) {
                        dir('assignment3') {
                            sh 'kubectl apply -f my-survey-app-deployment.yaml --validate=false'
                        }
                    }
                }
            }
        }
    }
    post {
        always {
            echo 'Pipeline execution completed.'
        }
        failure {
            echo 'Pipeline failed!'
        }
        success {
            echo 'Pipeline executed successfully!'
        }
    }
}
