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

    void mainMenu(){
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
                    SignUp signupObj = new SignUp();
                    signupObj.signUpMenu();
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
                DoctorLogin doctorObj = new DoctorLogin();
                doctorObj.docterDashboard(username);
                break;
            case "patient":
                PatientLogin patientObj = new PatientLogin();
                System.out.println("Welcome to patient's dashboard \n \n");
                break;
            case "receptionist":
                ReceptionistLogin receptionistObj = new ReceptionistLogin();
                System.out.println("Welcome to receptionist dashboard \n \n");
                break;
        }
    }
}
