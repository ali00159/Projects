abstract class TwoPlayerGame
{
    static String name = "Two Player Game";
    protected int currentPlayer = 1;
    protected int winningPlayer = 0;

    /**
     * this is a constructor
     */
    public TwoPlayerGame()
    {
    }

    /**
     * this method prints the instruction for the game tictactoe
     * @return Instructions of game
     */
    public String getInstructions()
    {
        return "";
    }

    /**
     * this methods checks if the condition for a win are met
     * @return true is game is won and false if not won
     */
    public boolean isGameWon()
    {
        return false;
    }

    /**
     * this method checks if a tie condition is met
     * @return true if tie or false if not
     */
    public boolean isGameTied()
    {
        return false;
    }
    /**
     * this method gets the current game state
     * @return string of game state
     */
    public String getCurrentGameState()
    {
        return "";
    }
    /**
     * this method gets the proper player prompt
     * @return string of prompt
     */
    public String getCurrentPlayerPrompt()
    {
        return "";
    }

    /**
     * this is a method process a valid user input for the game
     * @param input
     */
    public void processCurrentPlayerInput(String input) {

    }

    /**
     * this method gets the player who won game
     * @return winning player
     */
    public int getWinningPlayer()
    {
        return winningPlayer;
    }
}
