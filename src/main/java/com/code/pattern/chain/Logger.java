package com.code.pattern.chain;

public class Logger {
    AbstractLog logger;

    public void info(String msg) {
        logger.log(1, msg);
    }

    public Logger() {
        AbstractLog consoleLog = new ConsoleLog(2);
        AbstractLog errorLog = new ErrorLog(1);
        consoleLog.next = errorLog;
        logger = consoleLog;
    }
}
