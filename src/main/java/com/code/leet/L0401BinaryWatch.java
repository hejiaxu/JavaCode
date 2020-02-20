package com.code.leet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class L0401BinaryWatch {

    Map<Integer, List<StringBuilder>> hourMap = new HashMap <>();
    Map<Integer, List<StringBuilder>> minuteMap = new HashMap <>();
    public List<String> readBinaryWatch(int num) {
        List<String> r = new LinkedList <>();
        initHourMap();
        initMinuteMap();
        // check bound , it may occur null pointer, or it can be avoided by check map.get
        for (int i = 0; i <= (num > 3 ? 3 : num); i++) {
            List<StringBuilder> hour = new LinkedList <>();
            List<StringBuilder> minute = new LinkedList <>();
            combineHM(r, hourMap.get(i), minuteMap.get(num - i));
        }
        return r;
    }

    private void initHourMap() {
        for (int i = 0; i < 12; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            int key = countOne(i);
            List<StringBuilder> sbs = null;
            if ( hourMap.containsKey(key) ) {
                sbs = hourMap.get(key);
            } else {
                sbs = new LinkedList <>();
                hourMap.put(key, sbs);
            }
            sbs.add(sb);
        }

    }

    private int countOne(int num) {
        int count = 0;
        while(num > 0) {
            count++;
            num = num & num - 1;
        }
        return count;
    }

    private void initMinuteMap() {
        for (int i = 0; i < 60; i++) {
            StringBuilder sb = new StringBuilder();
            if (i < 10) {
                sb.append("0");
            }
            sb.append(i);
            int key = countOne(i);
            List<StringBuilder> sbs = null;
            if ( minuteMap.containsKey(key) ) {
                sbs = minuteMap.get(key);
            } else {
                sbs = new LinkedList <>();
                minuteMap.put(key, sbs);
            }
            sbs.add(sb);
        }
    }

    private void combineHM(List <String> r, List <StringBuilder> hours, List <StringBuilder> minutes) {
        //check, it may get null pointer
        if ( hours == null || minutes == null ) return;
        for (StringBuilder hour: hours) {
            for (StringBuilder minute: minutes
                 ) {
                r.add(new StringBuilder().append(hour).append(":").append(minute).toString());
            }
        }
    }

    public static void main(String[] args) {
        List <String> strings = new L0401BinaryWatch().readBinaryWatch(1);
        for (String str :
                strings) {
            System.out.println(str);
        }
    }
}
