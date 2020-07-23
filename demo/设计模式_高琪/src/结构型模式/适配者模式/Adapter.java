package 结构型模式.适配者模式;

/**
 * author: mxg
 * 适配器   三孔插座 =》 二孔插座
 */
public class Adapter extends Adaptee implements Target{


    @Override
    public void handleReq() {
        super.request();
    }
}
