pipeline {
    agent any
      environment {
            DB_URL = 'jdbc:mysql://example.com:3306/devops_project'
            DB_USERNAME = 'root'
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
