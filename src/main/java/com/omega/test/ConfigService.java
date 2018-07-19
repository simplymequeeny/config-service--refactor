package com.omega.test;


/**
 */
public interface ConfigService {


    /**
     * Gets the specified value by key. null is returned if
     * the key is not found.
     */
    String getValue(String key);


    /**
     * Gets the specified value and converts to an integer. null is returned if
     * the key is not found.
     */
    Integer getIntValue(String key);



    /**
     * Gets the specified value and converts to an boolean. null is returned if
     * the key is not found.
     */
    Boolean getBooleanValue(String key);
    
    void cleanupCache();
}
