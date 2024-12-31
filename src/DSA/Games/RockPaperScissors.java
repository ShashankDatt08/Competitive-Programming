package Games;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        String[] rps = {"rock", "paper", "scissors"};

        Scanner sc = new Scanner(System.in);
        String player;
        System.out.println("Please enter your name: ");
        player = sc.nextLine();

        while (true){
            String playerMove;

            while(true){
                System.out.println(player + " Please enter your move (rock or paper or scissors): ");
                playerMove = sc.nextLine();

                if(playerMove.equals("exit")){
                    System.out.println("Thanks for playing!" + player + "Bye ");
                    break;
                }

                if(playerMove.equals("rock") || playerMove.equals("paper") || playerMove.equals("scissors")){
                    break;
                } else {
                    System.out.println("Not a valid move");
                }
            }

            String computerMove = rps[new Random().nextInt(rps.length)];
            System.out.println("Computer move: " + computerMove);

            if (playerMove.equals(computerMove)) {
                System.out.println("The game was tie ");
            } else if (playerMove.equals("rock")) {
                if (computerMove.equals("paper")) {
                    System.out.println("You lose!");
                } else if (computerMove.equals("scissors")) {
                    System.out.println("You win!");
                }
            } else if (playerMove.equals("paper")) {
                if (computerMove.equals("scissors")) {
                    System.out.println("You lose!");
                } else if (computerMove.equals("rock")) {
                    System.out.println("You win!");
                }
            } else if (playerMove.equals("scissors")) {
                if (computerMove.equals("rock")) {
                    System.out.println("You lose!");
                } else if (computerMove.equals("paper")) {
                    System.out.println("You win!");
                }
            }
            System.out.println("do you want to play again? (y/n)");
            String playAgain = sc.nextLine().toLowerCase();
            if (!playAgain.equals("y")) {
                System.out.println("Thanks for playing, " + player + "! Goodbye!");
                break;
            }
        }
        sc.close();

    }
}