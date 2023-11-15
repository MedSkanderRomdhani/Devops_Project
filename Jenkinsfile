pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Check Maven Installation') {
            steps {
                script {
                    tool 'Maven'
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    tool 'Maven'

                    def mvnHome = tool 'Maven'
                    def mavenCmd = "${mvnHome}/bin/mvn"

                    sh "${mavenCmd} clean install"
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    // Print available tools to console
                    tool 'Maven'

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
