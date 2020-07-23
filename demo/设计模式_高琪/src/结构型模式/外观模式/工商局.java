package 结构型模式.外观模式;

/**
 * author: mxg
 */
public interface 工商局 {

    public void checkName() ;
}

class Bj工商局 implements 工商局 {

    @Override
    public void checkName() {
        System.out.println("bj  检查公司名");
    }
}