package com.zlzkj.app.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;  

/** 
 * 动态数据源 
 *  
 * @author geloin 
 * @date 2012-5-18 下午3:20:51 
 */  
public class DynamicDataSource extends AbstractRoutingDataSource {  
  
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
  
    /** 
     *  
     * @author geloin 
     * @date 2012-5-18 下午4:06:44 
     * @return the currentLookupKey 
     */  
    public static String getCurrentLookupKey() {  
        return (String) contextHolder.get();  
    }  
  
    /** 
     *  
     * @author geloin 
     * @date 2012-5-18 下午4:06:44 
     * @param currentLookupKey 
     *            the currentLookupKey to set 
     */  
    public static void setCurrentLookupKey(String currentLookupKey) {  
        contextHolder.set(currentLookupKey);  
    }  
  
    /* 
     * (non-Javadoc) 
     *  
     * @see 
     * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource# 
     * determineCurrentLookupKey() 
     */  
    @Override  
    protected Object determineCurrentLookupKey() {  
        return getCurrentLookupKey();  
    }  
  
} 