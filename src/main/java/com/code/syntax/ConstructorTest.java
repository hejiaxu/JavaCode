package com.code.syntax;
/**
 * 
 */

/**
	1，  先执行内部静态对象的构造函数，如果有多个按定义的先后顺序执行；而且静态类的构造函数只会被执行一次，只在其第一个对象创建时调用，即便是创建了同一个类的多个对象，例如main（）函数里b1,b2创建了同一个类的两个对象，但是grandmaMotherClass的构造函数只被执行了一次
	2，  再执行父类的构造函数（c++中如果有多个，可按照左右先后顺序执行）
	3，  再执行内部普通对象的构造函数
	4，  最后执行该类本身的构造函数
 */


public class ConstructorTest extends FatherClass{
    MotherClass b = new MotherClass();
    static GandmaClass b1 = new GandmaClass();
    static GandmaClass b2 = new GandmaClass(2);
    public ConstructorTest(){
       System.out.println("1981年 我 出生了");
    }
    public static void main(String[] args) {
       System.out.println("main function is called");
       ConstructorTest my = new ConstructorTest();
      /*
        	奶奶的妈妈 是 1890年出生的
			1911年 奶奶 出生了
			1913年 奶奶的妹妹 出生了
			mainfunction is called
			1912年 爷爷 出生了
			1956年 爸爸 出生了
			1957年 妈妈 出生了
			1981年 我 出生了
       */
    }
}

class GrandpaClass{
    public GrandpaClass(){
       System.out.println("1912年 爷爷 出生了");
    }
}

class FatherClass extends GrandpaClass{
    public FatherClass(){
       System.out.println("1956年 爸爸 出生了");
    }
}

class GrandmaMotherClass{
    public GrandmaMotherClass(){
       System.out.println("奶奶的妈妈 是 1890年出生的");
    }
}

class GandmaClass{
    static int year = 0;
    static GrandmaMotherClass nnmm = new GrandmaMotherClass();
    public GandmaClass(){
       year = 1911;
       System.out.println(year + "年 奶奶 出生了");
    }
    public GandmaClass(int count){
       year += count;
       System.out.println(year + "年 奶奶的妹妹 出生了");
    }
}

class MotherClass{
    public MotherClass(){
       System.out.println("1957年 妈妈 出生了");
    }
}

 