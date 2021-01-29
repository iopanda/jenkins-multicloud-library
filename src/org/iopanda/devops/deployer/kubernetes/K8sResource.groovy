package org.iopanda.devops.deployer.kubernetes

interface K8sResource {
    void cmdCreate()
    void cmdGet()
}
