package com.omega.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

public class ConfigServiceImpl implements ConfigService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    protected RegistryHashRepository registryHashRepository;

    @Cacheable(value="registryHashes", sync=true)
    public String getValue(String key) {
    	log.info("key " + key + " not in cache");
        RegistryHash retVal = registryHashRepository.findByMapkey(key);
        if (retVal == null) {
            return null;
        } else {
            return retVal.getValue();
        }
    }

    @Cacheable(value="registryHashes", sync=true)
    public Integer getIntValue(String key) {
    	log.info("key " + key + " not in cache");
        return Integer.parseInt(getValue(key));
    }

    @Cacheable(value="registryHashes", sync=true)
    public Boolean getBooleanValue(String key) {
    	log.info("key " + key + " not in cache");
        return Boolean.parseBoolean(getValue(key));
    }

    public void cleanupCache() {
    	// do nothing here
    }
    
    public RegistryHashRepository getRegistryHashRepository() {
        return registryHashRepository;
    }
}
