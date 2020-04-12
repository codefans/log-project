package log.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 初始化logback日志配置文件
 * LogbackInit.initLogback(System.getProperty("user.dir") + "/conf/logback.xml");
 */
public class LogbackInit {

    /**
     * 设置logback.xml配置文件并加载
     * @param configFilepathName 配置文件路径名，绝对路径
     */
    public static void initLogback(String configFilepathName) {
        File file = new File(configFilepathName);
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator joranConfigurator = new JoranConfigurator();
        joranConfigurator.setContext(loggerContext);
        loggerContext.reset();
        try {
            joranConfigurator.doConfigure(file);
        } catch (Exception e) {
            System.out.println(String.format("Load logback config file error. Message: ", e.getMessage()));
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
    }

    /**
     * 设置logback.xml配置文件并加载
     * @param relativeConfigPath，相对路径
     * @throws IOException
     * @throws JoranException
     */
    public static void load(String relativeConfigPath) throws IOException, JoranException {

        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

        URL configurationFileUrl = Loader.getResource(relativeConfigPath, Thread.currentThread().getContextClassLoader());
        String configFilePath = configurationFileUrl.getPath();
        File externalConfigFile = new File(configFilePath);

        if(!externalConfigFile.exists()){
            throw new IOException("Logback External Config File Parameter does not reference a file that exists");
        }else{
            if(!externalConfigFile.isFile()){
                throw new IOException("Logback External Config File Parameter exists, but does not reference a file");
            }else{
                if(!externalConfigFile.canRead()){
                    throw new IOException("Logback External Config File exists and is a file, but cannot be read.");
                }else{
                    JoranConfigurator configurator = new JoranConfigurator();
                    configurator.setContext(lc);
                    lc.reset();
                    configurator.doConfigure(configFilePath);
                    StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
                }
            }
        }

    }

}
