package PlaneTypes;

import java.io.Serializable;
public class PrivatePlane extends PassengerPlane implements Serializable{
    protected int personalCode;
    public PrivatePlane(String name, int fuelCapacity,int fuelConsumption, int boardCapacity, int maxFlightLength,
                        String availability, int personalCode)
    {super (name, fuelCapacity, fuelConsumption, boardCapacity,maxFlightLength,availability);
        this.personalCode = personalCode;
    }

    public int getPersonalCode() {
        return personalCode;
    }
    public void displayPrivatePlaneInfo() {
        System.out.println("Особистий літак: " + this.name);
        System.out.println("Внутрішній об'єм баку: " + this.fuelCapacity + " літрів");
        System.out.println("Швидкість споживання пального: " + this.getFuelConsumption() + " літрів на кілометр");
        System.out.println("Максимальна кількість пасажирів: " + this.getBoardCapacity() + " людей");
        System.out.println("Максимальна довжина польоту: " + this.getMaxFlightLength() + " км");
        System.out.println("Доступність: " + this.availability);



        System.out.println();
    }

}
