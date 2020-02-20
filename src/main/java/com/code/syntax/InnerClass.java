package com.code.syntax;


/*
1. local inner class should only use final var of outer, for its val dup of it
2. extends of inner class should init an outer class in constructor

 */
public class InnerClass {

    public static void main(String[] args) {
        new InnerClass().test();
    }

    private void test() {
        A b = new A();
        b.val = 1;

        new Thread() {
            @Override
            public void run() {

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b.val = 2;
                System.out.println("run" + b.val);
                super.run();
            }
        }.start();

        System.out.println("test" + b.val);
    }

    public class A {
        int val;

        public class C {

        }
    }
}

// extends of InnerClass
//class B extends InnerClass.A.C {
//    B(InnerClass.A val) {
//        val.super();
//    }
//}



