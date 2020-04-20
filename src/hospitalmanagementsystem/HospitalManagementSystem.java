/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

import static hospitalmanagementsystem.HospitalManagementSystem.ANSI_CYAN_BACKGROUND;
import static hospitalmanagementsystem.HospitalManagementSystem.ANSI_RESET;
import java.util.Scanner;

/**
 *
 * @author gpatel
 */
public class HospitalManagementSystem {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
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
            System.out.println("\n==========================================================================");
            System.out.println("\n"+ANSI_CYAN_BACKGROUND+"Welcome to Hospital Management System...!"+ANSI_RESET);
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
                    LoginMenu menu = new LoginMenu();
                    menu.loginMenu();
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
}

class LoginMenu{
    String userType;
    void loginMenu() {
        Scanner loginOption = new Scanner(System.in);
        System.out.println("\n==========================================================================");
        System.out.println("\n"+ANSI_CYAN_BACKGROUND+"Welcome to Login Menu"+ANSI_RESET);
        System.out.print("Please Enter your Username: ");
        String username = loginOption.nextLine();
        System.out.print("Please Enter your Password: ");
        String password = loginOption.nextLine();
        
        if(isValidLoginCredentials(username,password)){
            System.out.println("Login Successfull");
            System.out.println("Redirecting to your Dashboard");
                switch (userType) {
                case "doctor":
                    DoctorLogin doctorObj = new DoctorLogin();
                    doctorObj.docterDashboard(username);
                    break;
                case "patient":
                    PatientLogin patientObj = new PatientLogin();
                    patientObj.patientDashboard(username);
                    System.out.println("Welcome to patient's dashboard \n \n");
                    break;
                case "receptionist":
                    ReceptionistLogin receptionistObj = new ReceptionistLogin();
                    System.out.println("Welcome to receptionist dashboard \n \n");
                    break;
            }
        }
    }
    boolean isValidLoginCredentials(String username, String password){
        //pallavi fetch data from excel and validate credentials.
        userType = "patient";
        return true;
    }
}