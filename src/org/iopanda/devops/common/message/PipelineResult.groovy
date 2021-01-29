package org.iopanda.devops.common.message

class PipelineResult extends Message {
    PipelineResult(String status){
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
    }
    public String getMessage(){
        return "*${status}*:  Job *${steps.env.JOB_NAME}* build *${steps.env.BUILD_NUMBER}* ${clip}!\nCheck pipeline logs for more details: <${steps.env.RUN_DISPLAY_URL}|Click>."
    }
}