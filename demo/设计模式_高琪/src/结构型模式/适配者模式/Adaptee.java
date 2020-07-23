package 结构型模式.适配者模式;

/**
 * author: mxg
  被适配的类   （例子中的键盘/三孔插座）
 */
public class Adaptee {
    public void  request() {
        System.out.println("可以完成客户请求需要的功能");
    }
}
