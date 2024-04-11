package com.cosy.sun.jdk.newj;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.Stream;

public class Java17NewFunc {

    /**
     * 伪随机生成器
     *
     */
    public void random() {
        RandomGeneratorFactory<RandomGenerator> randomFactory = RandomGeneratorFactory.of("");
        RandomGenerator randomGenerator = randomFactory.create(System.currentTimeMillis());
        System.out.println(randomGenerator.nextInt(8));
    }

    /**
     * stream.tolist
     */
    public void stream() {
        Stream stringStream = Stream.of("1", "2");
        List<String> list = stringStream.toList();
    }

    /**
     * nullpointexceptions优化输出内容
     */

    /**
     * 支持上下文序列化的过滤器
     * 以通过系统属性 jdk.serialFilter 来配置，也可以通 ObjectInputFilter.Config#setSerialFilter 来设置
     */

}
