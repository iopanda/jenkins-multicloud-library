package org.iopanda.devops.environments.ibmcloud

import org.iopanda.devops.Environment
import org.iopanda.devops.deployer.Kubernetes

class IBMCloudEnvironment extends Environment {

    IBMCloudEnvironment(steps) {
        super(steps)
    }

    void init(){
        steps.sh("curl -sL https://raw.githubusercontent.com/IBM-Cloud/ibm-cloud-developer-tools/master/linux-installer/idt-installer | bash")
        steps.sh("ibmcloud -h")
    }

    void connect(String region, String iam_apikey){
        steps.sh "ibmcloud login -a cloud.ibm.com -r ${region} -g default --apikey ${iam_apikey}"
    }

    void run(String cmd){
        steps.sh(cmd)
    }

    void deploy(Kubernetes k8s, String cluster){
        step.sh("ibmcloud ks cluster config --cluster ${cluster}")
        step.sh("kubectl config current-context")
        step.sh("kubectl get nodes")
    }


}