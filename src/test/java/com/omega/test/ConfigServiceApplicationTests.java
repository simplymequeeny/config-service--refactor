package com.omega.test;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigServiceApplicationTests {
	
	static String IS_SHUTDOWN_MODE_KEY = "isShutdownMode";
	
	@SpyBean
	ConfigServiceCachedImpl service;
	
	@Autowired
	CacheManager cacheManager;
	
	@Before
	public void init() {
		Assert.notNull(cacheManager, "cacheManager is null");
		Assert.notNull(service, "configCachedService is null");
		
		service.getValue(IS_SHUTDOWN_MODE_KEY);
	}
	
	@Test
	public void registryHashesCacheNameShouldExists() {
		Assert.notNull(cacheManager.getCache(CacheConfig.CACHE_NAME), "cache name not found");
	}
	
	@Test
	public void isShutdownModeKeyValueShouldBeInCache() {
		Assert.notNull(cacheManager
						.getCache(CacheConfig.CACHE_NAME)
						.get(IS_SHUTDOWN_MODE_KEY).get(), 
				"isShutdownMode value not in cache");
	}
	
	@Test
	public void findMapKeyShouldNotBeCalledTwiceWhenKeyIsAlreadyInCache() {
		service.getValue(IS_SHUTDOWN_MODE_KEY);
		
		verify(service, times(1)).getValue(IS_SHUTDOWN_MODE_KEY);
	}
}
