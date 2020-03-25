package com.jk.test.redis;

import redis.clients.jedis.Jedis;

public class Redis {
    public static void main(String[] args) {
        String host="127.0.0.1";
        int port=6379;
        Jedis jedis=new Jedis(host,port);
        System.out.println("ping为:  "+jedis.ping());
        //jedis.auth("zy");
        jedis.set("name", "james");
        String name=jedis.get("name");
        System.out.println("value是： "+name);
    }


}
