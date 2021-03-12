package com.code.leet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
Given two words (beginWord and endWord), and a dictionary's word list,
find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list.
Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
 */
public class L0126WordLadderII {
    public static void main(String[] args) {
//        String beginWord = "qa";
//        String endWord = "sq"; 
        String beginWord = "hit";
        String endWord = "cog";
//        String[] strings = {"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};
        String[] strings = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new LinkedList<>(Arrays.asList(strings));
        List<List<String>> ladders = new L0126WordLadderII().findLadders(beginWord, endWord, wordList);
        for (List<String> strs : ladders) {
            for (String str : strs) {
                System.out.print(str);
                System.out.print(", ");
            }
            System.out.println();
        }
        System.out.println(ladders.size());
    }


    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> r = new LinkedList<>();
        if (!wordList.remove(endWord)) {
            return r;
        }
        Map<String, String> beginMap = new HashMap<>();
        beginMap.put(beginWord, beginWord);

        while (beginMap.size() > 0) {
            Map<String, String> tmpBegin = new HashMap<>();
            List<String> tmpList = new LinkedList<>();
            Set<Map.Entry<String, String>> entries = beginMap.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                if (isLadder(endWord, entry.getValue())) {
                    List<String> strings = new LinkedList<>(Arrays.asList(entry.getKey().split(",")));
                    strings.add(endWord);
                    r.add(strings);
                }
                for (String word : wordList) {
                    if (isLadder(entry.getValue(), word)) {
                        tmpBegin.put(entry.getKey() + "," + word, word);
                    } else {
                        tmpList.add(word);
                    }
                }
            }
            if (r.size() > 0) {
                return r;
            }
            wordList = tmpList;
            beginMap = tmpBegin;
        }
        return r;
    }

    private boolean isLadder(String beginWord, String str) {
        if (beginWord.equals(str)) {
            return false;
        }
        int dif = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (str.charAt(i) != beginWord.charAt(i)) {
                if (dif > 0) {
                    return false;
                }
                dif++;
            }
        }

        return true;
    }


    List<List<String>> results;
    List<String> list;
    Map<String, List<String>> map;

    public List<List<String>> findLadders(String start, String endWord, List<String> wordList) {
        results = new ArrayList<List<String>>();
        if (!wordList.remove(endWord)) {
            return results;
        }
        if (wordList.size() == 0)
            return results;

        int curr = 1, next = 0;
        boolean found = false;
        list = new LinkedList<String>();
        map = new HashMap<String, List<String>>();

        Queue<String> queue = new ArrayDeque<String>();
        Set<String> unvisited = new HashSet<String>(wordList);
        Set<String> visited = new HashSet<String>();

        queue.add(start);
        unvisited.add(endWord);
        unvisited.remove(start);
        //BFS
        while (!queue.isEmpty()) {

            String word = queue.poll();
            curr--;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String new_word = builder.toString();
                    if (unvisited.contains(new_word)) {
                        //Handle queue
                        if (visited.add(new_word)) {//Key statement,Avoid Duplicate queue insertion
                            next++;
                            queue.add(new_word);
                        }

                        if (map.containsKey(new_word))//Build Adjacent Graph
                            map.get(new_word).add(word);
                        else {
                            List<String> l = new LinkedList<String>();
                            l.add(word);
                            map.put(new_word, l);
                        }

                        if (new_word.equals(endWord) && !found) found = true;

                    }

                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
            if (curr == 0) {
                if (found) break;
                curr = next;
                next = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }//End While

        backTrace(endWord, start);

        return results;
    }

    private void backTrace(String word, String start) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null)
            for (String s : map.get(word))
                backTrace(s, start);
        list.remove(0);
    }

}
