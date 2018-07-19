package com.omega.test;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 *
 */
public class ConfigServiceCachedImpl extends ConfigServiceImpl {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Scheduled(fixedRate = 5 * 60)
    @CacheEvict(allEntries=true, cacheNames={"registryHashes"})
    public void cleanupCache() {
        log.info("cache cleaned @ " + new DateTime().toLocalDateTime());
    }
}
