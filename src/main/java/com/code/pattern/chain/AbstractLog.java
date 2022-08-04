package com.code.pattern.chain;

public abstract class AbstractLog {

    int level;
    AbstractLog next;

    void log(int level, String msg) {
        if (this.level < level) {
            write(msg);
        }
        if (next != null) {
            next.log(level, msg);
        }
    }

    abstract void write(String msg);

    public AbstractLog(int level) {
        this.level = level;
    }
}
