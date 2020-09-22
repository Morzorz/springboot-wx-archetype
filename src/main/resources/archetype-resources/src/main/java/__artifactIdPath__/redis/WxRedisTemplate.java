package ${basepackage}.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import ${basepackage}.propreties.AppsPropreties;

import java.util.concurrent.TimeUnit;


/**
 * Created by yangjingting on 2020/9/22.
 */
@Slf4j
@Component
public class WxRedisTemplate {


    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private AppsPropreties appsPropreties;

    private static final String KEY_SPLIT = ":"; //用于隔开缓存前缀与缓存键值

    /**
     * 设置缓存
     * @param prefix 缓存前缀（用于区分缓存，防止缓存键值重复）
     * @param key    缓存key
     * @param value  缓存value
     */
    public void set(String prefix, String key, String value) {


        redisTemplate.opsForValue().set(prefix + KEY_SPLIT + key, value);
        log.debug("RedisUtil:set cache key={},value={}", prefix + KEY_SPLIT + key, value);
    }

    /**
     * 设置缓存，并且自己指定过期时间
     * @param prefix
     * @param key
     * @param value
     * @param expireTime 过期时间
     */
    public void setWithExpireTime(String prefix, String key, String value, int expireTime) {
        redisTemplate.opsForValue().set(prefix + KEY_SPLIT + key,value,expireTime, TimeUnit.SECONDS);
        log.debug("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", prefix + KEY_SPLIT + key, value,
                expireTime);
    }

    /**
     * 设置缓存，并且由配置文件指定过期时间
     * @param prefix
     * @param key
     * @param value
     */
    public void setWithExpireTime(String prefix, String key, String value) {
        long EXPIRE_SECONDS = appsPropreties.getAccessTokenExpires();
        redisTemplate.opsForValue().set(prefix + KEY_SPLIT + key,value,EXPIRE_SECONDS, TimeUnit.SECONDS);
        log.debug("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", prefix + KEY_SPLIT + key, value,
                EXPIRE_SECONDS);
    }

    /**
     * 获取指定key的缓存
     * @param prefix
     * @param key
     */
    public String get(String prefix, String key) {
        String value = (String) redisTemplate.opsForValue().get(prefix + KEY_SPLIT + key);
        log.debug("RedisUtil:get cache key={},value={}", prefix + KEY_SPLIT + key, value);
        return value;
    }

    /**
     * 判断key是否存在
     * @param prefix
     * @param key
     * @return
     */
    public boolean exit(String prefix, String key){
        return redisTemplate.hasKey(prefix + KEY_SPLIT + key);
    }

    /**
     * 删除指定key的缓存
     * @param prefix
     * @param key
     */
    public void deleteWithPrefix(String prefix, String key) {
        redisTemplate.delete(prefix + KEY_SPLIT + key);
        log.debug("RedisUtil:delete cache key={}", prefix + KEY_SPLIT + key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
        log.debug("RedisUtil:delete cache key={}", key);
    }
}
