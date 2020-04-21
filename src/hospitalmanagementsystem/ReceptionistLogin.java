/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

import static hospitalmanagementsystem.HospitalManagementSystem.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import shared.*;
/**
 *
 * @author gpatel
 */
public class ReceptionistLogin {

    void Dashboard(String username) {
        System.out.println("\n==========================================================================");
        System.out.println("\n" + ANSI_CYAN_BACKGROUND + "Welcome " + username + " to the Receptionist's dashboard" + ANSI_RESET);
        boolean flag = true;
        Appointment appointment = new Appointment();
        while (flag) {
            String patientUsername = appointment.getCurrentPatient();
            System.out.println("1. List all the upcoming appointments");
            System.out.println("2. Book New Appointment");
            System.out.println("3. Print the invoice of current Patient");
            System.out.println("0. Logout");
            System.out.print("Please select any option from above list:");
            Scanner receptionistDashboardOptions = new Scanner(System.in);
            switch (receptionistDashboardOptions.nextInt()) {
                case 1:
                    getAllAppointments();
                    break;
                case 2:
                    scheduleNewAppointment();
                    break;
                case 3:
                    printInvoice(patientUsername);
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Please select valid option.");
                    break;
            }
        }
    }
    void scheduleNewAppointment() {
        Scanner slotOption = new Scanner(System.in);
        System.out.print("Enter Patient username: ");
        String patientUsername = slotOption.nextLine();
        System.out.println("\n" + ANSI_YELLOW + "Select the slot from below available time" + ANSI_RESET);
        ArrayList<String> availableSlots;
        Appointment appointment = new Appointment();
        availableSlots = appointment.fetchAvailableSlot();
        for (int i = 0; i < availableSlots.size(); i++) {
            System.out.println((i + 1) + ". " + availableSlots.get(i));
        }
        System.out.print("Please enter option: ");
        int timeId = slotOption.nextInt();
        appointment.setAppointment(availableSlots.get(timeId - 1),patientUsername,timeId);
    }
    void getAllAppointments() {
        //pallavi fetch appointment of data from excel file
        //required fields Fname, Lname, Gender, phno, time 
        ArrayList<String> appointmentDetails = new ArrayList<>();
        appointmentDetails.add("garvitpatel1 |"+" Garvit Patel 1 |"+" 09:00 AM to 10:00 AM");
        appointmentDetails.add("garvitpatel2 |"+" Garvit Patel 2 |"+" 10:00 AM to 11:00 AM");
        appointmentDetails.add("garvitpatel3 |"+" Garvit Patel 3 |"+" 11:00 AM to 12:00 PM");
        appointmentDetails.add("garvitpatel4 |"+" Garvit Patel 4 |"+" 01:00 PM to 02:00 PM");
        for(String details: appointmentDetails){
            System.out.println(details);
        }
    }
    void printInvoice(String patientUsername){
        Scanner invoiceScanner = new Scanner(System.in);
        System.out.println("Please enter appointment charge:");
        float appointmentCharges = Float.parseFloat(invoiceScanner.nextLine());
        System.out.println("Please enter Medicine charge:");
        float medicineCharges = Float.parseFloat(invoiceScanner.nextLine());
        invoiceScanner.nextLine();
        System.out.println("Please enter Payment method (card/cash):");
        String paymentMethod = invoiceScanner.nextLine();
        
        float GST = (appointmentCharges*13)/100;
        float total = appointmentCharges + medicineCharges + GST;
        Appointment appointment = new Appointment();
        HashMap<String, String> userDetails = appointment.getUserDetails(patientUsername);
        
        //Invoice invoice = new Invoice("John","Frost",22,"Med1",250,"Credit Card");
        Invoice invoice = new Invoice(userDetails.get("name"),userDetails.get("phone"),userDetails.get("gender"),total,paymentMethod);
        WriteObjectToFile(invoice);
    }
    void WriteObjectToFile(Object serObj) {
        String filepath="./";
        try {
 
            FileOutputStream fileOut = new FileOutputStream(filepath);
            try (ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                objectOut.writeObject(serObj.toString());
            }
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
        }
    }
}
