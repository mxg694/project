package 结构型模式.桥接模式;

/**
 * author: mxg
 */
public abstract class Computer2 {
    protected  Brand brand;

    public Computer2(Brand brand) {
        this.brand = brand;
    }
    public void  sale() {
        brand.sale();
    }
}

class Desttop2 extends Computer2 {

    public Desttop2(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式机");
    }
}

class Laptop2 extends Computer2 {

    public Laptop2(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售笔记本");
    }
}