package com.code.interview;

/*
Describe how you could use a single array to implement three stacks.

You should implement push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum) methods. stackNum is the index of the stack. value is the value that pushed to the stack.

The constructor requires a stackSize parameter, which represents the size of each stack.

Example1:

 Input:
["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 Output:
[null, null, null, 1, -1, -1, true]
Explanation: When the stack is empty, `pop, peek` return -1. When the stack is full, `push` does nothing.
Example2:

 Input:
["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 Output:
[null, null, null, null, 2, 1, -1, -1]

 */
public class LCCI0301ThreeInOne {
    int [] pos = {0, 0, 0};
    int size;
    int [] array;

    public LCCI0301ThreeInOne(int stackSize) {
        array = new int[stackSize * 3];
        size = stackSize;
    }

    public void push(int stackNum, int value) {
        if (pos[stackNum] < size) {
            array[pos[stackNum] + stackNum * size] = value;
            pos[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        int end = pos[stackNum] - 1;
        if (end >= 0) {
            pos[stackNum]--;
            return array[end + stackNum * size ];
        }
        return -1;
    }

    public int peek(int stackNum) {
        int end = pos[stackNum] - 1;
        if (end >= 0) {
            return array[end + stackNum * size ];
        }
        return -1;
    }

    public boolean isEmpty(int stackNum) {
        return pos[stackNum] == 0;
    }
}
