package com.code.pattern.singleton;

/**
 * Created by hejiaxu on 2021/3/8
 */
public class StaticSingleton {
    public static final StaticSingleton instance = new StaticSingleton();
    private StaticSingleton() {}

    /**
     * 类被加载时，静态变量instance会被初始化，此时该类的私有构造函数被调用，这时候，单例类的唯一实例就被创建出来了
     */
    public StaticSingleton getInstance() {
        return instance;
    }
}
