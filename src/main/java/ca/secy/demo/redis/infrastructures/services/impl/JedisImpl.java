package ca.secy.demo.redis.infrastructures.services.impl;

import ca.secy.demo.redis.infrastructures.services.RedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Yankam Cedric Singhor <cyankam@gmail.com>
 */
@Component
public class JedisImpl implements RedisService<JedisPool> {

  @Value("${spring.data.redis.port}")
  private int portRedis;

  @Value("${spring.data.redis.host}")
  private String hostRedis;

  @Override
  public JedisPool getInstance() {
    return new JedisPool(new JedisPoolConfig(), hostRedis, portRedis);
  }
}
