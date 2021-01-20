package com.banulp.rediscache;

import com.banulp.rediscache.model.BanulpUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RediscacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RediscacheApplication.class, args);
	}

}
