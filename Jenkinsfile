@Library('jenkins-multicloud-library@feature0')

import org.iopanda.devops.environments.ibmcloud.IBMCloudEnvironment
import org.iopanda.devops.deployer.Kubernetes
import org.iopanda.devops.common.Slack
import org.iopanda.devops.common.message.*

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
                    withFolderProperties {
                        cloud.setRegion("us-south").setIamApiKey("${env.IAM_APIKEY}")
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
                script {
                    withFolderProperties {
                        cloud.deploy(new Kubernetes(), "${env.CLUSTER_ID}")
                    }
                }
                
            }
        }
        stage('slack'){
            steps {
                script {
                    Slack.send("app-preview", new PipelineResult("${currentBuild.currentResult}"))
                }
            }
        }
    }
}
