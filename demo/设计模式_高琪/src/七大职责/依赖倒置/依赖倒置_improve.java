package 七大职责.依赖倒置;

/**
 * author: mxg
 *
  依赖倒置三种传递方式

    接口传递

    构造方法传递

    setter方法传递


 */
public class 依赖倒置_improve {
    public static void main(String[] args) {
        IPerson person = new IPerson();
        IEmail email = new IEmail();
        Weixin weixin = new Weixin();

        person.receive(email);
        person.receive(weixin);
    }

}
interface IReceiver {
    String getInfo();
}

class IEmail implements IReceiver{
    @Override
    public String getInfo() {
        return "电子邮件信息：Hello IEmail";
    }
}

class Weixin implements IReceiver {

    @Override
    public String getInfo() {
        return "微信信息：Hello Weixin";
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
class IPerson {
    public void receive(IReceiver receiver) {
        receiver.getInfo();
    }
}