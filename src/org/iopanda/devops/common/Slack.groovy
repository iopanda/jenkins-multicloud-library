package org.iopanda.devops.common

import org.iopanda.devops.Common

class Slack extends Common {
    private String channel

    Slack(steps){ super(steps) }

    static void send(String channel) {
        steps.slackSend()
    }

    void send() {
        Slack.send(channel)
    }
}