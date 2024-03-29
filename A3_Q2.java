import java.util.Scanner;

public class A3_Q2 {

    public static void main(String[] args){
        // Assignment {3}

        // Written by: { Hamed Vasheghani farahani 40246686}

        // For COMP 248 Section {COMP 248 R 2232} – Fall 2023

        // this program is designed to record the first name and last name of the skiers, and their time to arrive .

        // afterwards, it ranks them based on who had the lowest time.

        // it displays the 3 lowest times and who achieved each of those times

        // this program assumes that there isn't anyone who arrived at the same time.

        // after each recording of the players name and time, they are given the option to terminate the program or continue recording

        // after the 20 th recording of players and time the program will terminate on its own and notify the user that it has.



        Scanner scan= new Scanner(System.in); // creates a new scanner object

        double firstPlaceTime,secondPlaceTime,thirdPlaceTime,newTime,impossibleTime; // declares these variables which store the time of the player

        int indexOfFirstPlace,indexOfSecondPlace,indexOfThirdPlace;  // declares these variables which is the index of the players in the arrays at that placement

        indexOfFirstPlace=indexOfSecondPlace= indexOfThirdPlace=0; // all indexes are initially set to 0

        impossibleTime=thirdPlaceTime=secondPlaceTime=firstPlaceTime=0; // all set to 0 time which is impossible, used to simplify if statements

        System.out.println("Welcome to the skii ranking program!"); // prints welcoming statement for the program

        System.out.println("Welcome to Mont-Halloween Skiing Contest Ranker."); // welcoming statement for the user

        System.out.println("Whenever a skier make it to the finish line, enter their name and skiing time"); // indicates what the user must do for the program

        double[] arrayTimeOfPlayers= new double[20]; // creates the array for time of players

        String[] arrayNameOfPlayers= new String[20]; // creates array for full name of players

        for (int indexOfCurrentSkier=0; indexOfCurrentSkier<20;indexOfCurrentSkier++) { // loops maximum of 20 times, which is how many skiers will be max recorded

            System.out.println("Please input the skier's name:"); // prints out statement asking for name of skier

            String firstNameOfSkier=scan.next(); // records firstname of skier

            String lastNameOfSkier=scan.next(); // records last name of skier

            String fullNameSkier=firstNameOfSkier+" "+ lastNameOfSkier; // combines first and last name into full name

            arrayNameOfPlayers[indexOfCurrentSkier]=fullNameSkier; // records the full name of the player at that index

            System.out.println("Please input the skier's time:"); // asks the player to input the skiers time

            newTime=scan.nextDouble(); // records the time of that player at that index

              arrayTimeOfPlayers[indexOfCurrentSkier]=newTime; // new time is recorder

            if (newTime<firstPlaceTime||firstPlaceTime==impossibleTime ) { // first place time changes if new timer is faster

                if (indexOfCurrentSkier==1){ // at second loop, anyone that is first place would make the second person second place


                    indexOfSecondPlace=indexOfFirstPlace; // the index of second place is replaced by first place

                    indexOfFirstPlace=indexOfCurrentSkier; // the index of first place is now the index of the current user

                    //sets new time for each position

                    secondPlaceTime=arrayTimeOfPlayers[indexOfSecondPlace]; // second place time is now the time of the current second place skier

                    firstPlaceTime=arrayTimeOfPlayers[indexOfFirstPlace]; // first place time is now the time of the current first place skier

                }
                else if (indexOfCurrentSkier>=2){ // at third  loop, anyone that is first place would make the second person second place and anyone at second would take third place

                    indexOfThirdPlace=indexOfSecondPlace; // the index of third place is replaced by second place

                    indexOfSecondPlace=indexOfFirstPlace; // the index of second place is replaced by first place

                    indexOfFirstPlace=indexOfCurrentSkier;  // the index of first place is now the index of the current user

                    // sets new time for each position

                    firstPlaceTime=arrayTimeOfPlayers[indexOfFirstPlace];// first place time is now the time of the current first place skier

                    secondPlaceTime=arrayTimeOfPlayers[indexOfSecondPlace]; // second place time is now the time of the current second place skier

                    thirdPlaceTime=arrayTimeOfPlayers[indexOfThirdPlace]; // third place time is now the time of the current third place skier

                }



                    else {

                    indexOfFirstPlace = indexOfCurrentSkier; // index of first place = index of current skier

                    firstPlaceTime=newTime; // firstplaceTime replaced by new time
                }

            }

            else if (newTime<secondPlaceTime||secondPlaceTime==impossibleTime ) { // second place time changes if new timer is faster

                if (indexOfCurrentSkier>=2) { //if there are 3 or more loops

                    indexOfThirdPlace = indexOfSecondPlace;

                    indexOfSecondPlace=indexOfCurrentSkier;

                    secondPlaceTime=arrayTimeOfPlayers[indexOfSecondPlace];

                    thirdPlaceTime=arrayTimeOfPlayers[indexOfThirdPlace];

                }
                else {
                    secondPlaceTime = newTime; // new time replaces old time of second place

                    indexOfSecondPlace = indexOfCurrentSkier; //  second place index is index of current user
                }

            } else if (newTime<thirdPlaceTime ||thirdPlaceTime==impossibleTime) { // third place time changes if new timer is faster

                thirdPlaceTime = newTime; // new time replaces old time

                indexOfThirdPlace=indexOfCurrentSkier; // third place index is the index of current skier
            }

            // following if statements state who is in which podium and their time in the competition, each will only appear once a valid time is recorded

            if (firstPlaceTime != impossibleTime) { // if time is not impossible, displays time of first place and their name

                System.out.println("First podium goes to "+arrayNameOfPlayers[indexOfFirstPlace]+" who made it in "+arrayTimeOfPlayers[indexOfFirstPlace] +" second(s)"); // prints name of first lace and their time

            }


            if (secondPlaceTime != impossibleTime) { // if time is not impossible, displays time of second place and their name

                System.out.println("Second podium goes to "+arrayNameOfPlayers[indexOfSecondPlace]+" who made it in "+arrayTimeOfPlayers[indexOfSecondPlace]+" second(s)"); // prints name of second place and their time
            }

            if (thirdPlaceTime != impossibleTime) { // if time is not impossible, displays time of third place and their name

                System.out.println("Third podium goes to "+arrayNameOfPlayers[indexOfThirdPlace]+" who made it in "+arrayTimeOfPlayers[indexOfThirdPlace]+" second(s)"); // prints  name of third place and their time

            }

            if (indexOfCurrentSkier!=19) { // if its not the final skier, the user will be asked if they want to add another skier

                System.out.println("Do you want to add another skier? y/yes: "); // asks if the user wants to input anothr skier

                String response=scan.next(); // string object to record response

                if (!(response.equalsIgnoreCase("y")|| response.equalsIgnoreCase("yes"))) {// if response is not y or yes ignoring cases then the program stops recording new players and their time
                    break;
                }

            }

        } // end of loop for skier record input

        System.out.println("Goodbye!"); //  indicates end of the program

        System.out.println("Thank you for using the Skiing ranker program!"); // indicates to user that the program has terminated
    }

}
