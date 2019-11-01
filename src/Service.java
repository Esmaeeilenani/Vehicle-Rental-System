

public class Service {

    private String ServiceType;
    private double ServicePrice;

    public Service(String ServiceType, double ServicePrice) {
        this.ServiceType = ServiceType;
        this.ServicePrice = ServicePrice;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String ServiceType) {
        this.ServiceType = ServiceType;
    }

    public double getServicePrice() {
        return ServicePrice;
    }

    public void setServicePrice(double ServicePrice) {
        this.ServicePrice = ServicePrice;
    }

    public String toString() {

        return "Service: "+this.ServiceType+" Price: "+this.ServicePrice;
    }

}
