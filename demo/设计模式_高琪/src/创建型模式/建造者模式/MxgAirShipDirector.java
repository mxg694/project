package 创建型模式.建造者模式;

/**
 * author: mxg
 */
public class MxgAirShipDirector implements AirShipDirector {

    private AirShipBuilder airShipBuilder;

    @Override
    public AirShip builderAirShip() {
        Engine engine = airShipBuilder.buildEngine();
        EscapeTower escapeTower = airShipBuilder.buildEscapeTower();
        OrbitalModule orbitalModule = airShipBuilder.buildOrbitalModule();

        AirShip airShip = new AirShip();
        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);
        airShip.setOrbitalModule(orbitalModule);

        return airShip;
    }

    public MxgAirShipDirector(AirShipBuilder airShipBuilder) {
        this.airShipBuilder = airShipBuilder;
    }
}
