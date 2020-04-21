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
        System.out.println("\n" + ANSI_GREEN + "Your Appoint has been booked for " + appointment + ANSI_RESET + "\n\n");
        //pallavi store data in excel file
        String[] data = new String[3];
        int i =0 ;
        data[i++]=Integer.toString(timeId);
        data[i++]=username;
        data[i]=appointment;
        WriteToExcel writetoExcel =  new WriteToExcel();
        try{
            writetoExcel.writeData(CommonVariables.appointmentLabelsFileName,CommonVariables.appointmentLabels , data);
            
        }catch(Exception e){
        System.err.println(e);
        }
    }
}
