package com.cosy.sun.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class ZkTest {

    private CuratorFramework build = null;

    @Before
    public void setup() throws Exception {
        build = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181")
                .sessionTimeoutMs(3000)
                .connectionTimeoutMs(3000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        build.start();
        build.blockUntilConnected();
    }

    @Test
    public void test3() throws Exception {
        String basePath = "/sharelocks";
        InterProcessMutex interProcessMutex = new InterProcessMutex(build, basePath);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    interProcessMutex.acquire();
                    System.out.println(Thread.currentThread().getName() + "获取锁");
                    Thread.sleep(5000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        interProcessMutex.release();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + "释放锁");
                }
            }).start();
        }
        System.in.read();
    }

    @Test
    public void test() throws Exception {
//        String s = build.create().creatingParentContainersIfNeeded().forPath("/locks/child");
//        System.out.println(s);
        String s = build.create().creatingParentContainersIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/locks/child/tmp1", "tmp节点".getBytes());
//        build.delete().deletingChildrenIfNeeded().forPath("/locks");
        build.delete().deletingChildrenIfNeeded().forPath("/locks");

        String s1 =  build.create().creatingParentContainersIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/locks/child/tmp1", "tmp节点".getBytes());
        Stat stat = new Stat();
        byte[] bytes = build.getData().storingStatIn(stat).forPath("/locks/child/tmp1");
        System.out.println(bytes);
        System.out.println(stat.getVersion());
        System.out.println(stat.getEphemeralOwner());
        System.out.println(stat);
        Stat stat1 = build.checkExists().forPath("/locks/child");
        if (stat1 == null) {
            System.out.println("znode not exists ");
        } else {
            build.setData().withVersion(stat.getVersion()).forPath("/locks/child", "sunzhenhua".getBytes(StandardCharsets.UTF_8));
        }

    }

    @Test
    public void test2() throws Exception {
        NodeCache nodeCache = new NodeCache(build, "/locks/child");
        nodeCache.getListenable().addListener(() -> {
                    System.out.println("发生事件" + nodeCache.getCurrentData().getPath());
                    System.out.println("新数据：" + nodeCache.getCurrentData().getData());
                });
        nodeCache.start();
        System.in.read();
    }

}
