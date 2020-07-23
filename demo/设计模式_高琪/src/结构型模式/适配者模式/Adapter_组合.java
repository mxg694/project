package 结构型模式.适配者模式;

/**
 * author: mxg
 * 适配器   三孔插座 =》 二孔插座
 */
public class Adapter_组合  implements Target{

    private Adaptee adaptee;

    @Override
    public void handleReq() {
        adaptee.request();
    }

    public Adapter_组合(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}
