package com.code.pattern.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hejiaxu on 2021/4/26
 */
public class Delegate {

    public final static Map<String, Handler> map = new HashMap<>();
    static {
        map.put("map", new MapHandler());
        map.put("url", new UrlHandler());
    }

    void execute(String type) {
        Handler handler = map.get(type);
        if (handler == null) {
            return;
        }
        handler.execute();
    }

    public static void main(String[] args) {

    }


}
