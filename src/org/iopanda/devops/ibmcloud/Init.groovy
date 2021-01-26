

class Init implements Serializable {
    def steps
    Init(steps) {
        this.steps = steps
    }

    def init() {
        steps.sh "curl -sL https://ibm.biz/idt-installer | bash"
    }

    def login() {
        steps.sh "ibmcloud login -a cloud.ibm.com -r us-south -g default"
    }
}