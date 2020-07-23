package 结构型模式.外观模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        RegisterFacade registerFacade = new RegisterFacade();
        registerFacade.register();
    }
}
