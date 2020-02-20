package com.code.leet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
Suppose Andy and Doris want to choose a restaurant for dinner,
and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum.
If there is a choice tie between answers, output all of them with no order requirement.
 You could assume there always exists an answer.

 */
public class L0599MinimumIndexSumofTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap <>();
        List<String> list = new LinkedList <>();
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                Integer val = map.get(list2[i]);
                if (sum == Integer.MAX_VALUE) {
                    list.add(list2[i]);
                    sum = val + i;
                } else if(sum == val + i) {
                    list.add(list2[i]);
                } else if (sum > val + i) {
                    list.clear();
                    sum = val + i;
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}
