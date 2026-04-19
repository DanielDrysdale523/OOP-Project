import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * A typing race simulation. Three typists race to complete a passage of text,
 * advancing character by character — or sliding backwards when they mistype.
 *
 * This version  can run individual turns and compute universal modifiers and manage up to six typists.
 * 
 * @author Daniel Drysdale
 * @version 1.0 
 */
public class TypingRace2
{
    private int passageLength;   // Total characters in the passage to type
    public Typist2[] TypistArray;

    // Accuracy thresholds for mistype and burnout events
    // (Ty tuned these values "by feel". They may need adjustment.)
    private static final double MISTYPE_BASE_CHANCE = 0.3;
    private static final int    SLIDE_BACK_AMOUNT   = 3;
    private static final int    BURNOUT_DURATION     = 3;

    public int slideBackModifier = 0;
    public int burnoutModifier = 0;
    public Double accuracyModifier = 0.0;

    public int turnCounter = 0;


    /**
     * Constructor for objects of class TypingRace.
     * Sets up the race with a passage of the given length.
     * Initially there are no typists seated.
     *
     * @param passageLength the number of characters in the passage to type
     */
    public TypingRace2(int passageLength)
    {
        this.passageLength = passageLength;
        TypistArray = new Typist2[0];
    }

    /**
     * Seats a typist at the given seat number (1, 2, or 3).
     *
     * @param theTypist  the typist to seat
     * @param seatNumber the seat to place them in (1–3)
     */
   public void addTypist(Typist2 theTypist, int seatNumber)
    {
        if(TypistArray == null){
            TypistArray = new Typist2[1];
            TypistArray[0] = theTypist;
            return;
        }
        if (seatNumber < TypistArray.length){
            TypistArray[seatNumber] = theTypist;
            
        }else if(TypistArray.length < 6){
            Typist2[] newArray = new Typist2[TypistArray.length + 1];
            for(int i = 0; i < TypistArray.length; i++){
                newArray[i] = TypistArray[i];
            }
            newArray[newArray.length - 1] = theTypist;
            
            TypistArray = newArray;
        }else{
            System.out.println("Too many typists! Max is 6.");
        }
    }

    /**
     * Runs a single turn for the typingRace, returning a boolean 
     * for whether the race was finished - returning false if not.
     * turn by turn until one typist completes the full passage.
     */
    public Boolean runTurn(){
        // Advance each typist by one turn
            Boolean[] didPassArray = new Boolean[6];
            for(int i = 0; i < TypistArray.length; i++){
                didPassArray[i] = advanceTypist(TypistArray[i]);
            }

            turnCounter++;
            // Check if any typist has finished the passage
            for(int i = 0; i < TypistArray.length; i++){
                 if ( raceFinishedBy(TypistArray[i])){
                     return true;
                 }
            }
            
            return false;
    }

    /**
     * Returns a string for a given typist's lane, showing their symbol at the correct position
     * placed within the passage.
     *
     * @param Int index, the typist stored seat number
     * @param String passage, the passage to be typed
     * @return a string representing the typist's position in the passage

     */

    public String TypingRacePrintString(int index, String passage) {

       
        
        Typist theTypist = TypistArray[index];

         String returnString = theTypist.getName() + ": - |";
        int spacesBefore = theTypist.getProgress();
        int spacesAfter  = passageLength - theTypist.getProgress();
        for(int i = 0; i < spacesBefore; i++){
            returnString += passage.charAt(i);
        }
        returnString += theTypist.getSymbol();
        for(int i = 0; i < spacesAfter; i++){
            returnString += passage.charAt(spacesBefore + i);
        }
        return returnString + "|";
        
    }


    /**
     * Starts the typing race.
     * All typists are reset to the beginning, then the simulation runs
     * turn by turn until one typist completes the full passage.
     */
    public void startRace()
    {
        boolean finished = false;

        // Reset all typists to the start of the passage
        for(int i = 0; i < TypistArray.length; i++){
            TypistArray[i].resetToStart();
        }
        

        while (!finished)
        {
            // Advance each typist by one turn
            Boolean[] didPassArray = new Boolean[6];
            for(int i = 0; i < TypistArray.length; i++){
                didPassArray[i] = advanceTypist(TypistArray[i]);
            }

            // Print the current state of the race
            printRace(didPassArray);

            // Check if any typist has finished the passage
            for(int i = 0; i < TypistArray.length; i++){
                 if ( raceFinishedBy(TypistArray[i])){
                     finished = true;
                 }
            }

            // Wait 200ms between turns so the animation is visible
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (Exception e) {}
        }
        // Announce the winner and update their accuracy with a small random boost for winning.
        if(finished){
                    Random random = new Random();

                if(raceFinishedBy(TypistArray[0])){
                System.out.println("And the Winner is ..." + TypistArray[0].getName());
                Double x = TypistArray[0].getAccuracy() * 100 + random.nextInt(5);
                TypistArray[0].setAccuracy(x/100.0);
                return;
            }else if(raceFinishedBy(TypistArray[1])){
                System.out.println("And the Winner is ..." + TypistArray[1].getName());
                Double x = TypistArray[1].getAccuracy() * 100 + random.nextInt(5);
                TypistArray[1].setAccuracy(x/100.0);
                return;
        
            }else if(raceFinishedBy(TypistArray[2])){
                System.out.println("And the Winner is ..." + TypistArray[2].getName());
                Double x = TypistArray[2].getAccuracy() * 100 + random.nextInt(5);
                TypistArray[2].setAccuracy(x/100.0);
                return;
    
            }
            else if(raceFinishedBy(TypistArray[3])){
                System.out.println("And the Winner is ..." + TypistArray[3].getName());
                Double x = TypistArray[3].getAccuracy() * 100 + random.nextInt(5);
                TypistArray[3].setAccuracy(x/100.0);
                return;
            }else if(raceFinishedBy(TypistArray[4])){
                System.out.println("And the Winner is ..." + TypistArray[4].getName());
                Double x = TypistArray[4].getAccuracy() * 100 + random.nextInt(5);
                TypistArray[4].setAccuracy(x/100.0);
                return;
        
            }else if(raceFinishedBy(TypistArray[5])){
                System.out.println("And the Winner is ..." + TypistArray[5].getName());
                Double x = TypistArray[5].getAccuracy() * 100 + random.nextInt(5);
                TypistArray[5].setAccuracy(x/100.0);
                return;
    
            }
                
        }
        
    }

    /**
     * Simulates one turn for a typist.
     *
     * If the typist is burnt out, they recover one turn's worth and skip typing.
     * Otherwise:
     *   - They may type a character (advancing progress) based on their accuracy.
     *   - They may mistype (sliding back) — the chance of a mistype should decrease
     *     for more accurate typists.
     *   - They may burn out — more likely for very high-accuracy typists
     *     who are pushing themselves too hard.
     *
     * @param theTypist the typist to advance
     */
    private Boolean advanceTypist(Typist2 theTypist)
    {
        Boolean returnValue = false;
        if (theTypist.isBurntOut())
        {
            // Recovering from burnout — skip this turn
            theTypist.recoverFromBurnout();
            return false;
        }
        // Burnout check — pushing too hard increases burnout risk
        //You first see if you burnout.
        if (Math.random() < theTypist.getBurnoutRisk())
        {
            Random random = new Random();
            theTypist.burnOut(theTypist.getBurnoutRecoveryTime() + burnoutModifier);
            //If you burn out, you loose 0.01 accuracy
            Double x = theTypist.getAccuracy() * 100 - random.nextInt(3);;
            theTypist.setAccuracy(x/100.0);
        }else{
            //So, if you dont burn out, you can try typing
            // Attempt to type a charecter, then check for mistype.
                if (Math.random() < theTypist.getAccuracy() + accuracyModifier)
                {
                    theTypist.typeCharacter();
                }else if(Math.random() < theTypist.getSlideBackRisk()){
                    //failed to type a character, so will slideback
                    theTypist.slideBack(theTypist.getSlideBackAmount() + slideBackModifier);
                    returnValue = true;
                }
            
            
        }

         

        
        return returnValue;
    }

    /**
     * Returns true if the given typist has completed the full passage.
     *
     * @param theTypist the typist to check
     * @return true if their progress has reached or passed the passage length
     */
    private boolean raceFinishedBy(Typist theTypist)
    {
        // In case of overflow, use >=
        if (theTypist == null)
        {
            return false; // No typist in this seat, so can't finish
        }
        if (theTypist.getProgress() >= passageLength)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Prints the current state of the race to the terminal.
     * Shows each typist's position along the passage, burnout state,
     * and a WPM estimate based on current progress.
     */
    private void printRace(Boolean[] did1Fall)
    {
        System.out.print('\u000C'); // Clear terminal

        System.out.println("  TYPING RACE — passage length: " + passageLength + " chars");
        multiplePrint('=', passageLength + 3);
        System.out.println();
        for(int i = 0; i < TypistArray.length; i++){
            printSeat(TypistArray[i], did1Fall[i]);
            System.out.println();
        }

        multiplePrint('=', passageLength + 3);
        System.out.println();
        System.out.println("  [~] = burnt out    [<] = just mistyped");
    }

    /**
     * Prints a single typist's lane.
     *
     * Examples:
     *   |          ⌨           | TURBOFINGERS (Accuracy: 0.85)
     *   |    [zz]               | HUNT_N_PECK  (Accuracy: 0.40) BURNT OUT (2 turns)
     *
     * Note: Ty forgot to show when a typist has just mistyped. That would
     * be a nice improvement — perhaps a [<] marker after their symbol.
     *
     * @param theTypist the typist whose lane to print
     */
    private void printSeat(Typist2 theTypist, Boolean didStall)
    {
        int spacesBefore = theTypist.getProgress();
        int spacesAfter  = passageLength - theTypist.getProgress();
        if(spacesBefore >= passageLength){
            System.out.print('|');
            multiplePrint(' ', passageLength);
            System.out.print(theTypist.getSymbol());
            System.out.print('|');
            System.out.print(' ');
            System.out.print(theTypist.getName()
                + " (Accuracy: " + theTypist.getAccuracy() + ")");
            return;
            
        }

        System.out.print('|');
        multiplePrint(' ', spacesBefore);

        // Always show the typist's symbol so they can be identified on screen.
        // Append ~ when burnt out so the state is visible without hiding identity.
        System.out.print(theTypist.getSymbol());
        if (theTypist.isBurntOut())
        {
            System.out.print('~');
            spacesAfter--; // symbol + ~ together take two characters
        }
        if(didStall){
            System.out.print("[<]");
            spacesAfter--;
            spacesAfter--;
            spacesAfter--;// symbol + [<] together take 4 characters
        }

        multiplePrint(' ', spacesAfter);
        System.out.print('|');
        System.out.print(' ');

        // Print name and accuracy
        if (theTypist.isBurntOut())
        {
            System.out.print(theTypist.getName()
                + " (Accuracy: " + theTypist.getAccuracy() + ")"
                + " BURNT OUT (" + theTypist.getBurnoutTurnsRemaining() + " turns)");
            if(didStall){
                System.out.print(" <- JUST MISYPED");
            }
        }
        else
        {
            System.out.print(theTypist.getName()
                + " (Accuracy: " + theTypist.getAccuracy() + ")");
            if(didStall){
                System.out.print(" <- JUST MISYPED");
            }
        }
        
    }

    /**
     * Prints a character a given number of times.
     *
     * @param aChar the character to print
     * @param times how many times to print it
     */
    private void multiplePrint(char aChar, int times)
    {
        int i = 0;
        while (i < times)
        {
            System.out.print(aChar);
            i = i + 1;
        }
    }
    /**
     * Sets the length of the race
     * @param length the new raace length
     */
    public void setRaceLength(int length){
        passageLength = length;
    }
     /**
     * Returns the length of the race.
     *
     * @return the race length as an integer
     */
    public int getRaceLength(){
        return passageLength;

    }
    /**
     * Constructor for objects of class TypingRace2.
     * Doesnt do anything - here because I get errors if I dont use it
     */
    public TypingRace2() {
    }
    
    /* Main method for class TypingRace2.
    * Sets up three typists, then makes them run a race.
    */ 
    public void main(String a1[]) {
        Typist2 a = new Typist2('7', "75%", 0.75);
        Typist2 b = new Typist2('5', "50%", 0.5);
        Typist2 c = new Typist2('2', "25%", 0.25);
        addTypist(a, 1);
        addTypist(b, 2);
        addTypist(c, 3);
        passageLength = 15;
        startRace();
     }
     
        

}