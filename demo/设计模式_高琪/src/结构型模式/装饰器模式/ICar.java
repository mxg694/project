package 结构型模式.装饰器模式;

/**
 * author: mxg
 * 抽象组件
 */
public interface ICar {

    void move();
}

//真实构建
class Car implements ICar {

    @Override
    public void move() {
        System.out.println("在路上跑");
    }
}

//Decorator  装饰角色
class SuperCar implements ICar {

    private ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

/**
 *   具体的装饰角色
 */
class WaterCar extends SuperCar {

    public WaterCar(ICar car) {
        super(car);
    }

    public void water() {
        System.out.println("水里游");
    }

    @Override
    public void move() {
        super.move();
        water();
    }
}
/**
 *   具体的装饰角色
 */
class FlyCar extends SuperCar {

    public FlyCar(ICar car) {
        super(car);
    }

    public void fly() {
        System.out.println("天上飞");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}
