package com.code.misc;

/*
Integer.valueOf(String s) 方法将字符串 s 交给 parseInt 方法处理，将其转换为十进制整数后，传给 Integer.valueOf(int i) 方法处理该字符串代表的整数

当传入数字处于[IntegerCache.low, IntegerCache.high]这个区间时，将直接返回一个数值。
第三种方法左端的 Integer.parseInt() 方法的返回值是 int 类型而不是 Integer，这就使得 == 号在比较两者时，对右边的 Integer 对象执行了自动拆箱，因此得到的结果是我们想要的。
 */
public class IntegerCache {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("66") == Integer.valueOf("66"));
        System.out.println(Integer.valueOf("222") == Integer.valueOf("222"));
        System.out.println(Integer.parseInt("222") == Integer.valueOf("222"));
    }
}
