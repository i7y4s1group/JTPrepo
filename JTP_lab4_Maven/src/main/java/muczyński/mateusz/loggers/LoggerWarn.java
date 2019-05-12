package muczyński.mateusz.loggers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerWarn {
    private static Logger logger = null;

    public static synchronized Logger getInstance(){
        PropertyConfigurator.configure("warn.properties");
        if(logger == null){
            logger = Logger.getLogger("warn");
        }
        return logger;
    }
}
