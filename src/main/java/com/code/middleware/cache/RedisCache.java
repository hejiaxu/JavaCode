package com.code.middleware.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hejiaxu on 2021/1/6
 */
public class RedisCache {

    Map<String, AtomicInteger> map = new ConcurrentHashMap<>();

    // AtomicInteger 类主要利用 CAS (compare and swap) + volatile 和 native 方法来保证原子操作，从而避免 synchronized 的高开销，执行效率大为提升。
    //
    // CAS的原理是拿期望的值和原本的一个值作比较，如果相同则更新成新的值。UnSafe 类的 objectFieldOffset() 方法是一个本地方法，这个方法是用来拿到“原来的值”的内存地址，返回值是 valueOffset。
    // 另外 value 是一个volatile变量，在内存中可见，因此 JVM 可以保证任何时刻任何线程总能拿到该变量的最新值。
    public int incr(String key) {
        if (map.containsKey(key)) {
            return map.get(key).incrementAndGet();
        } else {
            synchronized (key) {
                if (map.containsKey(key)) {
                    return map.get(key).incrementAndGet();
                } else {
                    map.put(key, new AtomicInteger(1));
                    return 1;
                }
            }
        }
    }
}
