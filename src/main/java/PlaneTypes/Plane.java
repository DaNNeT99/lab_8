package PlaneTypes;

import java.io.Serializable;
public class Plane implements Serializable{
    protected String name;
    protected int fuelCapacity;
    protected int fuelConsumption;
    protected int boardCapacity;
    protected int maxFlightLength;
    protected String availability;
    public Plane(String name, int fuelCapacity, int fuelConsumption, int boardCapacity, int maxFlightLength, String availability){
        this.name =name;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
        this.boardCapacity = boardCapacity;
        this.maxFlightLength = maxFlightLength;
        this.availability = availability;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getBoardCapacity() {
        return boardCapacity;
    }

    public int getMaxFlightLength() {
        return maxFlightLength;
    }

    public String getAvailability() {return availability;}

    public String getName() {return name;}

    @Override
    public String toString() {
        return "PlaneTypes.Plane{" +
                "name=" + name +
                ", fuelCapacity=" + fuelCapacity +
                ", fuelConsumption=" + fuelConsumption +
                ", boardCapacity=" + boardCapacity +
                ", maxFlightLength=" + maxFlightLength +
                ", availability=" + availability  +
                "}";
    }
}
