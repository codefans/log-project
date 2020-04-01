package log;

import java.io.File;

/**
 * @author codefans
 * @date 2018/1/18 17:30
 */
public class Log4JBase {

    public static String PROJECT_ROOT = System.getProperty("user.dir");

    public static String OPEN_SOURCE_ROOT  = PROJECT_ROOT + File.separator + "log-log4j2";

    public static String OPEN_SOURCE_RESOURCES_ROOT  = OPEN_SOURCE_ROOT + File.separator + "src/main/resources";

    public static String OPEN_SOURCE_RESOURCES_LOG4J2  = OPEN_SOURCE_RESOURCES_ROOT + File.separator + "log4j2";


}
