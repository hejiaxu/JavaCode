package com.code.misc;

public class FinalClone implements Cloneable{
    final int a;
    final Integer[] b;
    FinalClone () {
        a = 1;
        b = new Integer[1];
    }


    @Override
    public FinalClone clone() {

        FinalClone finalClone = null;
        try {
            finalClone = (FinalClone)super.clone();
            //impossible
//            finalClone.b = b.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return finalClone;
    }

    public static void main(String[] args) {
        FinalClone finalClone = new FinalClone();
        finalClone.b[0] = 3;
        FinalClone clone = finalClone.clone();
        System.out.println(clone.a);
        System.out.println(clone.b[0]);
        finalClone.b[0] = 5;
        System.out.println(clone.b[0]);

    }
}
