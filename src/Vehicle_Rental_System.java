
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Vehicle_Rental_System {

    /*
    ESMAEEIL ENANI
    
    
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        CarFile();
    }

//---------------------Car File-------------------------------------------------------------
    public static void CarFile() throws FileNotFoundException, ParseException {
        File FR = new File("inputCar.txt");
        if (!FR.exists()) {
            System.out.println("File Not Exists");
            System.exit(0);
        }
        Scanner in = new Scanner(FR);

        File FW = new File("CarsInfo.txt");
        PrintWriter writer = new PrintWriter(FW);

        Car CarDB[] = new Car[in.nextInt()];
        Service service[] = new Service[in.nextInt()];
        CarINFO(CarDB, service, in, writer, FR, FW);
    }
//------------------------------------------------------------------------------------------

//---------------------Input Cars to Data Base----------------------------------------------    
    public static void CarINFO(Car CarDB[], Service service[], Scanner in, PrintWriter writer, File FR, File FW) throws FileNotFoundException, ParseException {
        writer.println("--------------- Welcome to Car Renting  Data Base ---------------\r\n\r\n");
        String Command;
        int CarIndex = 0;
        int serviceIndex = 0;

        while (in.hasNext()) {

            Command = in.next();

            if (Command.equalsIgnoreCase("AddCar")) {//if the Command is equal to AddCar

                if (CarIndex < CarDB.length) {
                    // Take Cars INFO and initialize each Index with new Car 
                    CarDB[CarIndex] = new Car(in.next(), in.nextInt(), in.nextDouble(), in.nextBoolean(), in.next(), in.nextBoolean());
                    writer.println(CarDB[CarIndex++].toString());
                    writer.println("------------------------------------------------------\r\n");
                } else {
                    writer.println("Sorry you Can`t Add More Cars \r\n Your Data Base is Full......\r\n");
                }

//-----------------------------------------------------------------------------------------------------
            } else if (Command.equalsIgnoreCase("AddService")) {//if the First index (Command) is equal to AddService

                if (serviceIndex < service.length) {
                    // Take service INFO and initialize each Index with new service 
                    service[serviceIndex++] = new Service(in.next(), in.nextDouble());

                } else {
                    writer.println("Sorry you Can`t Add More Service \r\n Your Data Base is Full......\r\n");
                }

//-----------------------------------------------------------------------------------------------------
            } else if (Command.equals("Quit")) {
                writer.flush();
                writer.close();
                //after Reading all Command in Car File Go Direct to Resevation File implementation
                ResevationFile(CarDB, service, in, writer, FR, FW);
            }
        }
    }
//------------------------------------------------------------------------------------------

//---------------------Resevation File------------------------------------------------------    
    public static void ResevationFile(Car CarDB[], Service service[], Scanner in, PrintWriter writer, File FR, File WF) throws FileNotFoundException, ParseException {
        FR = new File("REVinput.txt");
        if (!FR.exists()) {
            System.out.println("File Not Exists " + FR.getName());
            System.exit(0);
        }
        in = new Scanner(FR);
        WF = new File("ReservationStatus.txt");
        writer = new PrintWriter(WF);

        ResevationINFO(CarDB, service, in, writer);
    }
//------------------------------------------------------------------------------------------

//--------------------Resevation Input------------------------------------------------------    
    public static void ResevationINFO(Car CarDB[], Service service[], Scanner in, PrintWriter writer) throws ParseException {
        Reservation RES[] = new Reservation[in.nextInt()];
        int ResIndex = 0;

        writer.println("--------------- Welcome to Car Renting  Management System ---------------\r\n\r\n");
        writer.println("--------------- Display All System Procedures ---------------\r\n\r\n");

        String Command[] = {""};

        while (!Command[0].equalsIgnoreCase("Quit")) {
            //Split the File Line to Array of String
            Command = in.nextLine().trim().split(" ");

            if (Command[0].equals("Reserve")) {//if the First index (Command) is equal to Reserve

                if (ResIndex < RES.length) {
                    Car car = SearchCar(CarDB, Command);
//-----------------------------------------------------------------------------------------             
                    if (car != null) {// if the Car is not null
                        writer.println("DONE: The reservation is completed");
                        Reserve(RES, ResIndex++, car, service, Command, writer);

                    } else {
                        writer.println("\r\nSORRY: The reservation is NOT completed \r\n"
                                + "There is no available Car  \r\n\r\n");
                    }
//-----------------------------------------------------------------------------------------
                } else {
                    writer.println("Sorry you Can`t Reserve More Cars \r\n Reservation is Full......\r\n");
                }

            }

        }
        writer.flush();
        writer.close();

    }
//------------------------------------------------------------------------------------------

//----------------------add Resevation to System-----------------------------------     
    public static void Reserve(Reservation RES[], int ResIndex, Car car, Service service[], String Line[], PrintWriter writer) throws ParseException {

//----------------------to take the Date correctly------------------------------------------
        Date pick = new SimpleDateFormat("d/M/yyyy").parse(Line[8] + "/" + Line[7] + "/" + Line[6]);
        Date Drop = new SimpleDateFormat("d/M/yyyy").parse(Line[11] + "/" + Line[10] + "/" + Line[9]);
//------------------------------------------------------------------------------------------

        // Customer INFO
        Customer Cus = new Customer(Line[12], Line[13], Line[14], Long.parseLong(Line[15]), Integer.parseInt(Line[16]));

        RES[ResIndex] = new Reservation(Line[4], Line[5], pick, Drop, Cus, car);
        //RES[ResIndex] = new Reservation(Line[4], Line[5], pick, Drop, Cus, car);

        if (!Line[17].equalsIgnoreCase("submit")) {
            for (int i = 0; i < service.length; i++) {

                if (service[i].getServiceType().equals(Line[17])) {
                    RES[ResIndex].addService(service[i]);//add the required service to this Resevation                  
                    break;
                }

            }
        }
        writer.println(RES[ResIndex].toString());

    }
//------------------------------------------------------------------------------------------

//---------------------Search for Car-------------------------------------------------------    
    public static Car SearchCar(Car CarDB[], String[] Comm) {
        boolean trans = Comm[2].equalsIgnoreCase("Manual");
        boolean Convert = Comm[3].equalsIgnoreCase("Convertible");

        for (int i = 0; i < CarDB.length; i++) {
            if (CarDB[i].getCarType().equals(Comm[1]) && CarDB[i].isTransmission() == trans && CarDB[i].isConvertible() == Convert) {
                //if the required Car is in the System
                return CarDB[i];
            }
        }
        return null;
    }
//------------------------------------------------------------------------------------------

}
