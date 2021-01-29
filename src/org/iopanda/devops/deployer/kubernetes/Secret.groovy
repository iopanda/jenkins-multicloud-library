package org.iopanda.devops.deployer.kubernetes

enum SecretType {
    DockerRegistry,
    Generic,
    Tls
}

class Secret implements K8sResource {
    private Namespace namespace
    private SecretType type
    private String name
    private Map data

    Secret(String namespace, SecretType type, String name, Map data){
        this.namespace = new Namespace(namespace)
        this.type = type
        this.name = name
        this.data = data
    }

    String cmdCreate(){
        String rsn;
        String args = "";
        switch (type) {
            case SecretType.DockerRegistry:
                rsn = "docker-registry"
                args += data.get("server") != null ? " --docker-server=${data.get("server")}" : ""
                args += data.get("username") != null ? " --docker-username=${data.get("username")}" : ""
                args += data.get("password") != null ? " --docker-password=${data.get("password")}" : ""
                args += data.get("email") != null ? " --docker-email=${data.get("email")}" : ""
            case SecretType.Generic:
                rsn = "generic"
                args += data.get("from-literal") != null ? " --from-literal=${data.get("from-literal")}" : ""
                args += data.get("from-file") != null ? " --from-file=${data.get("from-file")}" : ""
                args += data.get("from-env-file") != null ? " --from-env-file=${data.get("from-env-file")}" : ""
            case SecretType.Tls:
                rsn = "tls"
                args += data.get("cert") != null ? " --cert=${data.get("cert")}" : ""
                args += data.get("key") != null ? " --key=${data.get("key")}" : ""
        }
        return "kubectl create secret -n ${namespace} ${rsn} ${name} ${args}"
    }

    String cmdGet(){
        return "kubectl get secret -n ${namespace} ${name}"
    }
}
