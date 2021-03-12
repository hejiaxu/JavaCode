package com.code.syntax;

import java.util.HashMap;

/**
 * Created by hejiaxu on 2020/2/20
 */
public class HashMapCircle {
    /**
     * 1.table & bucket存储结构: bucket > 8时，进行treeify
     * 2.默认 loadFactory(lf) = 0.75 capacity = 16
     * 3.size > threshold 时进行resize
     * 4.threshold = tableSizeFor(fc), fc = size / lf
     */
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap();
        map.put("", "");
    }
}
