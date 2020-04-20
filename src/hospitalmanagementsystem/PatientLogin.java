/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

import static hospitalmanagementsystem.HospitalManagementSystem.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gpatel
 */
public class PatientLogin {
    void patientDashboard(String username) {
        System.out.println("\n\n"+ANSI_CYAN_BACKGROUND+"\n\nWelcome " + username + " to the doctor's dashboard \n \n"+ANSI_RESET);
        boolean flag = true;
        while (flag) {
            System.out.println("1. Schedule New Appointment");
            System.out.println("2. Check Schedule Appointment.");
            System.out.println("3. Check History");
            System.out.println("0. Logout");
            System.out.print("Please select any option from above list:");
            Scanner patientDashboardOptions = new Scanner(System.in);
            switch (patientDashboardOptions.nextInt()) {
                case 1:
                    patientDashboardOptions.nextLine();
                    scheduleNewAppointment();
                    break;
                case 2:
                    
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
    void scheduleNewAppointment(){
        System.out.println("Select the slot from below available time");
        ArrayList<String> availableSlots;
        availableSlots = fetchAvailableSlot();
        for(int i=0; i < availableSlots.size(); i++){
            System.out.println((i+1)+". "+availableSlots.get(i));
        }
        Scanner slotOption = new Scanner(System.in);
        setAppointment(availableSlots.get(slotOption.nextInt()-1));
    }
    ArrayList<String> fetchAvailableSlot(){
        ArrayList<String> slots= new ArrayList<>();
        //pallavi fetch data from excel and add in slots
        slots.add("09:00 AM to 10:00 AM");
        slots.add("10:00 AM to 11:00 AM");
        slots.add("11:00 AM to 12:00 PM");
        slots.add("12:00 PM to 01:00 PM");
        return slots;
    }
    void setAppointment(String appointment){
        System.out.println(ANSI_GREEN+"Your Appoint has been booked for "+appointment+ANSI_RESET);
        //pallavi store data in excel file
    }
    String getAppointment(){
        //pallavi fetch appointment of data from excel file
        return "";
    }
    
}
