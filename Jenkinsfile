pipeline {
    agent any
      environment {
            DB_URL = 'jdbc:mysql://localhost:3306/devops_project'
            DB_USERNAME = 'iheb'
            DB_PASSWORD = 'root'
        }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
        }

    }
     stage('SonarQube Analysis') {
                steps {
                    withSonarQubeEnv('SonarValidation') {
                        sh 'mvn sonar:sonar'
                    }
                }
            }

    post {
        success {
            echo 'Build and tests succeeded BROOOOO !'
        }
        failure {
            echo 'Build or tests failed!'
        }
    }
}
