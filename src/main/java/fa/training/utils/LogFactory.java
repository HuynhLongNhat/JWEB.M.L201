package fa.training.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFactory {
    private static final Logger logger = LoggerFactory.getLogger(LogFactory.class);

    public static Logger getLogger() {
        return logger;
    }
}
