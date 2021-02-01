@Library('jenkins-multicloud-library@feature0')

import org.iopanda.devops.environments.ibmcloud.IBMCloudEnvironment
import org.iopanda.devops.deployer.Kubernetes
import org.iopanda.devops.common.Slack
import org.iopanda.devops.common.message.*

def cloud = new IBMCloudEnvironment(this)
def slack = new Slack(this, "app-preview")

pipeline {
    agent { label 'kube-helm3-cicd' }

    stages {
        stage('Inform Slack') {
            steps {
                script{
                    slack.send(new JobInformation())
                }
            }
        }
        stage('install ibmcloud-cli') {
            steps {
                script {
                    cloud.init()
                }
            }
            post{always{script{slack.send(new StageResult())}}}
        }
        stage('config ibmcloud-cli') {
            steps {
                script {
                    withFolderProperties {
                        cloud.setRegion("us-south").setIamApiKey("${env.IAM_APIKEY}")
                    }
                }
            }
            post{always{script{slack.send(new StageResult())}}}
        }
        stage('ibmcloud login') {
            steps {
                script {
                    cloud.connect()
                }
            }
            post{always{script{slack.send(new StageResult())}}}
        }
        stage('deploy k8s') {
            steps {
                script {
                    withFolderProperties {
                        cloud.deploy(new Kubernetes(), "${env.CLUSTER_ID}")
                    }
                }
            }
            post{always{script{slack.send(new StageResult())}}}
        }
        post(always{script{slack.send(new PipelineResult())}})
        stage('slack'){
            steps {
                script {
                    slack.send(new PipelineResult())
                }
            }
        }
    }
}
