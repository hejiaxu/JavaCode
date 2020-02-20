package com.code.leet;

import java.util.*;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
add spaces in s to construct a sentence where each word is a valid dictionary word.
You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 */
public class L0140WordBreakII {
    public static void main(String[] args) {
//        String s = "aaaaa";
        String s = "\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String [] word = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> wordDict = new LinkedList<>(Arrays.asList(word));
        long l = System.currentTimeMillis();
        List<String> list = new L0140WordBreakII().wordBreak(s, wordDict);
        System.out.println(System.currentTimeMillis() - l);
        long l2 = System.currentTimeMillis();
        List<String> list2 = new L0140WordBreakII().wordBreak2(s, wordDict);
        System.out.println(System.currentTimeMillis() - l2);
        long l3 = System.currentTimeMillis();
        List<String> list3 = new L0140WordBreakII().wordBreak3(s, wordDict);
//        for (String str: list) {
//            System.out.println(str);
//        }
        System.out.println(System.currentTimeMillis() - l3);
        System.out.println(list.size());
        System.out.println(list2.size());
        System.out.println(list3.size());
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        int maxLength = -1;
        for(String ss : wordDict) maxLength = Math.max(maxLength, ss.length());
        Set<String> set = new HashSet<>(wordDict);
        Map<String, List<String>> dp = new HashMap();
        for (int i = 0; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            List<String> list = dp.getOrDefault(sub, new LinkedList<>());
            if (set.contains(sub)) {
                list.add(sub);
            }
            for (int j = i - maxLength >= 0 ? i - maxLength : 0; j < i; j++) {
                String sR = s.substring(j, i);
                if (set.contains(sR)) {
                    List<String> sLs = dp.get(s.substring(0, j));
                    for (String str: sLs) {
                        list.add(str + " " + sR);
                    }
                }
            }
            dp.put(sub, list);
        }
        return dp.get(s);
    }

    public List<String> wordBreak3(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for  (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    HashMap<Integer, List<String>> dp = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        int maxLength = -1;
        for(String ss : wordDict) maxLength = Math.max(maxLength, ss.length());
        return addSpaces(s, new HashSet<>(wordDict), 0, maxLength);
    }

    private List<String> addSpaces(String s, Set<String> wordDict, int start, int max){
        List<String> words = new ArrayList<>();
        if(start == s.length()) {
            words.add("");
            return words;
        }
        for(int i = start + 1; i <= max + start && i <= s.length(); i++){
            String temp = s.substring(start, i);
            if(wordDict.contains(temp)){
                List<String> ll;
                if(dp.containsKey(i)) ll = dp.get(i);
                else ll = addSpaces(s, wordDict, i, max);
                for(String ss : ll) words.add(temp + (ss.equals("") ? "" : " ") + ss);
            }

        }
        dp.put(start, words);
        return words;
    }
}


