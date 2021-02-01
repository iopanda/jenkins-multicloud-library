package org.iopanda.devops.common.message

class StageResult extends Message {
    def steps
    public void setSteps(steps){
        this.steps = steps
    }

    public String getMessage(){
        this.color = "#6ECADC"
        String stage_result = steps.currentBuild.currentResult
        return "*Update | ${steps.env.PROJECT_NAME}*: Stage ${steps.env.STAGE_NAME} is ${stage_result}"
    }
}