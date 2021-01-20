package com.banulp.rediscache.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;

@Configuration
@EnableCaching
public class RedisCacheConfig {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig().disableCachingNullValues()
                .computePrefixWith(CacheKeyPrefix.simple())
                .entryTtl(Duration.ofMillis(100000))
                .serializeValuesWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));

        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(connectionFactory)
                .cacheDefaults(configuration)
                .withInitialCacheConfigurations(new HashMap<String, RedisCacheConfiguration>()).build();
    }
}
