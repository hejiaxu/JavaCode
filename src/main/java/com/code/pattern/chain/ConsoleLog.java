package com.code.pattern.chain;

public class ConsoleLog extends AbstractLog {

    public ConsoleLog(int level) {
        super(level);
    }

    @Override
    void write(String msg) {
        System.out.println("console-" +msg);
    }
}
