package org.iopanda.devops.common

import org.iopanda.devops.Common

class Docker extends Common {
    private String url = "hub.docker.com"
    private String username
    private String password
    private String namespace

    Docker(steps) { super(steps) }

    Docker setUrl(String url) {
        this.url = url
        return this
    }
    Docker setUsername(String username) {
        this.username = username
        return this
    }
    Docker setPassword(String password) {
        this.password = password
        return this
    }
    Docker setNamespace(String namespace) {
        this.namespace = namespace
        return this
    }

    /* DOCKER LOGIN */
    void login() {
        steps.sh("docker login -u ${username} -p ${password} ${url}")
    }

    /* DOCKER TAG */
    void tag(String source, String target) {
        steps.sh("docker tag ${source} ${target}")
    }

    /* DOCKER BUILD */
    void build(String name) {
        build(name, "latest")
    }
    void build(String name, String tag) {
        steps.sh("docker build -t ${name}:${tag} .")
    }
    void build(String name, String tag, String dockerfile, String context){
        build(name, tag, dockerfile, context, "")
    }
    void build(String name, String tag, String dockerfile, String context, String options){
        steps.sh("docker build -t ${name}:${tag} -f ${dockerfile} ${context} ${options}")
    }

    /* DOCKER PUSH */
    void push(String name) {
       push(name, "latest")
    }
    void push(String name, String tag) {
        String destination = "${url}/${namespace}/${name}:${tag}"
        tag("${name}:${tag} ${destination}")
        steps.sh("docker push ${destination}")
    }

}