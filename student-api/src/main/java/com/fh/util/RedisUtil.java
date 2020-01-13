package com.fh.util;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    public static void set(String key,String value){
        Jedis jedis = JedisConnectionPool.getJedis();
        jedis.set(key,value);
        jedis.close();
    }

    public static String get(String key){
        Jedis jedis = JedisConnectionPool.getJedis();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }

    public static boolean exists(String key){
        Jedis jedis = JedisConnectionPool.getJedis();
        Boolean existed = jedis.exists(key);
        jedis.close();
        return existed;
    }

}
