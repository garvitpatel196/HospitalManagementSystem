/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

import static hospitalmanagementsystem.HospitalManagementSystem.*;
import java.util.ArrayList;
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
        while (flag) {
            System.out.println("1. List all the upcoming appointments");
            System.out.println("2. Book New Appointment");
            System.out.println("3. Check History");
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
        
        if (isValidUser(patientUsername)){
            System.out.println("\n" + ANSI_YELLOW + "Select the slot from below available time" + ANSI_RESET);
            ArrayList<String> availableSlots;
            Appointment appointment = new Appointment();
            availableSlots = fetchAvailableSlot();
            for (int i = 0; i < availableSlots.size(); i++) {
                System.out.println((i + 1) + ". " + availableSlots.get(i));
            }
            System.out.print("Please enter option: ");
            int timeId = slotOption.nextInt();
            appointment.setAppointment(availableSlots.get(timeId - 1),patientUsername,timeId);
        }
        else{
            System.out.println("\n\n" +ANSI_RED+"Invalid Username...!"+ANSI_RESET);
        }
    }
    boolean isValidUser(String username){
        //pallavi check username if it is a valid username or not
        boolean valid=true;
        return valid;
    }
    ArrayList<String> fetchAvailableSlot() {
        ArrayList<String> slots = new ArrayList<>();
        //pallavi fetch data from excel and add in slots
        slots.add("09:00 AM to 10:00 AM");
        slots.add("10:00 AM to 11:00 AM");
        slots.add("11:00 AM to 12:00 PM");
        slots.add("12:00 PM to 01:00 PM");
        return slots;
    }

    void setAppointment(String appointment, String username) {
        System.out.println("\n" + ANSI_GREEN + "Your Appointment has been booked for " + appointment + ANSI_RESET + "\n\n");
        //pallavi store data in excel file
    }

    ArrayList<String> getAllAppointments() {
        //pallavi fetch appointment of data from excel file
        //required fields Fname, Lname, Gender, phno, time 
        ArrayList<String> appointmentTime = new ArrayList<>();
        appointmentTime.add("09:00 AM to 10:00 AM");
        appointmentTime.add("10:00 AM to 11:00 AM");
        appointmentTime.add("11:00 AM to 12:00 PM");
        
        return appointmentTime;
    }
}
