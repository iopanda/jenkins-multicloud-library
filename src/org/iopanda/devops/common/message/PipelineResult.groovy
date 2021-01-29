package org.iopanda.devops.common.message

class PipelineResult extends Message {
    def steps
    String status
    PipelineResult(String status){
        this.status = status
    }
    public void setSteps(steps){
        this.steps = steps
    }

    public String getMessage(){
        String clip
        switch (status) {
            case "SUCCESS":
                color = "good"
                clip = "done"
            case "FAILURE":
                color = "danger"
                clip = "failed"
            case "UNSTABLE":
                color = "warning"
                clip = "unstable"
            default:
                color = "danger"
                clip = "unclear"
        }
        return "*${status}*:  Job *${steps.env.JOB_NAME}* build *${steps.env.BUILD_NUMBER}* ${clip}!\nCheck pipeline logs for more details: <${steps.env.RUN_DISPLAY_URL}|Click>."
    }
}