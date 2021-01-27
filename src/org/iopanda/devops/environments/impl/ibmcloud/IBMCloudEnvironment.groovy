package org.iopanda.devops.environments.impl.ibmcloud

import org.iopanda.devops.environments.CloudEnvironment

class IBMCloudEnvironment extends CloudEnvironment {

    IBMCloudEnvironment(steps) {
        super(steps)
    }

    void init(){
        steps.sh "echo init"
    }
    void connect(){
        steps.sh "echo connect"
    }
    void build(){
        steps.sh "echo build"
    }
    void deploy(){
        steps.sh "echo deploy"
    }
}