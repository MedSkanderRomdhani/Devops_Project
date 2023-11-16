pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'Oussema', url: 'https://github.com/MedSkanderRomdhani/Devops_Project.git'
            }
        }
               stage('Clean') {
                   steps {
                           sh clean
                   }
               }

               stage('Test') {
                   steps {
                   sh test
                   }
               }

               stage('Compile') {
                   steps {
                           sh compile
                   }
               }

               stage('SonarQube') {
                   steps {
                         sh sonar:sonar
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
