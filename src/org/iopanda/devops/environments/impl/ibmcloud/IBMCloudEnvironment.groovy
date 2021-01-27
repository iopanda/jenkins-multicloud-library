package org.iopanda.devops.environments.impl.ibmcloud

import org.iopanda.devops.environments.CloudEnvironment

class IBMCloudEnvironment extends CloudEnvironment {

    IBMCloudEnvironment(steps) {
        super(steps)
    }

    void init(){
        steps.sh "init"
    }
    void connect(){
        steps.sh "connect"
    }
    void build(){
        steps.sh "build"
    }
    void deploy(){
        steps.sh "deploy"
    }
}