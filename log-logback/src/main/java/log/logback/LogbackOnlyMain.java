package log.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LogbackOnlyMain {

    public static void main(String[] args) {
        LogbackOnlyMain logbackOnlyMain = new LogbackOnlyMain();
        logbackOnlyMain.startup();
    }

    public void startup() {

        try {

            String configFilePath = "logback.xml";
            LogbackInit.load(configFilePath);

            Logger log = LoggerFactory.getLogger(LogbackOnlyMain.class);
            log.info("22222222");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }





}
