pipeline {
    agent any
    environment {
        DOCKER_IMAGE = "232183/survey-app:latest"
        DOCKER_CREDENTIALS_ID = 'docker_id'  // Use the correct credential ID (docker_id)
        GIT_REPO = 'https://github.com/AmartyaMaruth/assignment3.git'  // GitHub repo URL
        KUBECONFIG_CREDENTIALS_ID = 'kubeconfig_id' // Kubernetes config credential ID
        AWS_CREDENTIALS_ID = 'AWS_CREDENTIALS_ID' // AWS credentials ID
    }
    
    stages {
        stage('Clone Git Repository') {
            steps {
                script {
                    // Remove any existing repo and clone the GitHub repository to fetch the Dockerfile and other resources
                    sh 'rm -rf assignment3'
                    sh 'git clone ${GIT_REPO}'
                    sh 'cd assignment3'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Navigate into the cloned directory and build the Docker image using the Dockerfile from the repo
                    sh 'docker build -t ${DOCKER_IMAGE} .'
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    // Authenticate with Docker Hub using the credentials stored in Jenkins (docker_id)
                    withCredentials([usernamePassword(credentialsId: DOCKER_CREDENTIALS_ID, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        // Login to Docker Hub
                        sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                        
                        // Push the Docker image to Docker Hub
                        sh "docker push ${DOCKER_IMAGE}"
                    }
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    // Use kubeconfig for Kubernetes authentication and AWS credentials
                    withCredentials([file(credentialsId: KUBECONFIG_CREDENTIALS_ID, variable: 'KUBECONFIG'),
                                     [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: AWS_CREDENTIALS_ID]]) {
                        
                        // Deploy the Kubernetes deployment and service YAML files
                        sh 'kubectl delete -f my-survey-app-deployment.yaml'
                        //sh 'kubectl delete -f my-survey-app-service.yaml'
                        sh 'kubectl apply -f my-survey-app-deployment.yaml --validate=false'
                        //sh 'kubectl apply -f my-survey-app-service.yaml --validate=false'
                    }
                }
            }
        }
    }
}
