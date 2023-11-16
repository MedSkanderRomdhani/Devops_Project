pipeline {
    agent any
      environment {
            DB_URL = 'jdbc:mysql://localhost:3306/devops_project'
            DB_USERNAME = 'admin'
            DB_PASSWORD = ''
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

    post {
        success {
            echo 'Build and tests succeeded BROOOOO !'
        }
        failure {
            echo 'Build or tests failed!'
        }
    }
}
