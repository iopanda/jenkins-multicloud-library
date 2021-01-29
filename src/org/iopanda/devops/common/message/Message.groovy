package org.iopanda.devops.common.message

class Message {
    private String color
    private String message

    void setColor(String color){
        this.color = color
    }
    void setMessage(String message){
        this.message = message
    }
    
    String getColor(){
        return color
    }

    String getMessage(){
        return message
    }
}