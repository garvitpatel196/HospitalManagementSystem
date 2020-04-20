/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

import java.util.Scanner;
import shared.WriteToExcel;

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
            System.out.println("\n\n==========================================================================");
            System.out.println("\n\n"+ANSI_CYAN_BACKGROUND+"Welcome to Hospital Management System...!"+ANSI_RESET);
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
                case 3:
                WriteToExcel writeMethod = new WriteToExcel();
                try{
                    String[] labels = {"fname","lname","email","pwd","DOB","gender","phoneNo"};
                    String[] data = {"Pal","kotvir","pallavi@gmail.com","Asdf@123","14-081995","Female","9916067559"};
                    writeMethod.writeData("output.xls",labels,data);
                }catch(Exception e){
                    System.out.println(e);
                }
                default:
                    System.out.println("Please enter valid input \n \n");
                    break;
            }
        }
    }

    void loginMenu() {
        Scanner loginOption = new Scanner(System.in);
        System.out.println("\n\n==========================================================================");
        System.out.println("\n\n"+ANSI_CYAN_BACKGROUND+"Welcome to Login Menu"+ANSI_RESET);
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
