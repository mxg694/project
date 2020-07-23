package 结构型模式.外观模式;

/**
 * author: mxg
 */
public interface 银行 {
    void openAccoutn();
}

class Bj银行 implements 银行 {

    @Override
    public void openAccoutn() {
        System.out.println("在银行开户");
    }
}

