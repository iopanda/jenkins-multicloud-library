package org.iopanda.devops.deployer

import org.iopanda.devops.Common
import org.iopanda.devops.deployer.kubernetes.K8sResource

class Kubernetes extends Common {
    Kubernetes() {super(null)}
    Kubernetes(steps) { super(steps) }

    void create(K8sResource resource){
        steps.sh(resource.cmdCreate())
    }

    void get(K8sResource resource){
        steps.sh(resource.cmdGet())
    }
}