/*
* Course: TCSS142 – Introduction to Object-Oriented Programming
* File Name: Project2.java
* Assignment: 1
* Due Date: February 6th, 2024 - 11:59 P.M
* Instructor: Mr. Schuessler
*
* @author: V.T
*/  
/**
* This program asks for the numnber of employees to process 
their Name, hours they worked, pay rate, and calculate the 
Gross Pay with and without overtime depending on input.
*/

import java.util.Scanner;
public class Project2{

   // Main method to utilize Scanner and call other methods
   public static void main(String[] Args){
      Scanner whatever = new Scanner(System.in);
      int count = getEmployeeCnt(whatever);
      processEmployeePay(count,whatever);
   }
   
   //Method to requests an input from the keyboard (user)
   public static int getEmployeeCnt(Scanner employee) {
      System.out.print("How many employees are there: ");
      return employee.nextInt();
   }
   
   //Method to ask for Hours, Rate, and the Name to be calculated
   public static void processEmployeePay(int theCount, Scanner employee) {
      String name = "";
      
      String topName = "";                       
      
      double hoursWorked = 0.0;                   
 
      double payRate = 0.0;
      
      double grossPay = 0.0;
      
      double topHours = 0.0;

      //Initiate a loop to process the information based on the # of employees
      for (int i = 1;i <= theCount;i++) {
         
         System.out.print("Enter Hours Worked, Pay Rate, and Employee name separated by a space: ");
         
         hoursWorked = employee.nextDouble();                   //Lines 53 - 59...
                                                               //Collect the input from keyboard
         payRate = employee.nextDouble();                      
         
         name = employee.nextLine().substring(1);
         
         grossPay = getGrossPay(hoursWorked,payRate);
         
         if (hoursWorked > topHours) {                 //Collect and store 
            topHours = hoursWorked;                   //Highest hours worked 
            topName = name;                          //and the top employee name
         }
         
         displayEmployeePay(name, payRate, hoursWorked, grossPay);
      }
      displayTopEmployee(topName, topHours);
   }
     
   //Method to calculate the gross pay
   public static double getGrossPay(double theHour, double theRate) {
      double pay = 0.0;
      
      double overtime = 0.0;

      if (theHour > 48.0) {                          //Over 48 hours
         overtime = theHour - 48.0;                                  
         pay += (2 * theRate * overtime) + (1.5 * theRate * 8) + (theRate * 40);

      } else if (theHour > 40.0 && theHour < 48.0) {           //Over 40 but less than 48 hours
         overtime = theHour - 40.0;                       
         pay += (1.5 * theRate * overtime) + (theRate * 40);
         
      } else {                               //Normal Rate 
         pay += theRate * theHour;
      }
      return pay;                //Returns the total amount of pay
   }
   
   //Method to display Name, Hour, Rate, and Gross Pay
   public static void displayEmployeePay(String theName, double theRate, 
                                    double theHour, double theGrossPay) {
      System.out.printf("%24s: %15s","Employee Name", theName);
      System.out.printf("\n%24s: %15.2f","Hours Worked", theHour);
      System.out.printf("\n%24s: %10s%.2f","Pay Rate","$", theRate);
      System.out.printf("\n%24s: %8s%.2f","Gross Pay","$", theGrossPay);
      System.out.printf("\n");
   }
   
   //Method to display the most hard-working employee and the hours they worked
   public static void displayTopEmployee(String theTopName, double theTopHour) {
   
      if (theTopHour >= 56) {          //Over or equal to 56 hours
         System.out.print("WOW!!!! What a Dynamo! " + theTopName + " Worked " + theTopHour + " Hours this WEEK!");
         
      } else if (theTopHour >= 48 && theTopHour < 56) {           //Over or equal to 48 but less than 56 hours
         System.out.print(theTopName + " is Such a WorkHorse! Looks Like You Worked" + theTopHour + " Hours this WEEK!");
         
      } else if (theTopHour >= 40 && theTopHour < 48) {           //Over or equal to 40 but less than 48 hours
         System.out.print("Well, Good For YOU " + theTopName + ",Who Worked " + theTopHour + " Hours this WEEK!");
         
      } else {             //Less than or equal to 40 hours
         System.out.print(theTopName + " Worked " + theTopHour + " Hours this WEEK!");
      }
   }
   
}