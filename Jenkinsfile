pipeline {
    agent any

    stages {
        stage('Git Checkout') {
            steps {
                script{
                    git branch: 'main',
                        credentialsId: 'GitbuhPAT',
                        url: 'https://github.com/carotte98/carotteCase_Site.git'
                }
            }
        }

        stage('Build Maven') {
            steps {
                bat 'mvn clean package'    
            }
        }
    }
}