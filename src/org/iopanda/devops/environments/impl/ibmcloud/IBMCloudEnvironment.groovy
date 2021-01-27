package org.iopanda.devops.environments.impl.ibmcloud.IBMCloudEnvironment

import org.iopanda.devops.environments.CloudEnvironment

class IBMCloudEnvironment implements CloudEnvironment {

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