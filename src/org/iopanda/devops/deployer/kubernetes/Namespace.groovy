package org.iopanda.devops.deployer.kubernetes

class Namespace {
    private String name
    Namespace(String name){
        this.name = name
    }

    String getName(){
        return this.name
    }
}