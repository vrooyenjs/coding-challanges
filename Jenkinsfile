pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'openjdk-11-jdk'
    }

    options  {
        buildDiscarder(logRotator(artifactDaysToKeepStr: '10', artifactNumToKeepStr: '10', daysToKeepStr: '10', numToKeepStr: '10'))
        disableConcurrentBuilds()
        disableResume()
        pipelineTriggers([pollSCM('H/5 * * * *')]
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
                echo 'Hello world!'
            }
        }

        stage('Quality Gate') {
            steps {
                echo 'Hello world!'
            }
        }
    }
}