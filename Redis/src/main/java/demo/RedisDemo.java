package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedisDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RedisDemo.class, args);
        RedisTemplate bean = (RedisTemplate) run.getBean("redis");
        bean.opsForValue().set("name", "zhangsan");
        System.out.println(bean.opsForValue().get("name"));

    }

}
