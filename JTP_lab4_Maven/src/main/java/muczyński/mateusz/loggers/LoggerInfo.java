package muczyński.mateusz.loggers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerInfo {
    private static Logger logger = null;

    public static synchronized Logger getInstance(){
        PropertyConfigurator.configure("info.properties");
        if(logger == null){
            logger = Logger.getLogger("info");
        }
        return logger;
    }
}
