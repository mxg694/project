package 七大职责.依赖倒置;

/**
 * author: mxg
 */
public class 依赖倒置_not {
    public static void main(String[] args) {

    }
}


class Email{
    public String getInfo() {
        return "电子邮件信息：Hello world";
    }
}

/**
 * 完成Person 接收消息功能
 *  分析：
 *    1。简单，容易想到
 *    2.如果获取的是微信。短信等信息，需要新增类，同时需要Person 需要增加相应的方法
 *  解决办法
 *     抽取出公共的部分，形成一个接口， 通过依赖接口，实现依赖倒置
 */
class Person {
    public void receive(Email email) {
        email.getInfo();
    }
}