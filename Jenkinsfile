@Library('jenkins-multicloud-library@feature0')
import org.iopanda.devops.environments.impl.ibmcloud.IBMCloudEnvironment.*

def cloud = new IBMCloudEnvironment()

pipeline {
    agent { label 'kube-helm3-cicd' }

    stages {
        stage('stage 1') {
            steps {
                script {
                    cloud.init()
                }
            }
        }
    }
}
