package cars;

import cars.engine.DieselEngine;
import cars.engine.ElectricEngine;
import cars.engine.PetrolEngine;
import cars.gearbox.AutomatonGearbox;
import cars.gearbox.MechanicGearbox;
import cars.vehicle.Bus;
import cars.vehicle.Car;
import cars.vehicle.Truck;
import cars.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Car(new PetrolEngine(), new AutomatonGearbox());
        vehicle.showVehicleInfo();
        vehicle = new Truck(new ElectricEngine(), new AutomatonGearbox());
        vehicle.showVehicleInfo();
        vehicle = new Bus(new DieselEngine(), new MechanicGearbox());
        vehicle.showVehicleInfo();
    }
}
