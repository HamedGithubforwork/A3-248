import java.util.Scanner; // imports the scanner class

public class A3_Q1 {

    public static void main (String[] args){

        // Assignment {3}

        // Written by: { Hamed Vasheghani farahani 40246686}

        // For COMP 248 Section {COMP 248 R 2232} – Fall 2023

        // this program is intended to act as a basic calculator for addition or subtraction.

        // the user must input 1 or 2 depending on which function they want the calculator to perform

        // the first number after that would indicate how many numbers excluding itself would be used in the calculation.

        // all the calculations will be at the 2nd decimal place.

        // if the user inputs any other number for the mode, it will ask them to use a different number

        // 1 is addition where all numbers except the first will be added together

        // 2 is subtraction where all numbers except the first number will be subtracting the second number inputed

        // for example:

        // : inputing 1 would set it to addition mode

        //  then the following inputs 2 2 2 would do  2+2 and output 4.00 and display that value

        // inputing 2 sets it to subtraction mode

        // : then 2 2 2 would do 2-2= 0.00 and display that value

        //inputting 3 gives the response "wrong operation" and asks for them to input 1 or 2  till they input a valid mode

        // once the operation is finished the user can respond with Y or y or Yes to perform a new operation, this will continue till they don't input those values.



        Scanner scan= new Scanner (System.in); //creates a scanner object to record keyboard inputs

        int numberForAddition=1; // the input from user to perform addition of numbers

        int numberForSubtraction=2; // the input from user to perform subtraction of numbers

        double calculatorOutput; // the variable that stores the final value of the calculation desired

        int totalNumbersInList,calculationType; // first variable is how many numbers will be presented inorder for the calculator to know how many loops it needs to do
                                                // second variable is used to record input of user on which calculation type they want ( addition/subtraction)

        System.out.println("Welcome to this calculator, offering Addition and Subtraction."); //introductory statement to user using program

        boolean continueCalculator=true; //the entire calculator will run until user decides to stop operation

        while(continueCalculator) { // the calculator will continue until the user inputs a value to terminate it at the end

            calculatorOutput = 0; //initially set to 0 to allow it to be used in summation/ subtraction in loops + resets for future loops

            boolean loopCalculationTypeQuestion = true; // used to loop the initial question if user puts the wrong input

            while (loopCalculationTypeQuestion) { // the calculator will repeat the question until a valid mode is selected

                System.out.println("Please select 1 for Addition or 2 for Subtraction: "); //prints the options for calculations the user has and asks for input

                calculationType = scan.nextInt(); // records input from user to know which calculation type they want

                if (calculationType == numberForAddition) { // the user inputs the number for the addition  calculator

                    loopCalculationTypeQuestion = false; //correct input , won't loop the question again

                    System.out.println("Please input your numbers:"); //prints statement asking for input of numbers

                    totalNumbersInList = scan.nextInt(); // first number recorded as the counter for loop

                    for (int positionOfNumberInList = 0; positionOfNumberInList < totalNumbersInList; positionOfNumberInList++) {

                        calculatorOutput += scan.nextDouble(); // sums the numbers in the list excluding the initial number which was totalNumbersInList

                    }

                    System.out.print("The result of your Addition is: "); //prints out the words in ""

                    System.out.format("%.2f%n", calculatorOutput); // prints out the  output of calculation to the 2nd decimal place

                } else if (calculationType == numberForSubtraction) { // the user inputs the number for the subtraction calculator

                    loopCalculationTypeQuestion = false; //correct input  won't loop the question again

                    System.out.println("Please input your numbers:"); //prints statement asking for input of numbers

                    totalNumbersInList = scan.nextInt(); // first number recorded as the counter for loop

                    calculatorOutput = scan.nextDouble(); // first number in calculation is stored here as the rest will be subtracting this number

                    for (int positionOfNumberInList = 0; positionOfNumberInList < totalNumbersInList - 1; positionOfNumberInList++) { // loops through the remaining numbers the list is -1 as first number was stored in calculatorOutput

                        calculatorOutput -= scan.nextDouble(); // records the remaining numbers and subtracts them from the initial value

                    }

                    System.out.print("The result of your Subtraction is: "); // prints out the words in ""

                    System.out.format("%.2f%n", calculatorOutput); // prints out the  output of calculation to the 2nd decimal place

                } else { // if an incorrect number is picked

                    System.out.println("Operation not supported"); //prints statement

                    loopCalculationTypeQuestion = true; // sets the value for looping the se initial question to true till otherwise

                }

            }

            System.out.println("Do you want to perform another operation? y/yes:"); // asks user to respond if they want to terminate

            String response = scan.next(); //records user input response

            if (!(response.equalsIgnoreCase("y")|| response.equalsIgnoreCase("yes"))) { // if the response is not Y nor y nor Yes the calculator won't continue again

                continueCalculator = false; // sets continueCalculation to false, terminating the loop

            }

        }

System.out.println("Goodbye!"); // a goodbye statement

        System.out.println("Thank you for using the Addition and Subtraction Calculator!"); // indicates to the user that the program has terminated

        }

        }






