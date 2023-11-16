pipeline {
    agent any

    stages {
        stage('Git') {
            steps {
                git branch: 'Oussema', url: 'https://github.com/MedSkanderRomdhani/Devops_Project.git'
            }
        }

        stage('Clean') {
            steps {
                script {
                    sh 'mvn clean'
                }
            }
        }

        stage('Junit / Mockito') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Compile') {
            steps {
                script {
                    sh 'mvn compile'
                }
            }
        }

        stage('SonarQube') {
            steps {
                script {
                    withSonarQubeEnv('SonarQube') {
                        sh 'mvn package sonar:sonar'
                    }
                }
            }
        }

        stage('Affichage de la date système') {
            steps {
                script {
                    def date = sh(script: 'date', returnStdout: true).trim()
                    echo "Date système : ${date}"
                }
            }
        }
    }

    post {
        success {
            echo 'Le pipeline a été exécuté avec succès!'
        }
        failure {
            echo 'Le pipeline a échoué. Veuillez vérifier les logs pour plus d\'informations.'
        }
    }
}
