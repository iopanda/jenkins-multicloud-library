package org.iopanda.devops.common.message

class PipelineResult extends Message {
    def steps
    String clip
    String pipeline_result

    public void setSteps(steps){
        this.steps = steps
        this.pipeline_result = steps.currentBuild.currentResult
        switch (pipeline_result) {
            case "SUCCESS":
                this.color = "good"
                this.clip = "done"
            case "FAILURE":
                this.color = "danger"
                this.clip = "failed"
            case "UNSTABLE":
                this.color = "warning"
                this.clip = "unstable"
            default:
                this.color = "danger"
                this.clip = "unclear"
        }
    }

    public String getMessage(){        
        return "*${pipeline_result}*:  Job *${steps.env.JOB_NAME}* build *${steps.env.BUILD_NUMBER}* ${clip}!\nCheck pipeline logs for more details: <${steps.env.RUN_DISPLAY_URL}|Click>."
    }
}