package com.code.leet;


import java.util.Stack;

/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

 */
public class L0071SimplifyPath {
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        String s = new L0071SimplifyPath().simplifyPath(path);
        System.out.println(s);
    }
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> s = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else if (!split[i].equals(".") && !split[i].equals("")) {
                s.push(split[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.insert(0, s.pop());
            sb.insert(0, '/');
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
