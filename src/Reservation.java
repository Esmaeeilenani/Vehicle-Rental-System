

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {

    private String Reservation_code;
    private String Pick_up_loc;
    private String drop_of_loc;
    private Date Pick_upD;
    private Date Drop_ofD;
    private Date Date_of_Reservation;
    private Customer customer;
    private Car car;
    private Service service;

    public Reservation(String Pick_up_loc, String drop_of_loc, Date Pick_upD, Date Drop_ofD, Customer customer, Car car) {
        
        int random = (int) (Math.random() * 1000);
        this.Pick_up_loc = Pick_up_loc;
        this.drop_of_loc = drop_of_loc;
        this.Pick_upD = Pick_upD;
        this.Drop_ofD = Drop_ofD;
        this.customer = customer;
        this.car = car;
        this.Reservation_code = "" + this.customer.getFirst_Name().toUpperCase().charAt(0) + "" + this.customer.getLast_Name().toUpperCase().charAt(0) + "_" + random + "_" + this.car.getYear();

    }

    public String getReservation_code() {
        return Reservation_code;
    }

    public void setReservation_code(String Reservation_code) {
        this.Reservation_code = Reservation_code;
    }

    public String getPick_up_loc() {
        return Pick_up_loc;
    }

    public void setPick_up_loc(String Pick_up_loc) {
        this.Pick_up_loc = Pick_up_loc;
    }

    public String getDrop_of_loc() {
        return drop_of_loc;
    }

    public void setDrop_of_loc(String drop_of_loc) {
        this.drop_of_loc = drop_of_loc;
    }

    public Date getPick_upD() {
        return Pick_upD;
    }

    public void setPick_upD(Date Pick_upD) {
        this.Pick_upD = Pick_upD;
    }

    public Date getDrop_ofD() {
        return Drop_ofD;
    }

    public void setDrop_ofD(Date Drop_ofD) {
        this.Drop_ofD = Drop_ofD;
    }

    public Date getDate_of_Reservation() {
        return Date_of_Reservation;
    }

    public void setDate_of_Reservation(Date Date_of_Reservation) {
        this.Date_of_Reservation = Date_of_Reservation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Service getService() {
        return service;
    }

    public void addService(Service service) {
        this.service = service;
    }

    public String toString() {
        int Days = Drop_ofD.getDate() - Pick_upD.getDate();
        double Price = car.getCar_rate() * Days;
        double totalPrice = Price;

        String DatePick = new SimpleDateFormat("d-M-yyyy").format(this.Pick_upD);
        String DateDrop = new SimpleDateFormat("d-M-yyyy").format(this.Drop_ofD);

        String INFO = "******Reservation Refrence number : " + this.Reservation_code + "\r\n"
                + "******Customer information : " + this.customer.toString() + "\r\n"
                + "******Pick up location : " + this.Pick_up_loc + "	******Drop of location : " + this.drop_of_loc + "\r\n"
                + "******Pick up date : " + DatePick + "	******Drop of date : " + DateDrop + "\r\n"
                + "******Car information : " + car.toString() + "\r\n";
        if (service != null) {
            INFO += "******Additional services : Service " + this.service.getServiceType() + "\r\n";
            totalPrice += service.getServicePrice();
        }

        INFO += "--------------- Invoice Details ---------------\r\n"
                + " Number of reserved days: " + Days + "\r\n"
                + " Intial Total: " + Price + "\r\n"
                + "--------------- Additional Services Price ---------------\r\n"
                + " Total After additional Services  : " + totalPrice + "\r\n"
                + "--------------- Final Payment after Discount ---------------\r\n"
                + " Final Total  : " + car.FinalPrice(customer.getDiscount_Code(), totalPrice) + "\r\n";

        return INFO;
    }

}
