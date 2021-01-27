package org.iopanda.devops

abstract class Publisher implements Serializable {
    def steps;
    Publisher(steps) {
        this.steps = steps
    }
}