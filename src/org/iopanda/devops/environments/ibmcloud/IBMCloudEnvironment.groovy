package org.iopanda.devops.environments.ibmcloud

import org.iopanda.devops.Environment
import org.iopanda.devops.deployer.Kubernetes

class IBMCloudEnvironment extends Environment {
    private String host = "cloud.ibm.com"
    private String region = "us-south"
    private String iam_apikey

    IBMCloudEnvironment(steps) { super(steps) }

    IBMCloudEnvironment setHost(String host){
        this.host = host;
        return this;
    }
    IBMCloudEnvironment setRegion(String region){
        this.region = region
        return this
    }
    IBMCloudEnvironment setIamApiKey(String iam_apikey){
        this.iam_apikey = iam_apikey
        return this
    }

    void init(){
        steps.sh("curl -sL https://raw.githubusercontent.com/IBM-Cloud/ibm-cloud-developer-tools/master/linux-installer/idt-installer | bash")
        steps.sh("ibmcloud config --check-version=false")
        steps.sh("ibmcloud -h")
    }

    void connect(){
        steps.sh "ibmcloud login -a ${host} -r ${region} -g default --apikey ${iam_apikey}"
    }

    void run(String cmd){
        steps.sh(cmd)
    }

    void deploy(Kubernetes k8s, String cluster){
        steps.sh("ibmcloud ks cluster config --cluster ${cluster})
        steps.sh("kubectl config current-context")
        steps.sh("kubectl get nodes")
    }


}