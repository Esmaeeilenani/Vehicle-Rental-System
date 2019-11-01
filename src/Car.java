
public class Car {

    private String Brand;
    private String CarType;
    private int Year;
    private double Car_rate;
    private boolean Transmission;
    private boolean Convertible;

    public Car(String Brand, int Year, double Car_rate, boolean Transmission, String CarType, boolean Convertible) {
        this.Brand = Brand;
        this.CarType = CarType;
        this.Year = Year;
        this.Car_rate = Car_rate;
        this.Transmission = Transmission;
        this.Convertible = Convertible;
        this.Car_rate += (this.CarType.equals("Luxury") ? this.Car_rate * 0.10 : 0);

    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getCarType() {
        return CarType;
    }

    public void setCarType(String CarType) {
        this.CarType = CarType;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public double getCar_rate() {
        return Car_rate;
    }

    public void setCar_rate(double Car_rate) {
        this.Car_rate = Car_rate;
    }

    public boolean isTransmission() {
        return Transmission;
    }

    public void setTransmission(boolean Transmission) {
        this.Transmission = Transmission;
    }

    public boolean isConvertible() {
        return Convertible;
    }

    public void setConvertible(boolean Convertible) {
        this.Convertible = Convertible;
    }

    public String toString() {
        String INFO = "";
        INFO = "The car Type: " + this.Brand + " " + this.CarType + ", Year: " + this.Year + ", Transmission:";

        INFO += (Transmission) ? " Manual" : " Automatic";
        INFO += (Convertible) ? " and Convertible" : "";

        return INFO;
    }

    public double FinalPrice(int Code, double ATotal) {
        switch (Code / 100) {
            case 9:
            case 8:
            case 7:
                ATotal -= ATotal * 0.20;
                break;
            case 6:
            case 5:
            case 4:
                ATotal -= ATotal * 0.15;
                break;
            case 3:
            case 2:
            case 1:
            case 0:
                ATotal -= ATotal * 0.10;
                break;
        }
        return ATotal;
    }

}
