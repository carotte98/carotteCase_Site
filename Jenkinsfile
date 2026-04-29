pipeline {
    agent any

    tools{
        maven 'maven'
        jdk 'JDK25'
    }

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

        stage('Deploy docker-compose') {
            script {
                bat 'docker-compose up -d --build --force-recreate --remove-orphans'
            }
        }

    }
}