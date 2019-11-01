

public class Customer {

    private String First_Name;
    private String Last_Name;
    private String Email;
    private long Credit_Card;
    private int Discount_Code;

    public Customer(String First_Name, String Last_Name, String Email, long Credit_Card, int Discount_Code) {
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
        this.Email = Email;
        this.Credit_Card = Credit_Card;
        this.Discount_Code = Discount_Code;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public long getCredit_Card() {
        return Credit_Card;
    }

    public void setCredit_Card(long Credit_Card) {
        this.Credit_Card = Credit_Card;
    }

    public int getDiscount_Code() {
        return Discount_Code;
    }

    public void setDiscount_Code(int Discount_Code) {
        this.Discount_Code = Discount_Code;
    }

    public String toString() {

        return "Customer Name: " + this.First_Name + " " + this.Last_Name + ", Email: " + this.Email + ", Code: " + this.Discount_Code;
    }
}
