package cars.vehicle;

import cars.engine.Engine;
import cars.gearbox.Gearbox;

public interface Vehicle {
    Engine getEngine();
    Gearbox getGearbox();
    void showVehicleInfo();
}
