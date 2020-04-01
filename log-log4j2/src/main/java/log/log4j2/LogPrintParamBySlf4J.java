/**
 * Copyright (C), 2015-2020, 京东
 * FileName: LogPrintParamBySlf4J
 * Author:   caishengzhi
 * Date:     2020/3/31 22:28
 * Description: slf4j打印参数
 */
package log.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 *
 * slf4j打印参数
 *
 * https://blog.csdn.net/macrun28/article/details/90669513
 *
 * @author: codefans
 * @Date: 2020/03/31 22:28
 * @since: 1.0.0
 */
public class LogPrintParamBySlf4J {

    private static Logger log = LoggerFactory.getLogger(LogPrintParamBySlf4J.class);


    public static void main(String[] args) {

        /**
         * 设置log4j2.xml文件参数
         */
        String key = "traceId";
        MDC.put(key, "Slf4jTraceId");

        log.info("hello world!");
        log.debug("hello world from debug info");
        log.error("error....hahaha");

        System.out.println("hdfdlfjlfkdsalfds");

    }

}