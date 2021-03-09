package com.aniket.springboot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.aniket.springboot.redis.config.RedisConfig;

@Import({ RedisConfig.class })
@SpringBootApplication
public class RedisAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(RedisAppApplication.class, args);
	}

}
