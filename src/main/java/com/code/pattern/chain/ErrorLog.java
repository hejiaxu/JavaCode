package com.code.pattern.chain;

public class ErrorLog extends AbstractLog {

    public ErrorLog(int level) {
        super(level);
    }

    @Override
    void write(String msg) {
        System.out.println("error-" +msg);
    }
}
