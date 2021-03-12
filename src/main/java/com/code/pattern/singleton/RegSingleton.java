package com.code.pattern.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hejiaxu on 2021/3/8
 */
public class RegSingleton {

    public final static Map<String, Object> map = new ConcurrentHashMap<>();

    protected RegSingleton () {}

    public static RegSingleton getInstance(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        if (!map.containsKey(name)) {
            synchronized (RegSingleton.class) {
                if (!map.containsKey(name)) {
                    Object regSingleton = Class.forName(name).newInstance();
                    map.put(name, regSingleton);
                }
            }
        }

        return (RegSingleton) map.get(name);
    }
}
