package org.iopanda.devops.common.message

class StageResult extends Message {
    def steps
    String stage_result
    StageResult(){
        this.color = "#6ECADC"
    }

    public void setSteps(steps){
        this.steps = steps
        this.stage_result = steps.currentBuild.currentResult
    }

    public String getMessage(){
        String name = steps.env.PROJECT_NAME || steps.env.JOB_NAME
        return "*Update | ${name}*: Stage ${steps.env.STAGE_NAME} is ${stage_result}"
    }
}