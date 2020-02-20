package com.code.diy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DIY_ElementaryArithmatic {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 3};
        char[] ops = {'+', '*', '-', '/'};
        int operate = new DIY_ElementaryArithmatic().operate(nums, ops);
        System.out.println(operate);
    }

    int operate(int[] nums, char[] ops) {
        int r = 0;
        Queue<Integer> integerQueue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            integerQueue.add(nums[i]);
        }
        Queue<Character> characters = new LinkedList<>();
        for (int i = 0; i < ops.length; i++) {
            characters.add(ops[i]);
        }

        Queue<Character> addCharacter = new LinkedList<>();
        int num = integerQueue.poll();
        while(!characters.isEmpty()) {
            Character poll = characters.poll();
            if (poll == '*') {
                num *= integerQueue.poll();
            } else if (poll == '/') {
                num /= integerQueue.poll();
            } else {
                integerQueue.offer(num);
                num = integerQueue.poll();
                addCharacter.offer(poll);
            }
        }
        integerQueue.offer(num);
        int add = integerQueue.poll();
        while (!addCharacter.isEmpty()) {
            Character poll = addCharacter.poll();
            if (poll == '+') {
                add += integerQueue.poll();
            } else {
                add -= integerQueue.poll();
            }
        }
        integerQueue.offer(add);
        r = integerQueue.poll();
        return r;
    }
}
