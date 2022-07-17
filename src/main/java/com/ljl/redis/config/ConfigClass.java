package com.ljl.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;


//---------------------  第三步， 定义ridis配置类，配置redis默认工具类泛型
@Configuration
public class ConfigClass {
    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory
                                                               factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String,
                Object>();
        redisTemplate.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new
                Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL,
                JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        StringRedisSerializer stringRedisSerializer = new
                StringRedisSerializer();
// key采用String的序列化方式,默认是object
        redisTemplate.setKeySerializer(stringRedisSerializer);
// hash的key也采用String的序列化方式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
// value序列化方式采用jackson
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
// hash的value序列化方式采用jackson
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
