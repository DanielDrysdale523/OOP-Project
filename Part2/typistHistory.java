/**
 * Stores Data on a single race completed by a typist
 * @author Daniel Drysdale
 * @version 1.0 
 */
public class typistHistory {
    public String name;
    public Double LPM;
    public Double accuracy;
    public int slideBacks;
    public int burnouts;
    public int positionFinished;
    /**
     * Constructor for objects of class typistHistory.
     * 
     *
     * @param name the name of the typist
     * @param LPM the LPM score of the typist this round
     * @param accuracy the accuracy of the typist this rounf
     * @param slidebacks the number of times the typist slid back this round
     * @param burnouts the number of times the typist burnt out this round
     * @param positionFinished the position the typist finished in this round
     */
    public typistHistory(String name, Double LPM, Double accuracy, int slideBacks, int burnouts, int positionFinished) {
        this.name = name;
        this.LPM = LPM;
        this.accuracy = accuracy;
        this.slideBacks = slideBacks;
        this.burnouts = burnouts;
        this.positionFinished = positionFinished;

    }
}
    
    

