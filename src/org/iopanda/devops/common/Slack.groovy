package org.iopanda.devops.common

import org.iopanda.devops.Common
import org.iopanda.devops.common.message.Message

class Slack extends Common {
    private String channel

    Slack(steps){ super(steps) }
    Slack(steps, String channel){
        super(steps)
        this.channel = channel
    }

    void send(Message message) {
        send(channel, message)
    }

    void send(String ch, Message message){
        message.setSteps(steps)
        steps.slackSend(channel: "${ch}", color: "${message.getColor()}", message: "${message.getMessage()}")
    }
}