package org.iopanda.devops.environments.impl.ibmcloud

import org.iopanda.devops.Environment

class IBMCloudEnvironment extends Environment {

    IBMCloudEnvironment(steps) {
        super(steps)
    }

    void init(){
        String cmd = "curl -sL https://raw.githubusercontent.com/IBM-Cloud/ibm-cloud-developer-tools/master/linux-installer/idt-installer | bash"
        steps.sh cmd
        steps.sh "ibmcloud -h"
    }

    void connect(){
        steps.sh "echo connect"
    }

    void run(String cmd){
        steps.sh cmd
    }
}