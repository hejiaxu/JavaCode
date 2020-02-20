package com.code.diy;

public class DIY_IndexOf {
    public static void main(String[] args) {
        String s = "aabaaabaaac";
        String str = "aabaaac";
        DIY_IndexOf diy_indexOf = new DIY_IndexOf(s);
        int index = diy_indexOf.indexOf(str);
        System.out.println(index);
    }
    String s;
    DIY_IndexOf(String s) {
        this.s = s;
    }

    int indexOf(String str) {
        if (str == null) {
            return -1;
        }

        if (str.equals("")) {
            return 0;
        }
        int[] p = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int tmp = i;
            p[i] = -1;
            while(tmp > 0) {
                tmp = p[tmp - 1] + 1;
                if (str.charAt(i) == str.charAt(tmp)) {
                    p[i] = tmp;
                    break;
                }
            }

        }
        int l = 0;
        int r = 0;
        while (l < s.length()) {
            if (s.charAt(l) == str.charAt(r)) {
                l++;
                r++;
            } else if (r == 0) {
                l++;
            } else {
                r = p[r - 1] + 1;
            }

            if (r == str.length()) {
                return l - r;
            }

        }
        return -1;
    }
}
