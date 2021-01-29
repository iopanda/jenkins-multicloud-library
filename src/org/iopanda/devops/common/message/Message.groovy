package org.iopanda.devops.common.message

class Message implements Serializable {
    private String color
    private String message

    @NonCPS
    public void setColor(String color){
        this.color = color
    }
    @NonCPS
    public void setMessage(String message){
        this.message = message
    }
    @NonCPS
    public String getColor(){
        return color
    }
    @NonCPS
    public String getMessage(){
        return message
    }
}