import java.sql.SQLOutput;
import java.util.Random;

public class GuessingGame extends TwoPlayerGame {
    static String name = "GuessingGame";
    int p1Guess = 1000;
    int p2Guess = 1000;

    // generate random number from 0 to 100
    Random randomGenerator = new Random();
    int min = 0;
    int max = 100;
    int random_int = randomGenerator.nextInt((max - min) + 1) + min;



    /**
     * This methods prints the instruction of the game
     * @return string of instructions
     */
    public String getInstructions() {

        // returning string of instructions to game

        return ("When the game starts the computer will generate a random number between 1\n" +
                "and 100 (including both 1 and 100). The game will prompt each player for a\n" +
                "a guess. Once both players have submitted a valid guess, the game will tell\n" +
                "you which player is closer to the secret number. Once a player has guessed\n" +
                "the secret number, they win and the game is over. If both players correctly\n" +
                "guess the secret number, the game will end in a tie");
    }

    /**
     * This methods checks for winning condition
     * @return true if won false if not
     */
    public boolean isGameWon() {

        // if the guess is equal to the random generated int, the game is won return true

        if (p1Guess == random_int) {
            return true;
        }
        if (p2Guess == random_int) {
            return true;
        }
        return false;
    }

    /**
     * This methods checks for tie condition
     * @return true if tie false if not
     */
    public boolean isGameTied() {

        // if it isn't the first round and p1guess and p2 guess are both equal to the random generated int return true the game is tied

        if (p1Guess != 1000 && p2Guess != 1000) {
            if (p1Guess == p2Guess && random_int == p1Guess && p2Guess == random_int) {
                return true;
            }
        }
        return false;
    }

    /**
     * This methods checks for which players number is closer to target
     * @return which player is closer or both if difference is equal
     */
    public String getCurrentGameState() {

         // if the game is not won or tied and it is not the first round, if the absolute value  of the difference
        // between a p1guess is greater than p2's guess than p2 is closer and vice veraa

        if (currentPlayer == 1 && !isGameWon() && !isGameTied() && p1Guess != 1000 && p2Guess != 1000) {
            if (Math.abs(p1Guess - random_int) > Math.abs(p2Guess - random_int)) {
                return "Player 1 is closer";
            } else if (Math.abs(p1Guess - random_int) < Math.abs(p2Guess - random_int)) {
                return "Player 2 is closer";

            // if the distance is the same than p1guess and p2guess is the equally far away

            } else {
                return "Player 1 and 2 are equally far way.";
            }
        } else {
            return "";
        }
    }

    /**
     * This methods prints to proper player prompt
     * @return prompt for player 1 or 2
     */
    public String getCurrentPlayerPrompt() {

        // switch between players and print their prompts

        if (currentPlayer == 1) {
            currentPlayer = 2;
            return ("Player 1, make your guess: ");
        }
        if (currentPlayer == 2) {
            currentPlayer = 1;
            return ("Player 2, make your guess: ");
        }
        return "";
    }

    /**
     * This methods assigns p1 and p2's guess with input
     * @param input
     */
    public void processCurrentPlayerInput(String input) {

        // attach input as a integer

        int newinput;
        try {
            newinput = Integer.parseInt(input);
        } catch (Exception e) {
            return;
        }

        // if int is a val withing range, assign it to is respective guess

        if (newinput >= 1 && newinput <= 100) {
            if (currentPlayer == 1) {
                p1Guess = newinput;
            } else {
                p2Guess = newinput;
            }
        }else {
            return;
        }
    }
    /**
     * This methods gets the winning player
     * @return winning player
     */
    public int getWinningPlayer() {

        // if the game is won than return the player number of the player that won

        if (isGameWon() == true) {
            if (p1Guess == random_int) {
                winningPlayer = 2;
            } if(p2Guess == random_int) {
                winningPlayer = 1;
            }
        }
        return winningPlayer;
    }

}