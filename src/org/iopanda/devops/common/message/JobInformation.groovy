package org.iopanda.devops.common.message

class JobInformation extends Message {
    def steps
    def author_name
    JobInformation(){
        this.color = "#6ECADC"
        this.author_name = steps.sh(script: "git show -s --pretty=%an", returnStdout: true).trim()
    }
    
    public void setSteps(steps){
        this.steps = steps
    }

    public String getMessage(){
        return "*Notify*:  Job *${steps.env.JOB_NAME}* build *${steps.env.BUILD_NUMBER}* is starting...\nChange author: ${author_name}.\nChange from: ${steps.env.CHANGE_BRANCH}.\nChange target: ${steps.env.CHANGE_TARGET}.\nGithub PR: <${steps.env.CHANGE_URL}>Click>\nPipeline Logs: <${steps.env.RUN_DISPLAY_URL}|Click>."
    }
}