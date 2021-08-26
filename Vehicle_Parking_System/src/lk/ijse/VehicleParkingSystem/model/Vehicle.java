package lk.ijse.VehicleParkingSystem.model;

public class Vehicle {
    String vehNumber;
    String vehType;
    Integer maxWeight;
    Integer noPassenger;

    public Vehicle(String vehNumber, String vehType, Integer maxWeight, Integer noPassenger) {
        this.vehNumber = vehNumber;
        this.vehType = vehType;
        this.maxWeight = maxWeight;
        this.noPassenger = noPassenger;
    }

    public Vehicle() {

    }


    public String getVehNumber() {
        return vehNumber;
    }

    public void setVehNumber(String vehNumber) {
        this.vehNumber = vehNumber;
    }

    public String getVehType() {
        return vehType;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getNoPassenger() {
        return noPassenger;
    }

    public void setNoPassenger(Integer noPassenger) {
        this.noPassenger = noPassenger;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehNumber='" + vehNumber + '\'' +
                ", vehType='" + vehType + '\'' +
                ", maxWeight=" + maxWeight +
                ", noPassenger=" + noPassenger +
                '}';
    }
}
