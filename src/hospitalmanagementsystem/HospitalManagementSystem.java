/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

import java.util.Scanner;

/**
 *
 * @author gpatel
 */
public class HospitalManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HospitalManagementSystem hs = new HospitalManagementSystem();
        hs.mainMenu();
    }

    void mainMenu() {
        Scanner option = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.println("Welcome to Hospital Management System...!");
            System.out.println("1. SignUp");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            System.out.print("Please select any option from above list:");
            switch (option.nextInt()) {
                case 1:
                    signUpMenu();
                    break;
                case 2:
                    loginMenu();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter valid input \n \n");
                    break;
            }
        }
    }

    void loginMenu() {
        Scanner loginOption = new Scanner(System.in);
        System.out.println("\n\nWelcome to Login Menu");
        System.out.print("Please Enter your Username: ");
        String username = loginOption.nextLine();
        System.out.print("Please Enter your Password: ");
        String password = loginOption.nextLine();

        String userType = "doctor";
        switch (userType) {
            case "doctor":
                docterDashboard(username);
                break;
            case "patient":
                System.out.println("Welcome to patient's dashboard \n \n");
                break;
            case "receptionist":
                System.out.println("Welcome to receptionist dashboard \n \n");
                break;
        }
    }

    void signUpMenu() {
        System.out.println("Welcome to Sign Up Menu\n \n");
    }

    void docterDashboard(String username) {
        System.out.println("\n\nWelcome " + username + " to the doctor's dashboard \n \n");
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
                    System.out.println("Please enter valid option.");
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

    }
}
