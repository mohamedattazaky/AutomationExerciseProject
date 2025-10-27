package logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsManager {
    private static Logger logger() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }

    public static void info(String message) {
        logger().info(message);
    }

    public static void debug(String message) {
        logger().debug(message);
    }

    public static void warn(String message) {
        logger().warn(message);
    }

    public static void error(String message) {
        logger().error(message);
    }

    public static void fatal(String message) {
        logger().fatal(message);
    }

    public static String LOGS_PATH= "test-outputs/Logs";

}


