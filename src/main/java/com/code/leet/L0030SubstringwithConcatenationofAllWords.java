package com.code.leet;

import java.util.*;

/*
You are given a string, s, and a list of words, words, that are all of the same length.
Find all starting indices of substring(s) in s that is a concatenation of each word in words
 exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 */
public class L0030SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring2(String s, String[] words) {
        int N = words.length;
        int M = words[0].length();
        List<Integer> r = new LinkedList <>();
        int start = 0;
        HashMap<String, Integer> map = new LinkedHashMap<>();
        while (start < M) {
            int count = words.length;
            map.clear();
            for(String word : words) {
                map.put(word, map.getOrDefault(word, 0 ) + 1);
            }
            int left = start;
            while(left + M <= s.length()) {
                String str = s.substring(left, left + M);
                if (left >= N * M) {
                    String prestr = s.substring(left - N * M, left + M - N * M);
                    if (map.containsKey(prestr)) {
                        Integer integer = map.get(prestr);
                        map.put(prestr, integer + 1);
                        if (integer >= 0) {
                            count++;
                        }
                    }
                }
                if (map.containsKey(str)) {
                    Integer integer = map.get(str);
                    map.put(str, integer - 1);
                    if (integer > 0) {
                        count--;
                    }
                    if (count == 0) {
                        r.add(left + M - N * M);
                    }
                }
                left += M;
            }
            start++;
        }
        return r;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int N = s.length();
        List<Integer> indexes = new ArrayList<Integer>(s.length());
        if (words.length == 0) {
            return indexes;
        }
        int M = words[0].length();
        if (N < M * words.length) {
            return indexes;
        }
        int last = N - M + 1;

        //map each string in words array to some index and compute target counters
        Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
        int [][] table = new int[2][words.length];
        int failures = 0, index = 0;
        for (int i = 0; i < words.length; ++i) {
            Integer mapped = mapping.get(words[i]);
            if (mapped == null) {
                ++failures;
                mapping.put(words[i], index);
                mapped = index++;
            }
            ++table[0][mapped];
        }

        //find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
        int [] smapping = new int[last];
        for (int i = 0; i < last; ++i) {
            String section = s.substring(i, i + M);
            Integer mapped = mapping.get(section);
            if (mapped == null) {
                smapping[i] = -1;
            } else {
                smapping[i] = mapped;
            }
        }

        //fix the number of linear scans
        for (int i = 0; i < M; ++i) {
            //reset scan variables
            int currentFailures = failures; //number of current mismatches
            int left = i, right = i;
            Arrays.fill(table[1], 0);
            //here, simple solve the minimum-window-substring problem
            while (right < last) {
                while (currentFailures > 0 && right < last) {
                    int target = smapping[right];
                    if (target != -1 && ++table[1][target] == table[0][target]) {
                        --currentFailures;
                    }
                    right += M;
                }
                while (currentFailures == 0 && left < right) {
                    int target = smapping[left];
                    if (target != -1 && --table[1][target] == table[0][target] - 1) {
                        int length = right - left;
                        //instead of checking every window, we know exactly the length we want
                        if ((length / M) ==  words.length) {
                            indexes.add(left);
                        }
                        ++currentFailures;
                    }
                    left += M;
                }
            }

        }
        return indexes;
    }

    public static void main(String[] args) {
        String s = "aaa";
        String[] words = {"aa","aa"};
//        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
//        String[] words = {"fooo","barr","wing","ding","wing"};
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"word","good","best","good"};
//        String s = "barfoofoobarthefoobarman";
//        String[] words = {"bar","foo","the"};
//        String s = "barfoothefoobarman";
//        String[] words = {"foo","bar"};
        List <Integer> substring = new L0030SubstringwithConcatenationofAllWords().findSubstring(s, words);
        for (Integer i :
                substring) {
            System.out.println(i);
        }
    }
}
