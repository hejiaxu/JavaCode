package com.code.leet;

import java.util.LinkedList;
import java.util.List;

public class L0500KeyboardRow {

    public String[] findWords(String[] words) {
        List<String> r = new LinkedList <>();
        for (String word :
                words) {
            if ( oneRow(word) ) {
                r.add(word);
            }
        }
        return r.toArray(new String[0]);
    }
    int[] map = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
    private boolean oneRow(String word) {
        int r = map[Character.toLowerCase(word.charAt(0)) - 'a'];
        for (int i = 1; i < word.length(); i++) {
            if (map[Character.toLowerCase(word.charAt(i)) - 'a'] != r) {
                return false;
            }
        }
        return true;
    }
}
