package org.iopanda.devops.common

import org.iopanda.devops.Common
import org.iopanda.devops.common.message.Message

class Slack extends Common {
    private String channel

    Slack(steps){ super(steps) }

    static void send(String channel, Message message) {
        message.setSteps(steps)
        slackSend(channel: "${channel}", color: "${message.getColor()}", message: "${message.getMessage()}")
    }

    void send(Message message) {
        Slack.send(channel, message)
    }
}