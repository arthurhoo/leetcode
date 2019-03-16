package com.arthur.codes.jvm.classloader;

/**
 * @author: Arthur Hu
 * @date: 2018/11/5 下午4:32
 * Description:
 */

/**
 * 1. 通过 JVM 参数 -verbose:class 来打印类加载顺序，并且在 LazyHolder 的初始化方法中打印特定字样。
 * 2. 创建数组，观察是否导致Singleton类加载和初始化
 * 3. 创建数组是否导致链接
 */
public class Singleton {
    private Singleton() {}
    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
        static {
            System.out.println("LazyHolder.<clinit>");
        }
    }
    public static Object getInstance(boolean flag) {
        if (flag) {
            return new LazyHolder[2];
        }
        return LazyHolder.INSTANCE;
    }
    public static void main(String[] args) {
        getInstance(true);
        System.out.println("----");
        getInstance(false);
    }


    /**
     * 执行如下代码：
     * $ java -cp /path/to/asmtools.jar org.openjdk.asmtools.jdis.Main Singleton\$LazyHolder.class > Singleton\$LazyHolder.jasm.1
     $ awk 'NR==1,/stack 1/{sub(/stack 1/, "stack 0")} 1' Singleton\$LazyHolder.jasm.1 > Singleton\$LazyHolder.jasm
     $ java -cp /path/to/asmtools.jar org.openjdk.asmtools.jasm.Main Singleton\$LazyHolder.jasm
     $ java -verbose:class Singleton
     */
}
