package marcinkowski.pawel;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

    public void Informacje(){
        PropertyConfigurator.configure("C:\\Users\\Paweł\\IdeaProjects\\JTPlab4\\src\\main\\java\\marcinkowski\\pawel\\Informacje.properties");
        Logger logger = Logger.getLogger("Informacje");
        logger.info("Uruchomiono program");
    }

    public void Klienci(){
        PropertyConfigurator.configure("C:\\Users\\Paweł\\IdeaProjects\\JTPlab4\\src\\main\\java\\marcinkowski\\pawel\\Klienci.properties");
        Logger logger = Logger.getLogger("Klienci");
        logger.info("Klienci wyszli");
    }

}
