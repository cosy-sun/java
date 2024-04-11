package com.cosy.sun.jdk.newj;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Parameter;
import java.time.temporal.ValueRange;
import java.util.Arrays;
import java.util.Base64;
import java.util.TreeMap;

public class Java15NewFunc {

    interface innerInterface {
        void inter();
    }

    /**
     * record关键字,
     * 可以自己生成get, set, tostring, construct
     * 在构造器里面可以修改字段
     */
    public void recordNew() {
        record InnerBean(String name, String id) implements innerInterface {
            public void run() {
                System.out.println(name+id);
            }

            @Override
            public void inter() {
                System.out.println(name);
            }
//            InnerBean {
//                name = "1";
//                id = "2";
//            }
        }

        InnerBean innerBean = new InnerBean("sun", "10");
        innerBean.run();
        innerBean.inter();
    }

    /**
     * string中添加isempty方法
     *
     * 优化substring方法的子字符串空处理
     *
     * 增加unicode支持， 添加字符
     *
     */
    public void substr() {
        String str = "";
        str.substring(1);
    }


    /**
     * treemap新增方法 putifabsent
     */
    public void treeMapEnhance() {
        TreeMap map = new TreeMap();
        map.putIfAbsent("", "");
        map.computeIfAbsent("", item -> "123");

//        map.computeIfPresent();
//        map.compute();
//        map.merge();

    }

    /**
     * 性能改进  inflateoutputstream.write
     */

    public void valueRange() {
        ValueRange valueRange = ValueRange.of(1, 100, 1000);
        System.out.println(valueRange);
    }

    /**
     * 隐藏类
     */
    public void hiddleCLass() throws IllegalAccessException, InstantiationException {
        String classStr = "yv66vgAAAD0AKQoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCQAIAAkHAAoMAAsADAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsKAAIADgwADwAQAQAIZ2V0Q2xhc3MBABMoKUxqYXZhL2xhbmcvQ2xhc3M7CgASABMHABQMABUAFgEAD2phdmEvbGFuZy9DbGFzcwEAB2dldE5hbWUBABQoKUxqYXZhL2xhbmcvU3RyaW5nOwoAGAAZBwAaDAAbABwBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgcAHgEAH2NvbS9jb3N5L3N1bi9qZGsvbmV3ai9IZWxsb0ltcGwHACABABtjb20vY29zeS9zdW4vamRrL25ld2ovSGVsbG8BAARDb2RlAQAPTGluZU51bWJlclRhYmxlAQASTG9jYWxWYXJpYWJsZVRhYmxlAQAEdGhpcwEAIUxjb20vY29zeS9zdW4vamRrL25ld2ovSGVsbG9JbXBsOwEABWhlbGxvAQAKU291cmNlRmlsZQEAEkphdmExNU5ld0Z1bmMuamF2YQAgAB0AAgABAB8AAAACAAAABQAGAAEAIQAAAC8AAQABAAAABSq3AAGxAAAAAgAiAAAABgABAAAAYAAjAAAADAABAAAABQAkACUAAAABACYABgABACEAAAA8AAIAAQAAAA6yAAcqtgANtgARtgAXsQAAAAIAIgAAAAoAAgAAAGQADQBlACMAAAAMAAEAAAAOACQAJQAAAAEAJwAAAAIAKA==";
        byte[] decode = Base64.getDecoder().decode(classStr);
        Class<?> aClass = MethodHandles.lookup()
                .defineHiddenClass(decode, true, MethodHandles.Lookup.ClassOption.NESTMATE)
                .lookupClass();
        Object o = aClass.newInstance();
        Hello hello = (Hello) o;
        hello.hello();
        System.out.println(hello.getClass().getName());
        System.out.println(hello.getClass().getCanonicalName());
        System.out.println(hello.getClass().getPackageName());
        Arrays.stream(hello.getClass().getMethods()).forEach(item -> {
            String name = item.getName();
            Class<?> returnType = item.getReturnType();
            Parameter[] parameters = item.getParameters();
            System.out.println(name);
            System.out.println(returnType.getCanonicalName());
            System.out.println(parameters.length);
        });

    }
}

class HelloImpl implements Hello {

    @Override
    public void hello() {
        System.out.println(this.getClass().getName());
    }
}

interface Hello {
    void hello();
}
