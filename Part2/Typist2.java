/**
 * 
 *
 * Provides an object to serve as a racer in the racing game, with more attributes and deeper customization options.
 *
 * @author DanielDrysdale
 * @version 1.0
 */
public class Typist2 extends Typist
{
    //The Fields represent the new attributes available
    private String typingStyle;
    private String keyboardType;
    private String accessories;
    private String color;
    //These Next feilds are representive of the new statistics that the typist will have.

    private int slideBackAmount;
    private double burnoutRisk;
    private int burnoutRecoveryTime;
    private double slideBackRisk;

    //Base attributes are never changed by the options, and are used to calculate the statistics.
    //All values based around assuming a base typist with 0.5 accuracy
    //options will increase or decrease the base stats by a given number

    final private double baseAccuracy = 0.5;
    final private int baseSlideBackAmount = 5;
    final private double baseBurnoutRisk = 0.0125;
    final private int baseBurnoutRecoveryTime = 4;
    final private double baseSlideBackRisk = 0.15;

    public int overallScore = 0;
    public int financialScore = 0;

    public int top3GamesInRowCounter = 0;
    public int z90PercentAccuracyCounter = 0;
    public int noBurnoutCounter = 0;

    public String title = "";

    public String sponsor = "None";

    public typistHistory[] history = new typistHistory[0];


     // Constructor of class Typist
    /**
     * Constructor for objects of class Typist.
     * Creates a new typist with a given symbol, name, and accuracy rating.
     *
     * @param typistSymbol  a single Unicode character representing this typist (e.g. '①', '②', '③')
     * @param typistName    the name of the typist (e.g. "TURBOFINGERS")
     * @param typistAccuracy the typist's accuracy rating, between 0.0 and 1.0
     */
    public Typist2(char typistSymbol, String typistName, double typistAccuracy) {
        super(typistSymbol, typistName, typistAccuracy);
        slideBackAmount = baseSlideBackAmount;
        burnoutRisk = baseBurnoutRisk;
        burnoutRecoveryTime = baseBurnoutRecoveryTime;
        slideBackRisk = baseSlideBackRisk;
    }

    /**
     * Sets the typing style for the typist.
     *
     * @param style; the typing style to set the typist style to.
     * Valid styles are: "Hunt and Peck", "Touch Typing", "Phone Thumbs", "Voice to Text"
     */
    public void setTypingStyle(String style){
        final String[] ValidStyles = {"Hunt and Peck", "Touch Typing", "Phone Thumbs", "Voice to Text"};
        for (int i = 0; i < ValidStyles.length; i++) {
            if (ValidStyles[i].equals(style)) {
                typingStyle = style;
                i = ValidStyles.length;
            }
        }
    }
    /**
     * Sets the keyboard type for the typist.
     *
     * @param keyboard; the keyboard type to set the typist's keyboard to.
     * Valid keyboard types are: "Mechanical", "Membrane", "Touchscreen", "Sternography"
     */
    public void setKeyboardType(String keyboard){
        final String[] KeyboardTypes = {"Mechanical", "Membrane", "Touchscreen", "Sternography"};
        for (int i = 0; i < KeyboardTypes.length; i++) {
            if (KeyboardTypes[i].equals(keyboard)) {
                keyboardType = keyboard;
                i = KeyboardTypes.length;
            }
        }
    }
    /**
     * sets the Accessory type for the typist.
     *
     * @param accessory; the accessory type to set the typist's accessory to.
     * Valid accessory types are: 
     * "Wrist Support", "Energy Drink", "Noise-Canceling Headphones", "Ergonomic Chair"
     */
    public void setAccessory(String accessory){
        final String[] Accessories = {"Wrist Support", "Energy Drink", "Noise-Canceling Headphones", "Ergonomic Chair"};
        for (int i = 0; i < Accessories.length; i++) {
            if (Accessories[i].equals(accessory)) {
                accessories = accessory;
                i = Accessories.length;
            }
        }
    }

    /**
     * Sets the color of the typist.
     *
     * @param colour; the color to set the typist's color to.
     * Valid colors are: 
     * "Red", "Blue", "Green", "Yellow", "Pink", "Cyan", "Magenta", "Orange", "Gray", "Black"
     */
    public void setColour(String colour){
        final String[] Colours = {"Red", "Blue", "Green", "Yellow", "Pink", "Cyan", "Magenta", "Orange", "Gray", "Black"};
        for (int i = 0; i < Colours.length; i++) {
            if (Colours[i].equals(colour)) {
                color = colour;
                i = Colours.length;
            }
        }
    }

    //Getter methods
    /**
     * Returns the typist's typing style.
     *
     * @return the typing style as a String
     */
    public String getTypingStyle(){
        return typingStyle;
    }
    /**
     * Returns the typist's keyboard type.
     *
     * @return the keyboard type as a String
     */
    public String getKeyboardType(){
        return keyboardType;
    }
    /**
     * Returns the typist's accessory type.
     *
     * @return the accessory type as a String
     */
    public String getAccessory(){
        return accessories;
    }
    /**
     * Returns the typist's color.
     *
     * @return the color as a String
     */
    public String getColour(){
        return color;
    }
    /**
     * Returns the typist's Slide Back amount.
     *
     * @return the Slide Back amount as an int
     */
    public int getSlideBackAmount(){
        return slideBackAmount;
    }
    /**
     * Returns the typist's Burnout Risk.
     *
     * @return the Burnout Risk as a double
     */
    public double getBurnoutRisk(){
        return burnoutRisk;
    }
    /**
     * Returns the typist's Burnout Recovery Time.
     *
     * @return the Burnout Recovery Time as an int
     */
    public int getBurnoutRecoveryTime(){
        return burnoutRecoveryTime;
    }
    /**
     * Returns the typist's Slide Back Risk.
     *
     * @return the Slide Back Risk as a double
     */
    public double getSlideBackRisk(){
        return slideBackRisk;
    }


    /**
     * Updates the statistics for the typist.
     * Method should be called whenever an attribute is changed, 
     * to ensure that the statistics are up to date.
     */
    public void updateStats(){

        int tempaccuracyTimes100 = 0;
        int tempSlideBackAmount = 0;
        int tempslideBackChanceTimes100 = 0;
        int tempBurnoutAmount = 0;
        int tempBurnoutTimes1000 = 0;
        
        //First, modififiers based on typing style
        if(typingStyle.equals("Hunt and Peck")){
            //low slideback risk, but high burnout risk and less accuracy.
            //Shorter burnouts
            tempaccuracyTimes100 = 60;
            tempSlideBackAmount = 5;
            tempslideBackChanceTimes100 = 10;
            tempBurnoutAmount = 3;
            tempBurnoutTimes1000 = 150;
        }
        else if(typingStyle.equals("Touch Typing")){
            //Generally balacnced, with a slightly higher burnout risk and slightly lower slide back risk.
            //High accuracy
            tempaccuracyTimes100 = 80;
            tempSlideBackAmount = 4;
            tempslideBackChanceTimes100 = 12;
            tempBurnoutAmount = 5;
            tempBurnoutTimes1000 = 130;       
        }
        else if(typingStyle.equals("Phone Thumbs")){
            //Low burnout stats, but high slide back frequency.
            //average accuracy
            tempaccuracyTimes100 = 70;
            tempSlideBackAmount = 5;
            tempslideBackChanceTimes100 = 25;
            tempBurnoutAmount = 3;
            tempBurnoutTimes1000 = 90;
        }
        else if(typingStyle.equals("Voice to Text")){
            //LOW slide back, but  high burnout risk and recovery time.
            //average accuracy
            tempaccuracyTimes100 = 70;
            tempSlideBackAmount = 3;
            tempslideBackChanceTimes100 = 10;
            tempBurnoutAmount = 6;
            tempBurnoutTimes1000 = 150;
           
        }

        //Then, modifiers based on keyboard type
        if(keyboardType.equals("Mechanical")){
            //Lower burnout risk, but higher slide back risk.
            //Higher accuracy
            tempBurnoutTimes1000 = tempBurnoutTimes1000 - 20;
            tempslideBackChanceTimes100 = tempslideBackChanceTimes100 + 3;
            tempaccuracyTimes100 = tempaccuracyTimes100 + 10;


        }
        else if(keyboardType.equals("Membrane")){
            //lower risks, but higher amounts
            tempBurnoutTimes1000 = tempBurnoutTimes1000 - 10;
            tempslideBackChanceTimes100 = tempslideBackChanceTimes100 - 3;
            tempSlideBackAmount = tempSlideBackAmount + 1;
            tempBurnoutAmount = tempBurnoutAmount + 1;

        }
        else if(keyboardType.equals("Touchscreen")){
            //Higher slide back risk, but lower slide back amount.
            tempslideBackChanceTimes100 = tempslideBackChanceTimes100 + 5;
            tempSlideBackAmount = tempSlideBackAmount - 1;

        }
        else if(keyboardType.equals("Sternography")){
            //Lower slide back risk(-4), but higher burnout risk and recovery time.
            //Higher accuracy
            tempslideBackChanceTimes100 = tempslideBackChanceTimes100 - 4;
            tempBurnoutTimes1000 = tempBurnoutTimes1000 + 10;
            tempBurnoutAmount = tempBurnoutAmount + 1;
            tempaccuracyTimes100 = tempaccuracyTimes100 + 10;
        }
        //Finally, modifiers based on accessories
        if(accessories.equals("Wrist Support")){
            //improves burnout recovery time
            tempBurnoutAmount = tempBurnoutAmount - 1;
        }
        else if(accessories.equals("Energy Drink")){
            //improves burnout risk
            tempBurnoutTimes1000 = tempBurnoutTimes1000 - 5;

        }
        else if(accessories.equals("Noise-Canceling Headphones")){
            //improves accuracy
            tempaccuracyTimes100 = tempaccuracyTimes100 + 5;

        }
        else if(accessories.equals("Ergonomic Chair")){
            //improves slide back risk
            tempslideBackChanceTimes100 = tempslideBackChanceTimes100 - 3;

        }
        //Now set the values to the calculated temp values.
        setAccuracy(tempaccuracyTimes100/100.0);
        slideBackAmount = tempSlideBackAmount;
        slideBackRisk = (tempslideBackChanceTimes100/100.0);
        burnoutRecoveryTime = tempBurnoutAmount;
        burnoutRisk = (tempBurnoutTimes1000/10000.0); 
    }

    public void setSlideBackAmount(int amount){
        if (amount <= 1) {
            slideBackAmount = 1;
        } else {
            slideBackAmount = amount;
        }
    }
    public void setBurnoutRecoveryTime(int amount){
        if (amount <= 1) {
            burnoutRecoveryTime = 1;
        } else {
            burnoutRecoveryTime = amount;
        }
    }

}
