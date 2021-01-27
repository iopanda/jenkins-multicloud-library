@Library('jenkins-multicloud-library@feature0')

import org.iopanda.devops.environments.ibmcloud.IBMCloudEnvironment
import org.iopanda.devops.deployer.Kubernetes

def cloud = new IBMCloudEnvironment(this)

pipeline {
    agent { label 'kube-helm3-cicd' }

    stages {
        stage('stage 1') {
            steps {
                script {
                    cloud.init()
                    cloud.login('us-south', $CLUSTER_ID)
                    cloud.deploy(new Kubernetes(), $IAM_APIKEY)
                }
            }
        }
    }
}
