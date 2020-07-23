package 结构型模式.桥接模式;

/**
 * author: mxg
 *  电脑品牌
 */
public interface Brand {
    void sale();
}

class Lx implements Brand {

    @Override
    public void sale() {
        System.out.println("销售联想电脑");
    }
}

class Dell implements Brand {

    @Override
    public void sale() {
        System.out.println("销售dell电脑");
    }
}