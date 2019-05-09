package io.github.maciejlagowski.jtp.labka4;

import org.apache.log4j.*;
import java.io.IOException;

class LoggerClass {
    private LoggerClass(){}

    static Logger getLogger() {
        Layout layout = new PatternLayout("[%p] %c - %m - DateOfLog: %d %n");
        Appender appender = null;
        try {
            appender = new FileAppender(layout, "log.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        BasicConfigurator.configure(appender);
        return Logger.getRootLogger();
    }
}
