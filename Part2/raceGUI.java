import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import  javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
class setupGUI{
    //to setup we need to select
    //Race lengt
    //Number of Typists   DONE
    //Typist specialties/customisation
    //Difficulty modifiers
    //Start Button

    //Version number 0.3 - 10/04/2026 - 11:25AM
    //Authour DANIEL DRYSDALE
    int lastNum;


    //Here are some extracts 
    //<100 character qoutes
    String[] shortQoutes = {
    "‘Victory comes,’ Angron smiled, showing a crescent of bloody teeth, ‘to the last man standing.’", 
    "Argel Tal often said that Fate had a vicious sense of humour. Khârn never doubted it for a second.", 
    "Nature of a compromise is that it leaves everyone more or less equally unhappy.", 
    "This was it. Finally, everyone was working together.", 
    "Freedom is the only thing worth fighting for.     It is why tyrants always fall."};
    //500+ Character qoutes
    String[] longQoutes = {
    "“Why… does it matter?” “Because I think you have a chance to come back from this.  Not much of a chance.  Part of that rides on me.  I could help you, or I could stop you from troubling anyone ever again.  Part of that?  It’s up to you to win the fight, to take control and keep the administrator from claiming everything you have, leaving you a shell.” I felt a chill.  Was part of it my passenger?  Both of us? I opened my mouth to reply, and I couldn’t. Didn’t deserve to, either way. “It’s okay.  I got the answer, myself.” I looked away. I looked up.  My eyes were wet. So many stars.  The universe so vast. We’re s- so very small, in the end.  The first bullet hit me from behind, where my mask offered no coverage, and I slowly toppled.  The second hit me before I could fall, before there could be any pain. ", 
    "He nodded over the battlefield again. ‘And I say once more – your men are losing. You know why? Because yours have something to live for. They care. Mine fight for pleasure, knowing any life outside of war is denied to them. Their own lives are as meaningless to themselves as they are to me, and that is the gift given by the Butcher’s Nails. Warriors, not soldiers. Warriors with no fear of death, and no caution to guard against it. They don’t protect, they kill. They cast aside all thoughts of their own lives in the hunger to end others’. Remember that, Russ. Remember it well.’", 
    "I never wanted this. I never wanted to unleash my legions. Together, we banished the ignorance of Old Night. But you betrayed me, you betrayed us all. You stole power from the Gods and lied to your sons. Mankind has only one chance to prosper, if you will not seize it, then I WILL. So let it be war, from the skies of Terra to the Galactic Rim. Let the seas boil, let the stars fall. Though it takes the last drop of my blood, I will see the galaxy freed once more. And if I cannot save it from your failure, Father, then let the galaxy BURN!", 
    "He remembered being blinded by his father's light. He remembered refusing to abandon his brothers and sisters, beneath a blue sky at high-sun, far from the city of Desh'ea. He remembered the mechanical thunder of absolute betrayal, when he was stolen from the death he'd so richly earned. He remembered the cold moment of truth as he stood in the dark, his hurting eyes healing, that every day he breathed was an unwanted gift. He was walking another man's destiny now. His destiny was to be with the men and women who needed him, who called for him, who followed him into the mountains, and died without him. A destiny denied. He was Angron of Desh'ea. After that, nothing mattered. He'd listened to the others that begged him, that needed it all to matter. He'd played their games, living another man's life. He'd led his fleets, he'd embraced his sons, he'd told himself that blood was thicker than water, and that the Eaters of Worlds were the army he wanted and the horde he deserved. He'd sustained himself on lies, letting none see how he starved. And he served in his cold-hearted father's empire, enduring the silent sneers of brothers he despised.", 
    "‘Be silent! You have given your threats, dog. Now hear me. Listen to another hound barking, for once.’ ‘Then speak,’ Russ had said, as if permission were his to give. ‘I am loyal, the same as you. I am told to bathe my Legion in the blood of innocents and sinners alike, and I do it, because it is all that’s left for me in this life. I do these things, and I enjoy them, not because we are moral, or right – or loving souls seeking to enlighten a dark universe – but because all I feel are the Butcher’s Nails hammered into my brain. I serve because of this “mutilation”. Without it? Well, perhaps I might be a more moral man, like you claim to be. A virtuous man, eh? Perhaps I might ascend the steps of our father’s palace and take the slaving bastard’s head.’ Both Legions tensed. Thousands and thousands of warriors clutched bolters and chainweapons tighter. Lhorke had even taken a step back, his joints loud in the sudden silence. Russ felt no such hesitation. He drew his blade and launched at Angron, only to be met with the World Eater’s axe blocking the blow. The brothers breathed hatred into each other’s faces. ‘You are lost,’ Russ growled. ‘You gelded, black-hearted heretic.’ ‘I am merely honest, brother. In all but this you are no different from me.’ ‘If you cannot see the chasm between savagery and ferocity, then you are hopelessly gone, Angron.’ The World Eater threw Russ back, sending the Wolf King staggering. ‘Then I am gone. But we both know the day will never dawn that you can best me in combat.’"};
    //100-500 character qoutes
    String[] midQoutes = {
    "“More assault and battery,” I said, feeling a touch weary. “Whatever charges come up with the thing at the school. I sort of arranged to have a psychopath kill herself. Um. However you’d charge putting maggots in someone’s eyeballs. In self-defense.”",
    "Perfection has never been about the body, or even the mind. Perfection is a state only the soul can achieve, and, my poor, ignorant brother, there is such perfection in rage.",
    "Sometimes...’ He lays a hand on Angron’s shoulder. ‘Sometimes what you need more than anything in the world is to know that there is someone lower than you. That no matter how dark it may seem, you’re not at the absolute bottom. It isn’t much, but people take power where they can in this world to survive. Watching us die while they still get to live, it’s all the power they’ll ever have",
    "Listen to your blue-clad wretches yelling of courage and honour, courage and honour, courage and honour. Do you even know the meaning of those words? Courage is fighting the kingdom that enslaves you, no matter that their armies overshadow yours by ten thousand to one. You know nothing of courage. Honour is resisting a tyrant when all others suckle and grow fat on the hypocrisy he feeds them. You know nothing of honour",
    "I could have become a mass murderer after I hacked my governor module, but then I realized I could access the combined feed of entertainment channels carried on the company satellites. It had been well over 35,000 hours or so since then, with still not much murdering, but probably, I don't know, a little under 35,000 hours of movies, serials, books, plays and music consumed. As a heartless killing machine, I was a terrible failure.",
    "You could just try being yourself, you know.’ The thought was terrifying. I’d spent so long hiding behind masks I was no longer sure there was a genuine Ciaphas underneath them any more, just a quivering little bundle of self-interest.", 
    "From the moment I understood the weakness of my flesh, it disgusted me. I craved the strength and certainty of steel. I aspired to the purity of the Blessed Machine. Your kind cling to your flesh, as if it will not decay and fail you. One day the crude biomass that you call a temple will wither, and you will beg my kind to save you. But I am already saved, for the Machine is immortal"};

    setupGUI(){
        //Making the frame where everything goes
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


       //Selecting typist number
        JPanel TypistNumSelection = new JPanel();
        TypistNumSelection.setLayout(new BoxLayout(TypistNumSelection, BoxLayout.Y_AXIS));

        Border blackline = BorderFactory.createLineBorder(Color.gray, 1);

        TypistNumSelection.setBorder(blackline);


        JSlider slide = new JSlider(JSlider.HORIZONTAL, 2, 6, 6);

        slide.setMajorTickSpacing(1); // Large ticks every unit
        slide.setPaintTicks(true);     // Display tick marks
        slide.setPaintLabels(true);    // Display numeric labels
        
         //Make an array of frames - each with thier own input
        Panel[] TypistArray = new Panel[6];
        TypistArray[0] = new Panel();
        TypistArray[1] = new Panel();
        TypistArray[2] = new Panel();
        TypistArray[3] = new Panel();
        TypistArray[4] = new Panel();
        TypistArray[5] = new Panel();
        JLabel[] playerLabelArray = new JLabel[6];
        JTextField[] playerNamesArray = new JTextField[6];

        playerNamesArray[0] = new JTextField("", 20);
        playerNamesArray[1] = new JTextField("", 20);
        playerNamesArray[2] = new JTextField("", 20);
        playerNamesArray[3] = new JTextField("", 20);
        playerNamesArray[4] = new JTextField("", 20);
        playerNamesArray[5] = new JTextField("", 20);

        playerLabelArray[0] = new JLabel("Player 1 - Name:");
        playerLabelArray[1] = new JLabel("Player 2 - Name:");
        playerLabelArray[2] = new JLabel("Player 3 - Name:");
        playerLabelArray[3] = new JLabel("Player 4 - Name:");
        playerLabelArray[4] = new JLabel("Player 5 - Name:");
        playerLabelArray[5] = new JLabel("Player 6 - Name:");

        //Need to Add:
        //Typing Style
        JLabel[] typingStyleLabelArray = new JLabel[6];

        @SuppressWarnings("unchecked")
        JComboBox<String>[] typingStyleSelectionArray = new JComboBox[6];

        
        final String[] typingStyles = {"Hunt and Peck", "Touch Typing", "Phone Thumbs", "Voice to Text"};
        typingStyleLabelArray[0] = new JLabel("Typing Style:");
        typingStyleLabelArray[1] = new JLabel("Typing Style:");
        typingStyleLabelArray[2] = new JLabel("Typing Style:");
        typingStyleLabelArray[3] = new JLabel("Typing Style:");
        typingStyleLabelArray[4] = new JLabel("Typing Style:");
        typingStyleLabelArray[5] = new JLabel("Typing Style:");
        for (int i = 0; i < 6; i++) {
            typingStyleSelectionArray[i] = new JComboBox<>(typingStyles);

            
        }

        //Keyboard Type

        JLabel[] KeyboardLabelArray = new JLabel[6];
        final String[] keyboardTypes = {"Mechanical", "Membrane", "Touchscreen", "Sternography"};

        @SuppressWarnings("unchecked")
        JComboBox<String>[] KeyboardSelectionArray = new JComboBox[6];

        KeyboardLabelArray[0] = new JLabel("Keyboard Type:");
        KeyboardLabelArray[1] = new JLabel("Keyboard Type:");   
        KeyboardLabelArray[2] = new JLabel("Keyboard Type:");
        KeyboardLabelArray[3] = new JLabel("Keyboard Type:");
        KeyboardLabelArray[4] = new JLabel("Keyboard Type:");
        KeyboardLabelArray[5] = new JLabel("Keyboard Type:");
        
        for (int i = 0; i < 6; i++) {
            KeyboardSelectionArray[i] = new JComboBox<>(keyboardTypes);    
        }

        //Symbol 
        JLabel[] symbolLabelArray = new JLabel[6];
        JTextField[] symbolFieldArray = new JTextField[6];

        for (int i = 0; i < 6; i++) {
            symbolLabelArray[i] = new JLabel("Symbol:");
            symbolFieldArray[i] = new JTextField(1);
            symbolFieldArray[i].setDocument(new JTextFieldLimit(1));
        }
        
        //Color
        JLabel[] colorLabelArray = new JLabel[6];
        colorLabelArray[0] = new JLabel("Color:");
        colorLabelArray[1] = new JLabel("Color:");
        colorLabelArray[2] = new JLabel("Color:");
        colorLabelArray[3] = new JLabel("Color:");
        colorLabelArray[4] = new JLabel("Color:");
        colorLabelArray[5] = new JLabel("Color:");

        final String[] colorOptions = {"Red", "Blue", "Green", "Yellow", "Pink", "Cyan", "Magenta", "Orange", "Gray", "Black"};

        @SuppressWarnings("unchecked")
        JComboBox<String>[] ColorSelectionArray = new JComboBox[6];

        for (int i = 0; i < 6; i++) {
            ColorSelectionArray[i] = new JComboBox<>(colorOptions);
        }



        //Accessories
        JLabel[] accessoriesLabelArray = new JLabel[6];
        accessoriesLabelArray[0] = new JLabel("Accessories:");
        accessoriesLabelArray[1] = new JLabel("Accessories:");
        accessoriesLabelArray[2] = new JLabel("Accessories:");
        accessoriesLabelArray[3] = new JLabel("Accessories:");
        accessoriesLabelArray[4] = new JLabel("Accessories:");
        accessoriesLabelArray[5] = new JLabel("Accessories:");

        final String[] accessoriesOptions = {"Wrist Support", "Energy Drink", "Noise-Canceling Headphones", "Ergonomic Chair"};

        @SuppressWarnings("unchecked")
        JComboBox<String>[] AccessoriesSelectionArray = new JComboBox[6];

        for (int i = 0; i < 6; i++) {
            AccessoriesSelectionArray[i] = new JComboBox<>(accessoriesOptions);
        }

        //Final attributes
        //Accuracy, Slide-Back amount, Burnout Risk, Burnout Recovery Time, Slide-Back Risk.


        //Adding the Options to the list.
        
        for (int i = 0; i < 6; i++) {
             TypistArray[i].add(playerLabelArray[i]);
            TypistArray[i].add(playerNamesArray[i]);
            TypistArray[i].add(typingStyleLabelArray[i]);
            TypistArray[i].add(typingStyleSelectionArray[i]);
            TypistArray[i].add(KeyboardLabelArray[i]);
            TypistArray[i].add(KeyboardSelectionArray[i]);
            TypistArray[i].add(colorLabelArray[i]);
            TypistArray[i].add(ColorSelectionArray[i]);
            TypistArray[i].add(symbolLabelArray[i]);
            TypistArray[i].add(symbolFieldArray[i]);
            TypistArray[i].add(accessoriesLabelArray[i]);
            TypistArray[i].add(AccessoriesSelectionArray[i]);
        }
       

        TypistNumSelection.add(slide);

        for(int i = lastNum; i < slide.getValue(); i++){
            TypistNumSelection.add(TypistArray[i]);
        }
        
        lastNum = slide.getValue();
        
        slide.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(lastNum != slide.getValue()){

                    //Here we update a set of inputs - 
                    //so java C:\Users\danie\Desktop\button.javayou have the same amount as the thing on the listener
                    for(int i = 5; i >= slide.getValue(); i--){
                        TypistNumSelection.remove(TypistArray[i]);
                    }
                    for(int i = lastNum; i < slide.getValue(); i++){
                        TypistNumSelection.add(TypistArray[i]);
                    }

                    updateLast(slide.getValue());
                    
                }
                

            }
        });

        

        //
         //The Global modifiers are here

        JPanel globalModifiers = new JPanel();
        globalModifiers.setLayout(new BoxLayout(globalModifiers, BoxLayout.Y_AXIS));
        globalModifiers.setPreferredSize(new Dimension(1200, 200));


        JComboBox<String> globalmodifiersSelection = new JComboBox<>(new String[] {"No  Modifiers", "Autocorrect On", "Caffine Mode", "Night Shift", "All Modifiers"});
        JComboBox<String> passageLengthSecelction = new JComboBox<>(new String[] {"Short Passage", "Medium Passage", "Long Passage", "Random Length Passage"});
        Button StartRaceButton = new Button("Start Race!");
        StartRaceButton.setPreferredSize(new Dimension(200, 50));
        JPanel globalModifiersSelect = new JPanel();

        globalModifiersSelect.add(new JLabel("Global Modifiers:"));
        globalModifiersSelect.add(globalmodifiersSelection);
        globalModifiers.add(globalModifiersSelect);

        JPanel passageLenSelect = new JPanel();

        passageLenSelect.add(new JLabel("Passage Length:"));
        passageLenSelect.add(passageLengthSecelction);
        globalModifiers.add(passageLenSelect);

        JPanel starRacePanel = new JPanel();

        starRacePanel.add(StartRaceButton);
        globalModifiers.add(starRacePanel);

        StartRaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               //Call a function to start the race here
            }
        });

        

        

        mainFrame.add(TypistNumSelection);

        mainFrame.setSize(1000, 1000);

        mainFrame.setVisible(true);
    }
    public void updateLast(int x){

            lastNum = x;
    }

    public void detailedBreakdown(Typist2 typist){
        //This is where we will make a pop up with the detailed breakdown of the stats - this is called when the user clicks the "Show Detailed Breakdown" button on a typist summary.
        //Pull up a new window for it
        JFrame brakdown = new JFrame();
        brakdown.setLayout(new FlowLayout());
        brakdown.setTitle("Detailed Breakdown of " + typist.getName());

        //So now, I get the data from the typist, and display it in a nice way on the window.
        String typingStyle = typist.getTypingStyle();
        String keyboardType = typist.getKeyboardType();
        String accessories = typist.getAccessory();

        //Find base stats from typing style for display
        int tempaccuracyTimes100 = 0;
        int tempSlideBackAmount = 0;
        int tempslideBackChanceTimes100 = 0;
        int tempBurnoutAmount = 0;
        int tempBurnoutTimes1000 = 0;

        if(typingStyle.equals("Hunt and Peck")){
            //low slideback risk, but high burnout risk and less accuracy.
            //Shorter burnouts
            tempaccuracyTimes100 = 40;
            tempSlideBackAmount = 5;
            tempslideBackChanceTimes100 = 10;
            tempBurnoutAmount = 3;
            tempBurnoutTimes1000 = 150;
        }
        else if(typingStyle.equals("Touch Typing")){
            //Generally balacnced, with a slightly higher burnout risk and slightly lower slide back risk.
            //High accuracy
            tempaccuracyTimes100 = 60;
            tempSlideBackAmount = 4;
            tempslideBackChanceTimes100 = 12;
            tempBurnoutAmount = 5;
            tempBurnoutTimes1000 = 130;       
        }
        else if(typingStyle.equals("Phone Thumbs")){
            //Low burnout stats, but high slide back frequency.
            //average accuracy
            tempaccuracyTimes100 = 50;
            tempSlideBackAmount = 5;
            tempslideBackChanceTimes100 = 25;
            tempBurnoutAmount = 3;
            tempBurnoutTimes1000 = 90;
        }
        else if(typingStyle.equals("Voice to Text")){
            //LOW slide back, but  high burnout risk and recovery time.
            //average accuracy
            tempaccuracyTimes100 = 50;
            tempSlideBackAmount = 3;
            tempslideBackChanceTimes100 = 10;
            tempBurnoutAmount = 6;
            tempBurnoutTimes1000 = 150;
           
        }
        JLabel baseStats = new JLabel("<html>" + "Typing Style: " + typingStyle + "<br>" + "Base Accuracy: " + tempaccuracyTimes100/100.0 + "<br>" + "Base Slide Back Amount: " + tempSlideBackAmount + "<br>" + "Base Slide Back Chance: " + tempslideBackChanceTimes100/100.0 + "<br>" + "Base Burnout Amount: " + tempBurnoutAmount + "<br>" + "Base Burnout Risk: " + tempBurnoutTimes1000/10000.0 + "</html>");
        brakdown.add(baseStats);

        //Now We get modifier for keyboard type
        tempaccuracyTimes100 = 0;
        tempSlideBackAmount = 0;
        tempslideBackChanceTimes100 = 0;
        tempBurnoutAmount = 0;
        tempBurnoutTimes1000 = 0;


        if(keyboardType.equals("Mechanical")){
            //Lower burnout risk, but higher slide back risk.
            //Higher accuracy
            tempBurnoutTimes1000 =  - 20;
            tempslideBackChanceTimes100 =  + 3;
            tempaccuracyTimes100 =  + 10;


        }
        else if(keyboardType.equals("Membrane")){
            //lower risks, but higher amounts
            tempBurnoutTimes1000 =  - 10;
            tempslideBackChanceTimes100 =  - 3;
            tempSlideBackAmount =  + 1;
            tempBurnoutAmount =  + 1;

        }
        else if(keyboardType.equals("Touchscreen")){
            //Higher slide back risk, but lower slide back amount.
            tempslideBackChanceTimes100 =  + 5;
            tempSlideBackAmount =  -1;

        }
        else if(keyboardType.equals("Sternography")){
            //Lower slide back risk(-4), but higher burnout risk and recovery time.
            //Higher accuracy
            tempslideBackChanceTimes100 =  -4;
            tempBurnoutTimes1000 =  + 10;
            tempBurnoutAmount =  + 1;
            tempaccuracyTimes100 =  + 10;
        }
        JLabel keyboardStats = new JLabel("<html>" + "Keyboard Type: " + keyboardType + "<br>" + "Accuracy Modifier: " + tempaccuracyTimes100/100.0 + "<br>" + "Slide Back Amount Modifier: " + tempSlideBackAmount + "<br>" + "Slide Back Chance Modifier: " + tempslideBackChanceTimes100/100.0 + "<br>" + "Burnout Amount Modifier: " + tempBurnoutAmount + "<br>" + "Burnout Risk Modifier: " + tempBurnoutTimes1000/10000.0 + "</html>");
        brakdown.add(keyboardStats);
        //Now we get modifiers for accessories
        tempaccuracyTimes100 = 0;
        tempSlideBackAmount = 0;  
        tempslideBackChanceTimes100 = 0;
        tempBurnoutAmount = 0;
        tempBurnoutTimes1000 = 0;


        if(accessories.equals("Wrist Support")){
            //improves burnout recovery time
            tempBurnoutAmount =  - 1;
        }
        else if(accessories.equals("Energy Drink")){
            //improves burnout risk
            tempBurnoutTimes1000 =  - 5;

        }
        else if(accessories.equals("Noise-Canceling Headphones")){
            //improves accuracy
            tempaccuracyTimes100 =  + 5;

        }
        else if(accessories.equals("Ergonomic Chair")){
            //improves slide back risk
            tempslideBackChanceTimes100 =  - 3;

        }
        JLabel accessoriesStats = new JLabel("<html>" + "Accessories: " + accessories + "<br>" + "Accuracy Modifier: " + tempaccuracyTimes100/100.0 + "<br>" + "Slide Back Amount Modifier: " + tempSlideBackAmount + "<br>" + "Slide Back Chance Modifier: " + tempslideBackChanceTimes100/100.0 + "<br>" + "Burnout Amount Modifier: " + tempBurnoutAmount + "<br>" + "Burnout Risk Modifier: " + tempBurnoutTimes1000/10000.0 + "</html>");
        brakdown.add(accessoriesStats);


        brakdown.setSize(600, 200);
        brakdown.setVisible(true);
    }

}
class raceGui{

}
class endRaceGui{

}
class raceGUI{

}

//Sourced from: 
//https://www.tutorialspoint.com/article/how-can-we-limit-the-number-of-characters-inside-a-jtextfield-in-java

class JTextFieldLimit extends PlainDocument {
   private int limit;
   JTextFieldLimit(int limit) {
      super();
      this.limit = limit;
   }
   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
      if (str == null)
         return;
      if ((getLength() + str.length()) <= limit) {
         super.insertString(offset, str, attr);
      }
   }
}