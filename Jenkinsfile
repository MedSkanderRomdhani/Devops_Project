pipeline {
    agent any

    stages {
        stage('Git') {
            steps {
                git branch: 'Oussema', url: 'https://github.com/MedSkanderRomdhani/Devops_Project.git'
            }
        }




        stage('Compile') {
            steps {
                script {
                    sh 'mvn clean compile'
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
        stage('Junit / Mockito') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }
        stage('Nexus') {
            steps {
                script {
                    sh "mvn deploy -DskipTests"
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
