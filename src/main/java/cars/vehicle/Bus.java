package cars.vehicle;

import cars.engine.Engine;
import cars.gearbox.Gearbox;

public class Bus implements Vehicle {
    private Engine engine;
    private Gearbox gearbox;

    public Bus(Engine engine, Gearbox gearbox) {
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
        System.out.println("This is a bus with:");
        engine.showInfo();
        gearbox.showInfo();
    }
}
