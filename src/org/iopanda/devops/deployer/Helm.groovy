package org.iopanda.devops.deployer

import org.iopanda.devops.Common

class Helm extends Common {
    private String path
    private String values
    private String namespace
    private String dependency
    private String tag
    private String options

    Helm(steps){
        super(steps)
        steps.sh("""
            curl -SsL https://get.helm.sh/helm-v3.1.0-linux-amd64.tar.gz -o helm.tar.gz
            tar -zxvf helm.tar.gz
            sudo mv linux-amd64/helm /usr/local/bin/helm
        """)
    }

    void deply(){
        if(this.dependency == null){
            steps.sh("""
                export CLUSTER="`kubectl config view --raw --minify | grep current-context| awk -F ':' '{print \$2}'`"
                helm dependency build ${path}
                helm template ${path} \
                    --values ${path}/${values} \
                    --set namespace=${namespace} \
                    --set image.tag=${tag} \
                    ${options} | kubectl apply -f -
            """)
        }else{
            steps.sh("""
                export CLUSTER="`kubectl config view --raw --minify | grep current-context| awk -F ':' '{print \$2}'`"
                helm dependency build ${path}
                helm template ${path} \
                    --values ${path}/${values} \
                    --set ${dependency}.namespace=${namespace} \
                    --set ${dependency}.image.tag=${tag} \
                    ${options} | kubectl apply -f -
            """)
        }
    }

}