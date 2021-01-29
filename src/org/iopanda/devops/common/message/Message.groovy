package org.iopanda.devops.common.message

class Message implements Serializable {
    private String color
    private String message

    public void setColor(String color){
        this.color = color
    }
    public void setMessage(String message){
        this.message = message
    }

    public String getColor(){
        return color
    }

    public String getMessage(){
        return message
    }
}