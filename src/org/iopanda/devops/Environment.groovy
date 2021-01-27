package org.iopanda.devops

abstract class Environment implements Serializable {
    def steps;
    Environment(steps) {
        this.steps = steps
    }

    abstract void init()
    abstract void connect()
    abstract void run(String cmd)
}