/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

import static hospitalmanagementsystem.HospitalManagementSystem.*;
import java.util.Scanner;

/**
 *
 * @author gpatel
 */
public class DoctorLogin {
    void docterDashboard(String username) {
        System.out.println("\n\n"+ANSI_CYAN_BACKGROUND+"\n\nWelcome " + username + " to the doctor's dashboard \n \n"+ANSI_RESET);
        boolean flag = true;
        while (flag) {
            System.out.println("1. Enter data for Current Patient's Appointment");
            System.out.println("2. Get Information of Next Patient");
            System.out.println("3. Check history of Current Patient");
            System.out.println("0. Logout");
            System.out.print("Please select any option from above list:");
            Scanner dockDashboardOptions = new Scanner(System.in);
            switch (dockDashboardOptions.nextInt()) {
                case 1:
                    dockDashboardOptions.nextLine();
                    setDataCurrPatient(username);
                    break;
                case 2:
                    getDataNextPatient();
                    break;
                case 3:
                    getHistoryCurrPatient();
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
    void setDataCurrPatient(String username) {
        Scanner currPatientDataInput = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Enter Data for Patient " + username);
            System.out.print("Enter Blood Sugar: " + currPatientDataInput.nextLine());
            System.out.print("Heart Beats: " + currPatientDataInput.nextLine());
            System.out.print("Enter Weight: " + currPatientDataInput.nextLine());
            System.out.print("Symptoms: " + currPatientDataInput.nextLine());
            System.out.print("Prescription: " + currPatientDataInput.nextLine());
            System.out.println("\n\n1. Save");
            System.out.println("2. Renter data");
            System.out.println("0. Go back to main menu without saving");
            System.out.println("Please select any one option from above list: ");
            switch (currPatientDataInput.nextInt()) {
                case 1:
                    currPatientDataInput.nextLine();
                    System.out.println("Data is saved.");
                    flag = false;
                    break;
                case 2:
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("\n\n" +ANSI_RED+"Please enter valid option.");
                    break;
            }
            currPatientDataInput.nextLine();
        }
    }
    void getDataNextPatient() {
        System.out.println("Next Patient Data:");
        System.out.println("Name: Garvit Patel");
        System.out.println("Age: 23");
        System.out.println("Phone Number: 4372497878");
        System.out.println("\n\n");
    }

    void getHistoryCurrPatient() {
        System.out.println("Current Patient's History Tab");
    }
}
