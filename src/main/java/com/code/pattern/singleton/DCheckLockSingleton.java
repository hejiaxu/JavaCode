package com.code.pattern.singleton;

/**
 * Created by hejiaxu on 2021/3/8
 */
public class DCheckLockSingleton {
    public static DCheckLockSingleton instance = null;

    private DCheckLockSingleton() {}

    public DCheckLockSingleton getInstance() {
        if (instance == null) {
            synchronized (DCheckLockSingleton.class) {
                if (instance == null) {
                    instance = new DCheckLockSingleton();
                }
            }
        }

        return instance;
    }
}
