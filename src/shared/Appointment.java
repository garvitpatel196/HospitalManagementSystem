/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import static hospitalmanagementsystem.HospitalManagementSystem.ANSI_GREEN;
import static hospitalmanagementsystem.HospitalManagementSystem.ANSI_RESET;
import hospitalmanagementsystem.models.ScheduleModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author NIAR Tech
 */
public class Appointment {
    
    public ArrayList<String> fetchAvailableSlot() {
        ArrayList<String> slots = new ArrayList<>();
        //pallavi fetch data from excel and add in slots
        slots.add("09:00:00 AM to 10:00:00 AM");
        slots.add("10:00:00 AM to 11:00:00 AM");
        slots.add("11:00:00 AM to 12:00:00 PM");
        slots.add("12:00:00 PM to 01:00:00 PM");
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
        Date date = new Date();
        int hours = date.getHours();
        String username = "";
//        int minutes = date.getMinutes();
        System.out.println(hours+"i love to code");
        ArrayList<ScheduleModel> scheduleRecords = getAllAppointments();
//        ArrayList<String> appointmentTime = new  ArrayList<String>();
//        ReadFromExcel readClass = new ReadFromExcel();
//        scheduleRecords = readClass.readScheduleRecords("schedule",CommonVariables.appointmentLabelsFileName);
        for (ScheduleModel scheduleRecord : scheduleRecords) {
            String timing = scheduleRecord.getTiming();
            String[] scheduleHour = timing.split(":");
            if (Integer.parseInt(scheduleHour[0]) == hours) {
                username = scheduleRecord.getUsername();
            }
        }
        return username;
    }
    
    public  ArrayList<ScheduleModel> getAllAppointments(){
        ArrayList<ScheduleModel> scheduleRecords = new ArrayList<>();
//        ArrayList<String> appointmentTime = new  ArrayList<String>();
        ReadFromExcel readClass = new ReadFromExcel();
        scheduleRecords = readClass.readScheduleRecords("schedule",CommonVariables.appointmentLabelsFileName);
        return scheduleRecords;
    }
    public String getNextPatient(){
        //check according to appointment time and current time
        String patientDetails = "Patient User Name | "+" Patient Name | "+" Patient Phone Number | "+" Patient gender |"+" Booked Time Slot | ";
        System.out.println("Patient Details:\n"+patientDetails);
        return "username";
    }
    public HashMap<String, String> getUserDetails(String patientUsername){
        // fetch all data and store in HashMap
        HashMap<String, String> userDetails = new HashMap<>();
        userDetails.put("username", "garvitpatel196");
        userDetails.put("name","Garvit "+"Patel");
        userDetails.put("phone","4372497878");
        userDetails.put("gender","M");
        return userDetails;
    }
}
