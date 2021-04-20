pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'openjdk-11-jdk'
    }

    options  {
        buildDiscarder(logRotator(artifactDaysToKeepStr: '30', artifactNumToKeepStr: '30', daysToKeepStr: '30', numToKeepStr: '30'))
        disableConcurrentBuilds()
        disableResume()
    }

    triggers {
        pollSCM('H/5 * * * *')
    }

    stages {
        stage('Compile') {
            steps {
                withMaven(jdk: 'openjdk-11-jdk', maven: 'maven', mavenSettingsConfig: 'ad06f4c7-8d61-4456-b8db-c6ea6c3fe404') {
                     sh "mvn clean install"
                }
            }
        }

        stage('Sonarqube Scan') {
            steps {
                withCredentials([string(credentialsId: 'c59b91f8-fcb9-478a-b61f-7a9d64076d59', variable: 'sonarqube_secret')]) {
                    withSonarQubeEnv ('SonarQube') {
                        withMaven(jdk: 'openjdk-11-jdk', maven: 'maven', mavenSettingsConfig: 'ad06f4c7-8d61-4456-b8db-c6ea6c3fe404') {
                             sh "mvn sonar:sonar -Dsonar.host.url=http://sonarqube:9000 -Dsonar.login=${sonarqube_secret}"
                        }
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    timeout(time: 5, unit: 'MINUTES') {
                        waitForQualityGate abortPipeline: true
                    }
                }
            }
        }
    }
}