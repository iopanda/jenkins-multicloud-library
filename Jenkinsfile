@Library('jenkins-multicloud-library@feature0')_
import org.iopanda.devops.environments.impl.ibmcloud.IBMCloudEnvironment;

pipeline {
    agent {label 'kube-helm3-cicd'}

    stages {
        stage('stage 1') {
            steps{
                script{
                    def cloud = new IBMCloudEnvironment();
                    cloud.init()
                }
            }
        }
    }
}
