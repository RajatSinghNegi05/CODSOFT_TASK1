import java.util.Scanner;
import java.util.Random;
public class Task1 {

    //  Method that allow user to play multiple round
    static int multiple_round(){
        Scanner sc = new Scanner(System.in);

        // Asking player how many round he/she want to play
        System.out.print("How many round you want to play: ");
        int round = sc.nextInt();
        int i = 0;
        // variable that count no round
        int r_no = 1;

        // variable that count points
        int points = 0;

        // loop for creating multiple round for player
        while(i<round){
            System.out.println();
            System.out.println("This is your round number: "+r_no);
            boolean win =start_game();

            /*condtions that tell player that player win the round or not
            and according to that give him points*/
            if (win){
                points += 10;
                System.out.println("***Yeah***");
                System.out.println("***you win round "+r_no + " ***");
            }
            else {
                System.out.println("!!!OPPS!!!");
                System.out.println("!!!you lost round "+r_no+" !!!");
            }
            i++;
            r_no++;
        }
        return points;
    }

    // Method that check user guess is correct or not
    static boolean start_game(){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        // Generating random guessing number range upto (1-100)
        int secret_num = r.nextInt(100)+1;
        System.out.println();
        System.out.println("I have generated number range (1-100)");
        //System.out.println("This is your guessing no "+secret_num);
        System.out.println();
        int i = 0;

        // variable that decide player win game or not
        boolean win = false ;

        // variable that show the limited no of guess to guess the secret number
        int chance = 3;

        // variable to count number of guess player have to guess the secret number
        int ch = chance;

        //loop to input and check the player guessing number
        while (i<chance){
            System.out.println("You have "+ch+" chance to guess the no");
            System.out.print("Guess the number : ");
            int user_Guess = sc.nextInt();
            if(user_Guess == secret_num) {
                System.out.println("Your Guess is Correct");
                System.out.println();
                win = true;
                break;
            } else if (user_Guess<secret_num){
                System.out.println("Your Guess is low");
                System.out.println();
            }else {
                System.out.println("Your Guess is high");
                System.out.println();
            }
            i++;
            ch--;
        }
        return win;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***Welcome to the guessing number game***");

        // Asking user if he/she want to play this game or not
        System.out.print("Do you want to play guessing game yes/no : ");
        String input = sc.next();
        System.out.println();
        int score = 0 ;
        if(input.equals("yes")){
            score = multiple_round();
        }
        else {
            System.out.println("Thanks for playing guessing game");
        }
        System.out.println();

        // showing player score based on round he/she won
        System.out.println("***your total score***");
        System.out.println(score);

        sc.close();
    }
}
