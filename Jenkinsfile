@Library('jenkins-multicloud-library@feature0')

import org.iopanda.devops.environments.ibmcloud.IBMCloudEnvironment
import org.iopanda.devops.deployer.Kubernetes

def cloud = new IBMCloudEnvironment(this)

pipeline {
    agent { label 'kube-helm3-cicd' }

    stages {
        stage('install ibmcloud-cli') {
            steps {
                script {
                    cloud.init()
                }
            }
        }
        stage('config ibmcloud-cli') {
            steps {
                script {
                    cloud.setRegion("us-south").setIamApiKey($IAM_APIKEY)
                }
            }
        }
        stage('ibmcloud login') {
            steps {
                script {
                    cloud.connect()
                }
            }
        }
        stage('deploy k8s') {
            steps {
                script {
                    cloud.deploy(new Kubernetes(), $IAM_APIKEY)
                }
            }
        }
    }
}
