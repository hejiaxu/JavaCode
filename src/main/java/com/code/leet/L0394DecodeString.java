package com.code.leet;

public class L0394DecodeString {
    public String decodeString(String s) {
        return dfs(s, 0, s.length());
    }

    private String dfs(String s, int l, int r) {
        if (l >= r) return "";
        StringBuilder sb = new StringBuilder();
        while (l < r) {
            int loop = 1;
            if (Character.isDigit(s.charAt(l))) {
                loop = s.charAt(l++) - '0';
                String tmp = "";
                while (++l < r && s.charAt(l) != ']') {
                    tmp += s.charAt(l);
                }
                while (loop-- > 1) {
                    sb.append(tmp);
                }
            } else {
                while (++l < r && Character.isAlphabetic(s.charAt(l) )) {
                    sb.append(s.charAt(l));
                }
            }
        }




        return null;
    }
}

