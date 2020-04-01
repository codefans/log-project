/**
 * Copyright (C), 2015-2020, 京东
 * FileName: CustomConfigFile
 * Author:   caishengzhi
 * Date:     2020/3/31 22:29
 * Description: 自定义配置文件路径测试
 */
package log.log4j2;


import log.Log4JBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.io.File;

/**
 *
 * 自定义配置文件路径测试
 *
 * @author: codefans
 * @Date: 2020/03/31 22:29
 * @since: 1.0.0
 */
public class CustomConfigFile extends Log4JBase {

    /**
     * log变量
     */
    private static Logger log;

    public static void main(String[] args) {

        String fileName = "log4j2_v2_13_1.properties";
        String propFile = OPEN_SOURCE_RESOURCES_LOG4J2 + File.separator + fileName;
        System.out.println("propFile:" + propFile);

        //初始化方式1
        System.setProperty("log4j.configurationFile", propFile);
//            System.setProperty("log4j.configurationFile", "classpath:log4j/log4j2_le_risk.xml");

        //初始化方式2
//            File log4jFile = new File(propFile);
//            ConfigurationSource source = new ConfigurationSource(new FileInputStream(log4jFile), log4jFile);
//            Configurator.initialize(null, source);

        //初始化方式3
//            File log4jFile = new File(propFile);
//            LoggerContext loggerContext = (LoggerContext) LogManager.getContext(false);
//            loggerContext.setConfigLocation(log4jFile.toURI());

        /**
         * Log4J2
         */
        log = LogManager.getLogger(CustomConfigFile.class);

        /**
         * Slf4J
         */
//        log = LoggerFactory.getLogger(CustomConfigFile.class);

        log.error("custom log config file, path={}", propFile);

    }

}