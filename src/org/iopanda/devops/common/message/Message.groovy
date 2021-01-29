package org.iopanda.devops.common.message

class Message implements Serializable {
    def steps
    String color
    String message
    
    public String getColor(){
        return color
    }
    public String getMessage(){
        return message
    }
    public void setSteps(steps){
        this.steps = steps
    }
}