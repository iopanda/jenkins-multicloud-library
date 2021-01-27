package org.iopanda.devops.environments.CloudEnvironment

abstract class CloudEnvironment {
    def steps;
    CloudEnvironment(steps) {
        this.steps = steps
    }

    abstract void init()
    abstract void connect()
    abstract void build()
    abstract void deploy()
}