package org.iopanda.devops.common.message

class PipelineResult extends Message {
    PipelineResult(String status){
        String clip
        switch (status) {
            case "SUCCESS":
                setColor("good")
                clip = "done"
            case "FAILURE":
                setColor("danger")
                clip = "failed"
            case "UNSTABLE":
                setColor("warning")
                clip = "unstable"
            default:
                setColor("danger")
                clip = "unclear"
        }
        setMessage("*${status}*:  Job *${env.JOB_NAME}* build *${env.BUILD_NUMBER}* ${clip}!\nCheck pipeline logs for more details: <${env.RUN_DISPLAY_URL}|Click>.")
    }
}