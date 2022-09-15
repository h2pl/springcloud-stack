package com.example.userservice.redis;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author hpl
 * @date 2022/9/15 11:32
 */
public class TestLock {
    public static void main(String[] args) {
        // 1. Create config object
        Config config = new Config();
        config.useClusterServers()
                // use "rediss://" for SSL connection
                .addNodeAddress("redis://127.0.0.1:7181");

// or read config from file
        try {
            config = Config.fromYAML(new File("config-file.yaml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 2. Create Redisson instance

// Sync and Async API
        RedissonClient redisson = Redisson.create(config);

// Reactive API
        RedissonReactiveClient redissonReactive = redisson.reactive();

// RxJava3 API
        RedissonRxClient redissonRx = redisson.rxJava();

        // 3. Get Redis based implementation of java.util.concurrent.ConcurrentMap
        RMap<String, String> map = redisson.getMap("myMap");

        // 4. Get Redis based implementation of java.util.concurrent.locks.Lock
        RLock lock = redisson.getLock("myLock");

        lock.lock(1000, TimeUnit.MILLISECONDS);

        lock.unlock();
        RLock redLock = redisson.getRedLock(lock);

        redLock.lock();
        redLock.unlock();

    }
}
