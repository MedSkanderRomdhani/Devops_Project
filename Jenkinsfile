pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Récupération du code source depuis le référentiel Git
                git branch: 'Oussema', url: 'https://github.com/MedSkanderRomdhani/Devops_Project.git'
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
