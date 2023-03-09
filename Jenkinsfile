#!/usr/bin/env groovy


def helper

pipeline {
    agent any

    stages {
        stage('Init') {
            steps {
                script {
                    helper = load "helper.groovy"
                }
            }
        }
        stage('Lint') {
            steps {
                script {
                    helper.test()
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    helper.build()
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    helper.deploy()
                }
            }
        }
    }

    post {
        // Clean after build
        always {
            cleanWs(
                cleanWhenNotBuilt: false,
                deleteDirs: true,
                disableDeferredWipeout: true,
                notFailBuild: true,
                skipWhenFailed: true
            )
        }
        success {
            echo 'I succeeded! '
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
        }
        changed {
            echo 'Things were different before...'
        }
    }
}
