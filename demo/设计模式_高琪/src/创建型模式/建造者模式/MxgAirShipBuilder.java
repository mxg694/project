package 创建型模式.建造者模式;

/**
 * author: mxg
  具体的构建者
 */
public class MxgAirShipBuilder implements AirShipBuilder {
    @Override
    public OrbitalModule buildOrbitalModule() {
        System.out.println("mxg牌  轨道舱");
        return new OrbitalModule("mxg牌  轨道舱") ;
    }

    @Override
    public Engine buildEngine() {
        System.out.println("mxg牌  发动机");
        return new Engine("mxg牌  发动机");
    }

    @Override
    public EscapeTower buildEscapeTower() {
        System.out.println("mxg牌  逃生塔");
        return new EscapeTower("mxg牌  逃生塔");
    }
}
