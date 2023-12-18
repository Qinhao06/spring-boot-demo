package demo;


import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringCache {
    @CachePut(key = "#key", cacheNames = "demo")
    public String put(String key, String s){
        return s;
    }

    @Cacheable(key = "#string", cacheNames = "demo")
    public String get(String string){
        return "value";
    }

    @CacheEvict(key = "#string", cacheNames ="demo")
    public String delete(String string){
        return "delete";
    }




}
