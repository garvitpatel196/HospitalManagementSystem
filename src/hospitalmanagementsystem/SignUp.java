/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

import static hospitalmanagementsystem.HospitalManagementSystem.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author gpatel
 */
public class SignUp {
    String msg = "Something went wrong";
    void signUpMenu() {
        System.out.println("\n\n==========================================================================");
        System.out.println("\n\n"+ANSI_CYAN_BACKGROUND+"Welcome to Sign Up Menu\n \n"+ANSI_RESET);
        Scanner signUpOption = new Scanner(System.in);
        boolean signUpLoop = true;
        while(signUpLoop){
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

            if(checkConstraints(fName, lName, dob, username, password, confirmPassword)){
                msg=ANSI_GREEN+"Suucessfully Signed Up.!"+ANSI_RESET;
                System.out.println(msg);
                System.out.println("\n\nRedirecting to main menu....\n\n");
                signUpLoop = false;
            }
            else{
                Scanner option = new Scanner(System.in);
                System.out.println("Do you want to try again?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Please select any option from above list:");
                switch (option.nextInt()) {
                    case 1:
                        break;
                    case 2:
                        signUpLoop = false;
                        break;
                    default:
                        System.out.println("Please enter valid input \n \n");
                        break;
                }
            }
        }
        HospitalManagementSystem mainMenuObj = new HospitalManagementSystem();
        mainMenuObj.mainMenu();    
    }
    boolean checkConstraints(String fName,String lName, String dob, String username, String password, String confirmPassword){
        boolean isValid = true;
        
        //Check Fname
        if(!(fName != null && !fName.trim().equals("") && fName.matches("[a-zA-Z]*"))){
            msg = "\n\n"+ANSI_RED+"Invalid First Name...! First Name can only contain alphabets. (Not even space) \n\n" + ANSI_RESET;
            System.out.println(msg);
            isValid = false;
            return isValid;
        }
        //Check Lname
        if(!(lName != null && !lName.trim().equals("") && lName.matches("[a-zA-Z]*"))){
            msg = "\n\n "+ANSI_RED+"Invalid Last Name...! Last Name can only contain alphabets. (Not even space) \n\n" + ANSI_RESET;
            System.out.println(msg);
            isValid = false;
            return isValid;
        }
        if(!(dob != null && validateJavaDate(dob))){
            msg = "\n\n" +ANSI_RED+" Invalid Date of Birth...! Birth date should be in formate: DD-MM-YYYY"+ ANSI_RESET;
            System.out.println(msg);
            isValid = false;
            return isValid;
        }
        if(!(username != null && !username.trim().equals("") && username.matches("[a-zA-Z0-9]*"))){
            msg = "\n\n" +ANSI_RED+" Invalid Username...! Username can only contain alphnumeric characters"+ ANSI_RESET;
            System.out.println(msg);
            isValid = false;
            return isValid;
        }
        if(!(password != null && !password.trim().equals("") && password.length() >= 8)){
            msg = "\n\n" +ANSI_RED+" Invalid Password...! Password should be atleast 8 charater long"+ ANSI_RESET;
            System.out.println(msg);
            isValid = false;
            return isValid;
        }
        if(!(password.equals(confirmPassword) )){
            msg = "\n\n" +ANSI_RED+" Confirm password did not match...!"+ ANSI_RESET;
            System.out.println(msg);
            isValid = false;
            return isValid;
        }
        return isValid;
    }
    
    
    public static boolean validateJavaDate(String strDate)
    {
         if (strDate.trim().equals(""))
         {
             return true;
         }
         else
         {
             SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
             sdfrmt.setLenient(false);
             try{
                 Date javaDate = sdfrmt.parse(strDate); 
             }
             catch (ParseException e)
             {
                 return false;
             }
             /* Return true if date format is valid */
             return true;
         }
    }
}
