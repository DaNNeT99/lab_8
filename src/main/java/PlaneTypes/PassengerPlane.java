package PlaneTypes;

import java.io.Serializable;
public class PassengerPlane extends Plane implements Serializable{
    public PassengerPlane(String name, int fuelCapacity, int fuelConsumption, int boardCapacity,
                          int maxFlightLength,String availability)
    {super (name, fuelCapacity, fuelConsumption,boardCapacity,maxFlightLength,availability);}

    public void displayPassengerPlaneInfo() {
        System.out.println("Пасажирський літак: " + this.name+"\n" + "Внутрішній об'єм баку: "
                + this.fuelCapacity +
                " літрів"+"\n"+"Швидкість споживання пального: "
                + this.getFuelConsumption() + " літрів на кілометр"+"\n"+
                "Максимальна кількість пасажирів: " + this.getBoardCapacity() + " людей"+
                "\n"+"Максимальна довжина польоту: " + this.getMaxFlightLength() + " км"+
                "\n"+"Доступність: " + this.availability);




        System.out.println();
    }

}
