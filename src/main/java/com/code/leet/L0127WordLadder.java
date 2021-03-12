package com.code.leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
Given two words (beginWord and endWord), and a dictionary's word list,
find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
 */
public class L0127WordLadder {
    public static void main(String[] args) {
//        String beginWord = "qa";
//        String endWord = "sq";
//        String[] strings = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        String beginWord = "hit";
        String endWord = "cog";
        String[] strings = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new LinkedList<>(Arrays.asList(strings));
        int i = new L0127WordLadder().ladderLength4(beginWord, endWord, wordList);
        System.out.println(i);
    }

    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        List<String> beginSet = new LinkedList<>();
        beginSet.add(beginWord);
        int len = 1;
        if (!wordList.remove(endWord)) {
            return 0;
        }
        while (beginSet.size() > 0) {
            len++;
            List<String> tmpBegin = new LinkedList<>();
            List<String> tmpList = new LinkedList<>();
            for (String begin : beginSet) {
                if (isLadder(endWord, begin)) {
                    return len;
                }
                for (String word : wordList) {
                    if (isLadder(begin, word)) {
                        tmpBegin.add(word);
                    } else {
                        tmpList.add(word);
                    }
                }
            }
            wordList = tmpList;
            beginSet = tmpBegin;
        }
        return 0;
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

    public int ladderLength(String start, String end, List<String> wordList) {
        if (!wordList.remove(end)) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add(start);
        set2.add(end);
        dict.remove(start);

        return helper(dict, set1, set2, 1);
    }

    int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level) {
        if (set1.isEmpty()) return 0;

        if (set1.size() > set2.size()) return helper(dict, set2, set1, level);

        // the set for next level
        Set<String> set = new HashSet<>();

        // for each string in the current level
        for (String str : set1) {
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();

                // change letter at every position
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String word = new String(chars);

                    // found the word in other end(set)
                    if (set2.contains(word)) {
                        return level + 1;
                    }

                    // if not, add to the next level
                    if (dict.contains(word)) {
                        set.add(word);
                        dict.remove(word);
                    }
                }
            }
        }

        return helper(dict, set2, set, level + 1);
    }

    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        HashSet<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(endWord);

        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);

        return ladderRecur(set1, set2, wordSet);
    }

    private int ladderRecur(HashSet<String> set1, HashSet<String> set2, HashSet<String> wordSet) {
        if (set1.size() > set2.size()) return ladderRecur(set2, set1, wordSet);
        boolean hasNext = false;
        HashSet<String> nextSet = new HashSet<>();
        for (String word : set1) {
            if (set2.contains(word)) {
                return 1;
            }
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char tmp = chars[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (tmp != j) {
                        chars[i] = j;
                        String s = new String(chars);
                        if (set2.contains(s)) {
                            return 2;
                        }
                        if (wordSet.contains(s)) {
                            nextSet.add(s);
                            wordSet.remove(s);
                            hasNext = true;
                        }
                    }
                }
                chars[i] = tmp;
            }
        }
        if (!hasNext) {
            return 0;
        }

        int recur = ladderRecur(nextSet, set2, wordSet);
        return recur == 0 ? 0 : recur + 1;
    }
}
