package cars.vehicle;

import cars.engine.Engine;
import cars.gearbox.Gearbox;

public class Truck implements Vehicle {
    private Engine engine;
    private Gearbox gearbox;

    public Truck(Engine engine, Gearbox gearbox) {
        this.engine = engine;
        this.gearbox = gearbox;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public Gearbox getGearbox() {
        return gearbox;
    }


    @Override
    public void showVehicleInfo() {
        System.out.println("This is a truck with:");
        engine.showInfo();
        gearbox.showInfo();
    }
}
