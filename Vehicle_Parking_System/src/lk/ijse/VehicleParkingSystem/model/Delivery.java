package lk.ijse.VehicleParkingSystem.model;

public class Delivery {
    String vehNumber;
    String vehType;
    String name;
    String leftTime;

    public Delivery(String vehNumber, String vehType, String name, String leftTime) {
        this.vehNumber = vehNumber;
        this.vehType = vehType;
        this.name = name;
        this.leftTime = leftTime;
    }

    public Delivery() {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(String leftTime) {
        this.leftTime = leftTime;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "vehNumber='" + vehNumber + '\'' +
                ", vehType='" + vehType + '\'' +
                ", name='" + name + '\'' +
                ", leftTime='" + leftTime + '\'' +
                '}';
    }
}
