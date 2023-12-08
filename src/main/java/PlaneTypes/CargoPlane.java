package PlaneTypes;

import java.io.Serializable;
public class CargoPlane extends Plane implements Serializable{
    private int cargoCapacity;

    public CargoPlane(String name, int fuelCapacity, int fuelConsumption, int cargoCapacity, int maxFlightLength, String availability) {
        super(name, fuelCapacity, fuelConsumption, 0, maxFlightLength, availability);
        this.cargoCapacity = cargoCapacity;
    }

    public void displayCargoPlaneInfo() {
        System.out.println("Вантажний літак: " + this.name+"\n"+"Внутрішній об'єм баку: "
                + this.fuelCapacity + " літрів"+"\n"+"Швидкість споживання пального: "
                + this.getFuelConsumption() + " літрів на кілометр"+"\n"+
                "Максимальна кількість пасажирів: " + this.getBoardCapacity() + " людей"+"\n"+
                "Максимальна довжина польоту: " + this.getMaxFlightLength() + " км"+"\n"+
                "Максимальна кількість вантажу: " + this.cargoCapacity + " тон"+"\n"+
                "Доступність: " + this.availability);

    }


}