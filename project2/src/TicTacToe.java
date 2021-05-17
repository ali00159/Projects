public class TicTacToe extends TwoPlayerGame
{
    // intializing game board and string name

    char [] board = new char[9];
    static String name = "TicTacToe";

    /**
     * this is a constructor for the char game board
     */
   public TicTacToe (){

       // default board constructor using char game board using for loop to print char values onto board

       for (int i = 0; i < board.length; i++){
           board[i] = (char)(i + 49);
       }
   }

    /**
     * this method prints the instruction for the game tictactoe
     * @return Instructions of game
     */
    public String getInstructions()
    {
        return ("The starting player places an 'x' in one of the locations on the grid.\n" +
                "The second player then places a 'o' on one of the grid locations, but\n" +
                "not one that was previously chosen. This continues until either all the\n" +
                "grid locations have been filled, or until a player wins. A player wins\n" +
                "by placing their \"pieces\" in three grid locations that either share\n" +
                "the same row, column, or diagonal.");
    }
    /**
     * this methods checks if the condition for a win are met
     * @return true is game is won and false if not won
     */
    public boolean isGameWon() {

        // checking all possibilites to win a game of tictactoe and return true if condition is met

        if (board[0] == board[1] && board[0] == board[2]) {
            return true;
        }
        if (board[3] == board[4] && board[3] == board[5]) {
            return true;
        }
        if (board[6] == board[7] && board[6] == board[8]) {
            return true;
        }
        if (board[0] == board[3] && board[0] == board[6]) {
            return true;
        }
        if (board[1] == board[4] && board[1] == board[7]) {
            return true;
        }
        if (board[2] == board[5] && board[2] == board[8]) {
            return true;
        }
        if (board[0] == board[4] && board[0] == board[8]) {
            return true;
        }
        if (board[2] == board[4] && board[2] == board[6]) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * this method checks if a tie condtion is met
     * @return true if tie or false if not
     */
    public boolean isGameTied() {

        // for loop to check all gameboard pieces, if the gameboard is not compelety filled, return false, otherwise return true

        for (int i = 0; i < board.length; i++)
            if (board[i] != 'x' && board[i] != 'y')
                return false;
        return true;
    }

    /**
     * this method gets the state of the gameboard
     * @return the string representation of gameboard
     */
    public String getCurrentGameState() {

        // string representation of the current state of the game board

        String stringBoard = (board[0] + "|" + board[1] + "|" + board[2]) + "\n" + ("-+-+-") + "\n" + (board[3] + "|" + board[4] + "|" + board[5]) + "\n" + ("-+-+-") + "\n" + (board[6] + "|" + board[7] + "|" + board[8]);
        return stringBoard;
    }

    /**
     * this method prints the proper prompt for players
     * @return string of the player prompt
     */
    public String getCurrentPlayerPrompt() {

        // string that gets printed that asks player to chose location on board

        if (currentPlayer == 1) {
            currentPlayer = 2;
            return ("Player 1 (x), please choose a location to play: ");
        } else {
           currentPlayer = 1;
           return ("Player 2 (y), please choose a location to play: ");
        }
    }


    /**
     * this is a method updates gameboard based on player input
     * @param input
     */
    public void processCurrentPlayerInput(String input) {

       // turing string input into int is posssible

       int newinput;
        try {
            newinput = Integer.parseInt(input);
        } catch (Exception e) {
            return;
        }

        // attaching input to board spot an the game board

        if (currentPlayer == 1) {
            board[newinput - 1] = 'y';
        } else {
            board[newinput - 1] = 'x';
        }
    }

    /**
     * this method gets the player who won game
     * @return winning player
     */
    public int getWinningPlayer()
    {

        // if the player turn switched to 1, player 2's move had won the game

        if (currentPlayer == 1) {
            winningPlayer = 2;
        } else {

            // if player turn switched to 2, player 1's move had won the game

            winningPlayer = 1;
        }
        return winningPlayer;
    }
}
