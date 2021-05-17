import java.util.Scanner;

public class OtherGame extends TwoPlayerGame
{
    // initialize string name and char game board

    static String name = "RockPaperScissors";
    char [] theGame = {'X','X'};

    /**
     * This methods prints the instruction of the game
     * @return string of instructions
     */
    public String getInstructions()
    {
        // returning string of instructions to game

        return "When the game starts, a board will be printed with an input option for both players 1\n" +
                "the game will prompt both players for asking for what they want to play 1\n" +
                "the players will select one of the following charcters - R(Rock), P(Paper), S(Sciscors)1\n" +
                "if their choices are the same the game will end in a tie, otherwise the player whose choice is superior" +
                "will";
    }

    /**
     * This methods checks for winning condition
     * @return true if won false if not
     */
    public boolean isGameWon() {

        // checking all possible conditions to win and returning true if game is won

        if (theGame[0] == 'R' && theGame[1] == 'S') {
            return true;
            }
        if (theGame[0] == 'S' && theGame[1] == 'R') {
            return true;
        }

        if (theGame[0] == 'S' && theGame[1] == 'P'){
            return true;
        }
        if (theGame[0] == 'P' && theGame[1] == 'S') {
            return true;
        }

        if (theGame[0] == 'P' && theGame[1] == 'R'){
            return true;
        }
        if (theGame[0] == 'R' && theGame[1] == 'P') {
            return true;
        }
        return false;
    }

    /**
     * This methods checks for tie condition
     * @return true if tie false if not
     */
    public boolean isGameTied() {

        // is not in the first round the both players play the same charcter the game is tie and return true

        if (theGame[0] != 'X' && theGame[1] != 'X') {
            if (theGame[0] == theGame[1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * This methods prints the game state of the game board
     * @return string representation of the game board
     */
    public String getCurrentGameState()
    {
        // the string state of the game board

        String gameBoard = ("Player 1: " + "Choice" + " Player 2: " + "Choice");
        return gameBoard;
    }

    /**
     * This methods prints to proper player prompt
     * @return prompt for player 1 or 2
     */
    public String getCurrentPlayerPrompt()
    {

        // returning the respective prompt for each player

        if (currentPlayer == 1) {
            return "Player 1, Choose what you want to play: ";
        } else {
            return "Player 2, Choose what you want to play: ";
        }
    }

    /**
     * This methods assigns the user input to the respective players board position
     * @param input
     */
    public void processCurrentPlayerInput(String input) {

        // casts input as charchter an assigns the input to the respective player

        char newinput = input.charAt(0);
        if (currentPlayer == 1) {
            theGame[0] = newinput;
            currentPlayer = 2;
        } else {
            theGame[1] = newinput;
            currentPlayer = 1;
        }
    }

    /**
     * This methods gets the winning player
     * @return winning player
     */
    public int getWinningPlayer() {

        // checks to see who has the win condition and return the player number of the player

        if (theGame[0] == 'R' && theGame[1] == 'S') {
            winningPlayer = 1;
        }
        if (theGame[0] == 'S' && theGame[1] == 'R') {
            winningPlayer = 2;
        }

        if (theGame[0] == 'S' && theGame[1] == 'P') {
            winningPlayer = 1;
        }

        if (theGame[0] == 'P' && theGame[1] == 'S') {
            winningPlayer = 2;
        }

        if (theGame[0] == 'P' && theGame[1] == 'R') {
            winningPlayer = 1;
        }
        if (theGame[0] == 'R' && theGame[1] == 'P') {
            winningPlayer = 2;
        }

        return winningPlayer;
    }
}
