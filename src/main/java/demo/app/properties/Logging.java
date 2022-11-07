package demo.app.properties;

import org.apache.log4j.*;

public class Logging {

    private static final Logger logger = LogManager.getLogger(Logging.class);

    public static void main(String[] args)
    {
        logger.debug("Debug Message Logged !!!");
        logger.info("Info Message Logged !!!");
        logger.warn("Warn Message Logged !!!");
        logger.error("Error Message Logged !!!");
        logger.fatal("Fatal Message Logged !!!");

        logger.error("Error Message Logged !!!", new NullPointerException("NullError"));
    }

}
