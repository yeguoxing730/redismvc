package com.springapp.config;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/4/17
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport{
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
            JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();

        // Defaults
        redisConnectionFactory.setHostName("127.0.0.1");
        redisConnectionFactory.setPort(6379);
        return redisConnectionFactory;
//        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
//                .master("mymaster")
//                .sentinel("127.0.0.1", 6379);
////        new LettuceConnectionFactory(sentinelConfig);
//        return new JedisConnectionFactory(sentinelConfig);
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(cf);
        redisTemplate.setEnableTransactionSupport(true);
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(3000);
        return cacheManager;
    }

}
