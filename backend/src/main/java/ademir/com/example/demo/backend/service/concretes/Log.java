package ademir.com.example.demo.backend.service.concretes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

    private static Logger instance;

    public static Logger getInstance(Class<?> className) {
        if (instance == null) {
            return LoggerFactory.getLogger(className);
        }
        return instance;
    }
}
