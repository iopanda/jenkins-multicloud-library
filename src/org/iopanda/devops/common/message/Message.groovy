package org.iopanda.devops.common.message

class Message implements Serializable {
    String color
    String message
    
    public String getColor(){
        return color
    }
    public String getMessage(){
        return message
    }
}