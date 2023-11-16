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
                           sh mvn clean
                   }
               }

               stage('Test') {
                   steps {
                   sh mvn test
                   }
               }

               stage('Compile') {
                   steps {
                           sh mvn compile
                   }
               }

               stage('SonarQube') {
                   steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn package sonar:sonar'
                }                   }
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
