package lk.ijse.VehicleParkingSystem.model;

public class Driver {
    String name;
    String nic;
    String licenseNo;
    String address;
    Integer contact;

    public Driver(String name, String nic, String licenseNo, String address, Integer contact) {
        this.name = name;
        this.nic = nic;
        this.licenseNo = licenseNo;
        this.address = address;
        this.contact = contact;
    }

    public Driver() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", address='" + address + '\'' +
                ", contact=" + contact +
                '}';
    }
}
