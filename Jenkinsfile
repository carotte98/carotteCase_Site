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

        stage('Build Maven') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Generate Allure Report') {
            steps {
                bat 'mvn allure:report'
            }
        }
    }
    
    post {
        always {
            allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
            ])
        }
    }
}