package com.code.pattern.strategy;

/**
 * Created by hejiaxu on 2021/4/26
 */
public class NewToClose implements Action {

    @Override
    public void process() {
        System.out.println("close");

    }
}
