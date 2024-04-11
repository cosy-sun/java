package com.cosy.sun.redis.jedis.bitmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class BitMap {

    @Autowired
    private Jedis jedis;

    public void setbit() {
        jedis.setbit("setbit", 1, true);
    }

}
