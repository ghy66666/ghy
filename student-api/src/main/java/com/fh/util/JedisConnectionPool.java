package com.fh.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionPool {

    //最大连接数
    private static final int MAX_TOTAL = 500;

    //最大空闲连接数
    private static final  int MAX_IDLE = 400;

    //最小空闲连接数
    private static final  int MIN_IDLE = 100;

    //redis服务IP地址
    private static final String REDIS_SERVER_IP = "192.168.73.128";

    //redis服务端口号
    private static final int REDIS_SERVER_PORT = 6379;

    private static JedisPool jedisPool;


    static{
        initPool();
    }

    private static void initPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(MAX_TOTAL);
        jedisPoolConfig.setMinIdle(MIN_IDLE);
        jedisPoolConfig.setMaxIdle(MAX_IDLE);
        //实例化一个jedis的连接池对象
        jedisPool = new JedisPool(jedisPoolConfig,REDIS_SERVER_IP,REDIS_SERVER_PORT);
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }


    public static void main(String[] args) {
        Jedis jedis = getJedis();
        jedis.set("name","gaohaiyang");
        System.out.println(jedis.get("name"));
        jedis.close();
    }

}
