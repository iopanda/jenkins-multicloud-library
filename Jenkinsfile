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
                    cloud.login('us-south', 'ktitUajO3-2rDcH3xT98FFqrM0hLJUtMyluhBqks79EQ')
                    cloud.deploy(new Kubernetes(), "c5295d9babbc465ba79c16891bb85920")
                }
            }
        }
    }
}
