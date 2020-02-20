package com.code.diy;

import java.util.Arrays;

public class DIY_Stack<T> {
    public static void main(String[] args) {
        DIY_Stack<Integer> integerDIYStack = new DIY_Stack<>();
        integerDIYStack.push(1);
        integerDIYStack.push(2);
        integerDIYStack.push(3);
        integerDIYStack.push(4);
        integerDIYStack.push(5);
        integerDIYStack.push(6);
        integerDIYStack.push(2);
        integerDIYStack.push(3);
        integerDIYStack.push(4);
        integerDIYStack.push(5);
        integerDIYStack.push(6);
        System.out.println(integerDIYStack.pop());
        System.out.println(integerDIYStack.pop());
        System.out.println(integerDIYStack.pop());
        System.out.println(integerDIYStack.pop());
        System.out.println(integerDIYStack.pop());
        System.out.println(integerDIYStack.pop());
        System.out.println(integerDIYStack.pop());
        System.out.println(integerDIYStack.pop());
        System.out.println(integerDIYStack.pop());

    }
    static final int  initCapacity = 10;
    Object[] elements;
    int size = 0;
    DIY_Stack() {
        elements = new Object[initCapacity];
    }

    void push(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    T pop() {
        if (size <= 0) {
            return null;
        }
        Object element = elements[--size];
        elements[size] = null;
        return (T)element;
    }

    void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, 2 * elements.length);
        }
    }
}
