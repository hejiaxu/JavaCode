package com.code.leet;

/*
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

 */
public class L0621TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }
        int maxH = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxH) {
                maxH = count[i];
            }
        }
        int maxNum = 0;
        for (int i = 0; i < count.length; i++) {
            if (maxH > 0 && maxH == count[i]) {
                maxNum++;
            }
        }
        return  (maxH - 1) * (n + 1) + maxNum > tasks.length ? (maxH - 1) * (n + 1) + maxNum : tasks.length;
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        int i = new L0621TaskScheduler().leastInterval(tasks, 2);
        System.out.println(i);
    }
}
