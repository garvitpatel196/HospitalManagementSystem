/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import static hospitalmanagementsystem.HospitalManagementSystem.ANSI_GREEN;
import static hospitalmanagementsystem.HospitalManagementSystem.ANSI_RESET;
import java.util.ArrayList;

/**
 *
 * @author NIAR Tech
 */
public class Appointment {
    
    public ArrayList<String> fetchAvailableSlot() {
        ArrayList<String> slots = new ArrayList<>();
        //pallavi fetch data from excel and add in slots
        slots.add("09:00 AM to 10:00 AM");
        slots.add("10:00 AM to 11:00 AM");
        slots.add("11:00 AM to 12:00 PM");
        slots.add("12:00 PM to 01:00 PM");
        return slots;
    }

   public void setAppointment(String appointment,String username,int timeId ) {
        //pallavi store data in excel file
        String[] data = new String[3];
        data[1]=Integer.toString(timeId);
        data[2]=username;
        data[0]=appointment;
        WriteToExcel writetoExcel =  new WriteToExcel();
        try{
            writetoExcel.writeData(CommonVariables.appointmentLabelsFileName,CommonVariables.appointmentLabels , data);
            System.out.println("\n" + ANSI_GREEN + "Your Appoint has been booked for " + appointment + ANSI_RESET + "\n\n");
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public void getPatientHistory(String username){
        System.out.println("History of patient...............");
    }
    public String getCurrentPatient(){
        String userDetails = "Patient User Name | "+" Patient Name | "+" Patient Phone Number | "+" Patient gender |"+" Booked Time Slot | ";
        return userDetails;
    }
    public String getNextPatient(){
        //check according to appointment time and current time
        String userDetails = "Patient User Name | "+" Patient Name | "+" Patient Phone Number | "+" Patient gender |"+" Booked Time Slot | ";
        return userDetails;
    }
}
