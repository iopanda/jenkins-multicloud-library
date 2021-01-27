package org.iopanda.devops

abstract class Deployer implements Serializable {
    def steps;
    Deployer(steps) {
        this.steps = steps
    }
}