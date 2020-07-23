package 创建型模式.工厂模式.简单工厂;

/**
 * author: mxg
 */
public class ChinaPizza extends Pizza {
    @Override
    public void product() {
        System.out.println("生产中国披萨");
    }
}
