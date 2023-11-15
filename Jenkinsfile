pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    def mvnHome = tool 'Maven'
                    def mavenCmd = "${mvnHome}/bin/mvn"

                    sh "${mavenCmd} clean install"
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    def mvnHome = tool 'Maven'
                    def mavenCmd = "${mvnHome}/bin/mvn"

                    sh "${mavenCmd} test"
                }
            }
        }

    }

    post {
        success {
            echo 'SUCCESS !! :) '
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
