package 尚硅谷.运行时区域.虚拟机栈;

import day1.A;

/**
 * author: mxg
 *
 * 静态链接  动态链接
 * 早期绑定  晚期绑定
 *
 */
public class 早期绑定和晚期绑定 {
    void showAnimal( Animal animal ) {
        animal.eat();  //晚期绑定
    }

    void showHunt(Hunt hunt) {
        hunt.hunt();   //晚期绑定
    }

    public static void main(String[] args) {

    }
}

class Animal {
    void eat(){

    }
}
interface Hunt {
    void hunt();
}
class Dog extends Animal implements Hunt {
    @Override
    void eat() {
        System.out.println("狗吃骨头");
    }

    @Override
    public void hunt() {
        System.out.println("狗拿耗子，多管闲事");
    }
}

class Cat extends Animal implements Hunt {

    public Cat() {
        super();  // 早期绑定
    }

    public Cat(String name) {
        this();    //早期绑定
    }

    @Override
    void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void hunt() {
        System.out.println("猫拿耗子，天经地义");
    }
}