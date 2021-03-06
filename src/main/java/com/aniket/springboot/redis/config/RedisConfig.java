package com.aniket.springboot.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.aniket.springboot.redis.entity.User;

@Configuration
public class RedisConfig {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {

		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, User> redisTemplate() {

		final RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();

		redisTemplate.setConnectionFactory(jedisConnectionFactory());

		return redisTemplate;
	}
}
