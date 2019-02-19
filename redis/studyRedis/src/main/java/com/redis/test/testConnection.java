package com.redis.test;

import redis.clients.jedis.Jedis;

/**
 * 测试连接
 *
 * @authorHmLzp
 * @create 2019 - 02 - 17 14:47
 */
public class testConnection {

    public static void main(String[] args) {
        //构造方法中输入 自己的IP   本机直接输入 localhost  下面是我虚拟机的IP
        Jedis jedis = new Jedis("192.168.0.113");
        String jedis1 = jedis.set("jedis", "测试连接!");
        System.out.println(jedis1);//成功返回 OK
    }
}
