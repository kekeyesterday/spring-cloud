package com.jimmy.spring.config.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class Xconfig extends PropertyPlaceholderConfigurer {
	private static Logger logger = LoggerFactory.getLogger(Xconfig.class);
	
	private static Properties xconfigProp = new Properties();
	
	static {
		 File cfFile = new File("C:/Users/zghdo/.xconfig/trip-web_daily/boot.properties");
		 
		 try {
			xconfigProp.load(new FileInputStream(cfFile));
			logger.info("========config文件加载结束================");
			String msg = xconfigProp.getProperty("trip-web.logging.package.name");
			logger.info("========msg================" + msg);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public  Properties  setConfig(){
		this.setProperties(xconfigProp);
		return xconfigProp;
	}
	
	  /**
     * 获取属性
     * @param key
     * @return
     */
    public static String getProperty(String key){

        return xconfigProp == null ? null :  xconfigProp.getProperty(key);

    }

    /**
     * 获取属性
     * @param key 属性key
     * @param defaultValue 属性value
     * @return
     */
    public static String getProperty(String key,String defaultValue){

         return xconfigProp == null ? null : xconfigProp.getProperty(key, defaultValue);

    }
}
