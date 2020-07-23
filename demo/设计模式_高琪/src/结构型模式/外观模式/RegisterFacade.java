package 结构型模式.外观模式;

/**
 * author: mxg
 *
 *  结构型模式.外观模式 中的主要办理业务的门面对象
 */
public class RegisterFacade {

    public void register() {
        工商局 a = new Bj工商局();
        a.checkName();
        银行 b = new Bj银行();
        b.openAccoutn();
    }
}
