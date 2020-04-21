/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

import static hospitalmanagementsystem.HospitalManagementSystem.*;
import java.util.ArrayList;
import java.util.Scanner;
import shared.Appointment;

/**
 *
 * @author gpatel
 */
public class PatientLogin {
    void patientDashboard(String username) {
        System.out.println("\n==========================================================================");
        System.out.println("\n"+ANSI_CYAN_BACKGROUND+"Welcome " + username + " to the patient's dashboard"+ANSI_RESET);
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
                    scheduleNewAppointment(username);
                    break;
                case 2:
                    System.out.println("\n"+ANSI_GREEN+"You have an appointment with doctor at "+getMyAppointment()+ANSI_RESET+"\n");
                    break;
                case 3:
                    Appointment appointment = new Appointment();
                    appointment.getPatientHistory(username);
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
    void scheduleNewAppointment(String username){
        System.out.println("\n"+ANSI_YELLOW+"Select the slot from below available time"+ANSI_RESET);
        ArrayList<String> availableSlots;
        Appointment appointment = new Appointment();
        availableSlots = appointment.fetchAvailableSlot();
        for(int i=0; i < availableSlots.size(); i++){
            System.out.println((i+1)+". "+availableSlots.get(i));
        }
        Scanner slotOption = new Scanner(System.in);
        System.out.print("Please enter option: ");
        int timeId = slotOption.nextInt();
        appointment.setAppointment(availableSlots.get(timeId - 1),username,timeId);
    }
    
    String getMyAppointment(){
        //pallavi fetch appointment of data from excel file
        String appointmentTime = "11:00 AM to 12:00 PM";
        return appointmentTime;
    }
}
