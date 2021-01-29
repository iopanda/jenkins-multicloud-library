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
        setMessage("*${status}*:  Job *${JOB_NAME}* build *${BUILD_NUMBER}* ${clip}!\nCheck pipeline logs for more details: <${RUN_DISPLAY_URL}|Click>.")
    }
}