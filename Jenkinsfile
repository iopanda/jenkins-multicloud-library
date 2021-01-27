@Library('jenkins-multicloud-library')_
import org.iopanda.devops.environments.impl.ibmcloud.IBMCloudEnvironment;

pipeline {
    agent {label 'kube-helm3-cicd'}
    options {
        
    }
    //global env.
    environment {
        
    }

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
