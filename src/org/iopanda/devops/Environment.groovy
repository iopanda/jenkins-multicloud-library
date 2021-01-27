package org.iopanda.devops

import org.iopanda.devops.Common

abstract class Environment extends Common {
    Environment(steps) { super(steps) }

    abstract void init()
    abstract void connect()
    abstract void run(String cmd)
}