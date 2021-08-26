package lk.ijse.VehicleParkingSystem.model;

public class Parking {
    String vehNumber;
    String vehType;
    String parkSlot;
    String parkTime;

    public Parking(String vehNumber, String vehType, String parkSlot, String parkTime) {
        this.vehNumber = vehNumber;
        this.vehType = vehType;
        this.parkSlot = parkSlot;
        this.parkTime = parkTime;
    }

    public Parking() {

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

    public String getParkSlot() {
        return parkSlot;
    }

    public void setParkSlot(String parkSlot) {
        this.parkSlot = parkSlot;
    }

    public String getParkTime() {
        return parkTime;
    }

    public void setParkTime(String parkTime) {
        this.parkTime = parkTime;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "vehNumber='" + vehNumber + '\'' +
                ", vehType='" + vehType + '\'' +
                ", parkSlot=" + parkSlot +
                ", parkTime='" + parkTime + '\'' +
                '}';
    }
}
