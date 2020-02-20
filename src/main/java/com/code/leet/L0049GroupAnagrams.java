package com.code.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"]
 */
public class L0049GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long, Integer> map = new LinkedHashMap <>(strs.length);
        List<List<String>> r = new ArrayList <>();

        for (int i = 0; i < strs.length; i++) {
            long hashcode = getHashcode(strs[i]);
            if (map.containsKey(hashcode)) {
                Integer integer = map.get(hashcode);
                List <String> strings = r.get(integer);
                strings.add(strs[i]);
            } else {
                int val = r.size();
                map.put(hashcode, val);
                ArrayList <String> strings = new ArrayList <>();
                strings.add(strs[i]);
                r.add(strings);
            }

        }

        return r;
    }

    private long getHashcode(String str) {
        long add = 0;
        long multiply = 1;
        long xor = 1;
        for (int i = 0; i < str.length(); i++) {
            add += str.charAt(i);
            multiply *= str.charAt(i) * (str.charAt(i) + 'a');
            xor ^= str.charAt(i);
        }

        return add ^ multiply ^ xor;
    }

    public static void main(String[] args) {
        String[] strs = {"gos","awl","rot","ram","gus","ira","dry","win","add","yuk","gum","ian","don","bet","fed","gap","eng","mow","cop","rev","ono","guy","yen","nil","ian","ebb","fez","ate","may","dip","cut","sox","wag","ike","eke","ill","bit","moo","ibo","ron","too","sky","fob","brr"};
        List <List <String>> lists = new L0049GroupAnagrams().groupAnagrams(strs);
        for (int i = 0; i < lists.size(); i++) {
            List <String> strings = lists.get(i);
            for (int j = 0; j < strings.size(); j++) {
                String s = strings.get(j);

                System.out.print(s + " ");
            }
            System.out.println();
        }

        long add = new L0049GroupAnagrams().getHashcode("may");
        long ebb = new L0049GroupAnagrams().getHashcode("maxG");
        System.out.println(add + "  " + ebb);

    }
}
