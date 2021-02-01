package org.iopanda.devops.common.message

class PipelineResult extends Message {
    def steps
    public void setSteps(steps){
        this.steps = steps
    }

    public String getMessage(){
        String clip
        String pipeline_result = steps.currentBuild.currentResult
        switch (pipeline_result) {
            case "SUCCESS":
                this.color = "good"
                clip = "done"
            case "FAILURE":
                this.color = "danger"
                clip = "failed"
            case "UNSTABLE":
                this.color = "warning"
                clip = "unstable"
            default:
                this.color = "danger"
                clip = "unclear"
        }
        return "*${pipeline_result}*:  Job *${steps.env.JOB_NAME}* build *${steps.env.BUILD_NUMBER}* ${clip}!\nCheck pipeline logs for more details: <${steps.env.RUN_DISPLAY_URL}|Click>."
    }
}