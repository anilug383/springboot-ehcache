package com.example.demo;

import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


@Configuration
public class CacheConfiguration {
	
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(CacheManagerEventListenerFactory().getObject());
	}

	private EhCacheManagerFactoryBean CacheManagerEventListenerFactory() {
		EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
		bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		bean.setShared(true);
		return bean;
	}

}
