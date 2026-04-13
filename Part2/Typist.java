/**
 * Write a description of class Typist here.
 *
 * Provides an object to serve as a racer in the racing game.
 *
 * @author DanielDrysdale
 * @version 1.0
 */
public class Typist
{
    // Fields of class Typist
    // Hint: you will need six fields. Think carefully about their types.
    // One of them tracks how far along the passage the typist has reached.
    // Another tracks whether the typist is currently burnt out.
    // A third tracks HOW MANY turns of burnout remain (not just whether they are burnt out).
    // The remaining three should be fairly obvious.

    private int currentPlace = 0;
    private int burnOutTurnsLeft = 0;
    private Boolean isBurnedOut = false;

    private char symbol;
    private String name;
    private double accuracy;

    public int slideBackCounter = 0;
    public int successfulTypeCounter = 0;
    public int burnoutCounter = 0;

    public Double personalBest = 0.0;






    // Constructor of class Typist
    /**
     * Constructor for objects of class Typist.
     * Creates a new typist with a given symbol, name, and accuracy rating.
     *
     * @param typistSymbol  a single Unicode character representing this typist (e.g. '①', '②', '③')
     * @param typistName    the name of the typist (e.g. "TURBOFINGERS")
     * @param typistAccuracy the typist's accuracy rating, between 0.0 and 1.0
     */
    public Typist(char typistSymbol, String typistName, double typistAccuracy)
    {
        symbol = typistSymbol;
        name = typistName;
        if(typistAccuracy <=1.0 && typistAccuracy >= 0.0){
            accuracy = typistAccuracy;
        }
        else if (typistAccuracy < 0.0){
            accuracy= 0.0;
        }
        else{
            accuracy = 1.0;
        }
        

    }


    // Methods of class Typist

    /**
     * Sets this typist into a burnout state for a given number of turns.
     * A burnt-out typist cannot type until their burnout has worn off.
     *
     * @param turns the number of turns the burnout will last
     */
    public void burnOut(int turns)
    {
        isBurnedOut = true;
        burnOutTurnsLeft = turns;
        burnoutCounter = burnoutCounter + 1;

    }

    /**
     * Reduces the remaining burnout counter by one turn.
     * When the counter reaches zero, the typist recovers automatically.
     * Has no effect if the typist is not currently burnt out.
     */
    public void recoverFromBurnout()
    {
        if(isBurnedOut){
            burnOutTurnsLeft = burnOutTurnsLeft - 1;
            if(burnOutTurnsLeft <= 0){
                isBurnedOut = false;
            }

        }

    }

    /**
     * Returns the typist's accuracy rating.
     *
     * @return accuracy as a double between 0.0 and 1.0
     */
    public double getAccuracy()
    {
        return accuracy; 
    }

    /**
     * Returns the typist's current progress through the passage.
     * Progress is measured in characters typed correctly so far.
     * Note: this value can decrease if the typist mistypes.
     *
     * @return progress as a non-negative integer
     */
    public int getProgress()
    {
        return currentPlace; 
    }

    /**
     * Returns the name of the typist.
     *
     * @return the typist's name as a String
     */
    public String getName()
    {
        return name; 
    }

    /**
     * Returns the character symbol used to represent this typist.
     *
     * @return the typist's symbol as a char
     */
    public char getSymbol()
    {
        return symbol; 
    }

    /**
     * Returns the number of turns of burnout remaining.
     * Returns 0 if the typist is not currently burnt out.
     *
     * @return burnout turns remaining as a non-negative integer
     */
    public int getBurnoutTurnsRemaining()
    {
        return burnOutTurnsLeft; 
    }

    /**
     * Resets the typist to their initial state, ready for a new race.
     * Progress returns to zero, burnout is cleared entirely.
     */
    public void resetToStart()

    {
        isBurnedOut = false;
        burnOutTurnsLeft = 0;
        currentPlace = 0;


    }

    /**
     * Returns true if this typist is currently burnt out, false otherwise.
     *
     * @return true if burnt out
     */
    public boolean isBurntOut()
    {
        return isBurnedOut; 
    }

    /**
     * Advances the typist forward by one character along the passage.
     * Should only be called when the typist is not burnt out.
     */
    public void typeCharacter()
    {
        currentPlace = currentPlace + 1;
        successfulTypeCounter = successfulTypeCounter + 1;

    }

    /**
     * Moves the typist backwards by a given number of characters (a mistype).
     * Progress cannot go below zero — the typist cannot slide off the start.
     *
     * @param amount the number of characters to slide back (must be positive)
     */
    public void slideBack(int amount)
    {
        if(amount <= currentPlace){
            currentPlace = currentPlace - amount;
        }
        else if(amount > currentPlace){
            currentPlace = 0;
        }
        slideBackCounter = slideBackCounter + 1;


    }

    /**
     * Sets the accuracy rating of the typist.
     * Values below 0.0 should be set to 0.0; values above 1.0 should be set to 1.0.
     *
     * @param newAccuracy the new accuracy rating
     */
    public void setAccuracy(double newAccuracy)
    {
        if(newAccuracy <=1.0 && newAccuracy >= 0.0){
            accuracy = newAccuracy;
        }
        else if (newAccuracy < 0.0){
            accuracy= 0.0;
        }
        else{
            accuracy = 1.0;
        }
        

    }

    /**
     * Sets the symbol used to represent this typist.
     *
     * @param newSymbol the new symbol character
     */
    public void setSymbol(char newSymbol)
    {
        symbol = newSymbol;

    }

    public void setName(String name){
        this.name = name;
    }

    public void setSlideBackAmount(int amount){
        if (amount <= 1) {
            slideBackCounter = 1;
        } else {
            slideBackCounter = amount;
        }
    }
    public void setBurnoutRecoveryTime(int amount){
        if (amount <= 1) {
            burnOutTurnsLeft = 1;
        } else {
            burnOutTurnsLeft = amount;
        }
    }

}
