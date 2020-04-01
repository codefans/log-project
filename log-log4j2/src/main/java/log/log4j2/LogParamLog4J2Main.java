/**
 * Copyright (C), 2015-2020, 京东
 * FileName: LogParamMain
 * Author:   caishengzhi
 * Date:     2020/3/31 22:03
 * Description: 打印参数测试类
 */
package log.log4j2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

/**
 *
 * 打印参数测试类
 *
 * https://blog.csdn.net/macrun28/article/details/90669513
 *
 * @author: codefans
 * @Date: 2020/03/31 22:03
 * @since: 1.0.0
 */
public class LogParamLog4J2Main {

    private static Logger log = LogManager.getLogger(LogParamLog4J2Main.class);

    public static void main(String[] args) {
        try {

            /**
             * 设置log4j2.xml文件参数
             */
            String key = "traceId";
            ThreadContext.put(key, "Log4J2TraceId123456");

            log.info("hello world!");
            log.debug("hello world from debug info");
            log.error("error....hahaha");

            System.out.println("hdfdlfjlfkdsalfds");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}