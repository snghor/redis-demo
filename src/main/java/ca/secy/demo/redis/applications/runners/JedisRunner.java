package ca.secy.demo.redis.applications.runners;

import ca.secy.demo.redis.infrastructures.services.RedisService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Yankam Cedric Singhor <cyankam@gmail.com>
 */
@Component
@RequiredArgsConstructor
@Order(1)
public class JedisRunner implements ApplicationRunner {

  private final RedisService<JedisPool> redisService;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    try (Jedis jedis = redisService.getInstance().getResource()) {
      jedis.set("mykey", "Hello from Jedis");
      String value = jedis.get("mykey");
      System.out.println(value);

      jedis.zadd("vehicles", 0, "car");
      jedis.zadd("vehicles", 0, "bike");
      List<String> vehicles = jedis.zrange("vehicles", 0, -1);
      System.out.println(vehicles);
    }
  }
}
