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
                withFolderProperties {
                    script {
                        cloud.setRegion("us-south").setIamApiKey(${env.IAM_APIKEY})
                    }
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
                withFolderProperties {
                    script {
                        cloud.deploy(new Kubernetes(), ${env.CLUSTER_ID})
                    }
                }
                
            }
        }
    }
}
