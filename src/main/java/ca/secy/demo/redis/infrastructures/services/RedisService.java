package ca.secy.demo.redis.infrastructures.services;
/**
 * @author Yankam Cedric Singhor <cyankam@gmail.com>
 */
public interface RedisService<T> {
  T getInstance();
}
