package com.code.pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hejiaxu on 2021/4/29
 */
public class StrategyMachine {

    static Map<String, Action> map = new HashMap<>();

    public static void main(String[] args) {
        action("cancel");

    }

    public static void action(String act) {
        Action action = map.get(act);
        if (action != null) {
            action.process();
        }
    }
}
