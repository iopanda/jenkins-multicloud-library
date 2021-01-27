package org.iopanda.devops.environments

abstract class CloudEnvironment implements Serializable {
    def steps;
    CloudEnvironment(steps) {
        this.steps = steps
    }

    abstract void init()
    abstract void connect()
    abstract void build()
    abstract void deploy()
}