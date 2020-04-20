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
public class SignUp {
    String msg;
    void signUpMenu() {
        System.out.println("Welcome to Sign Up Menu\n \n");
        Scanner signUpOption = new Scanner(System.in);
        
        System.out.print("Please Enter your First Name: ");
        String fName = signUpOption.nextLine();
        System.out.print("Please Enter your Last Name: ");
        String lName = signUpOption.nextLine();
        System.out.print("Please Enter your Birth Date (DD-MM-YYYY): ");
        String dob = signUpOption.nextLine();
        System.out.print("Please Enter your Username: ");
        String username = signUpOption.nextLine();
        System.out.print("Please Enter your Password: ");
        String password = signUpOption.nextLine();  
        System.out.print("Please Confirm your Password: ");
        String confirmPassword = signUpOption.nextLine();
        
        if(!checkConstraints(fName,lName, dob, username, password, confirmPassword)){
            msg="Suucessfully Signed Up.!";
            System.out.println(msg);
        }
        else{
            System.out.println(msg);
        }
    }
    boolean checkConstraints(String fName,String Lname, String dob, String username, String password, String confirmPassword){
        boolean isValid = false;
        //Check Fname
        //Check Lname
        //Check username
        //Check password
        //Check confirmPassword
        return isValid;
    }
}
