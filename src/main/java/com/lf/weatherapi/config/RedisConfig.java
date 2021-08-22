package com.lf.weatherapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class RedisConfig {

    @Bean
    JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(10);
        poolConfig.setMaxIdle(5);
        poolConfig.setMinIdle(1);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        return poolConfig;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) throws URISyntaxException {

        String envRedisUrl = System.getenv("REDIS_URL");
        boolean isHerokuRedis = true;
        if (envRedisUrl == null) {
            isHerokuRedis = false;
            envRedisUrl = "http://redis:6379/";
        }
        URI redisUri = new URI(envRedisUrl);

        RedisStandaloneConfiguration hostConfig = new RedisStandaloneConfiguration();
        hostConfig.setPort(redisUri.getPort());
        hostConfig.setHostName(redisUri.getHost());
        if (isHerokuRedis) {
            hostConfig.setPassword(redisUri.getUserInfo().split(":", 2)[1]);
        }

        JedisClientConfiguration.JedisClientConfigurationBuilder builder = JedisClientConfiguration.builder();
        JedisClientConfiguration clientConfig = builder.usePooling().poolConfig(jedisPoolConfig).build();

        return new JedisConnectionFactory(hostConfig, clientConfig);
    }
}
