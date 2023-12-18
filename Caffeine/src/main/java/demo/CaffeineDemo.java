package demo;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
@EnableCaching
public class CaffeineDemo {

    final
    Cache<String, Object> caffeineCache;

    final
    SpringCache springCache;

    public CaffeineDemo(Cache<String, Object> caffeineCache, SpringCache springCache) {
        this.caffeineCache = caffeineCache;
        this.springCache = springCache;
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CaffeineDemo.class, args);
        Cache<String, Object> cacheBean = run.getBean(Cache.class);
        int countTimes = 10;
        System.out.println("no cache, we try to get value. But only key attained ");
        for (int i = 0; i < countTimes; i++) {
            String string = (String) cacheBean.get("key" + i, Function.identity());
            System.out.println(string);
        }
        System.out.println("add cache");
        for (int i = 0; i < countTimes; i++) {
            cacheBean.put("key" + i, "value" + i);
        }
        System.out.println("\n");
        for (int i = 0; i < countTimes; i++) {
            System.out.println(cacheBean.getIfPresent("key" + i));
            cacheBean.asMap().remove("key" + i);
        }
        System.out.println("\n");
        System.out.println("delete cache");
        for (int i = 0; i < countTimes; i++) {
            System.out.println(cacheBean.get("key" + i, Function.identity()));
        }
        System.out.println("\n\n");
        System.out.println("combine spring boot cache");
        SpringCache springCache1 = run.getBean(SpringCache.class);


        for (int i = 0; i < countTimes; i++) {
            System.out.println(springCache1.get("key" + i));
        }
        System.out.println();
        for (int i = 0; i < countTimes; i++) {
            springCache1.put("key"+i , String.valueOf(i));
        }
        System.out.println();
        for (int i = 0; i < countTimes; i++) {
            System.out.println(springCache1.get("key" + i));
        }
        System.out.println();
        for (int i = 0; i < countTimes; i++) {
            springCache1.delete("key"+i);
        }
        System.out.println();
        for (int i = 0; i < countTimes; i++) {
            System.out.println(springCache1.get("key" + i));
        }

        }

    }

