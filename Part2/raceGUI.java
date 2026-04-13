import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.spi.FormatConversionProvider;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import  javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
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


   
    setupGUI(){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.setLayout(new FlowLayout());




       //Selecting typist number
        JPanel TypistNumSelection = new JPanel();
        TypistNumSelection.setPreferredSize(new Dimension(1200, 300));
        TypistNumSelection.setLayout(new BoxLayout(TypistNumSelection, BoxLayout.Y_AXIS));
        //Have a panel to store the typist info. 
        JPanel typistInfo = new JPanel();
       // typistInfo.setLayout(new BoxLayout(typistInfo, BoxLayout.X_AXIS));

        Border blackline = BorderFactory.createLineBorder(Color.gray, 1);

        TypistNumSelection.setBorder(blackline);


        //Adding Title
        JLabel title = new JLabel("Typist Selection");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.BOLD, 24));
        TypistNumSelection.add(title);


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


        TypistArray[0].setPreferredSize(new Dimension(1200, 50));
        TypistArray[1].setPreferredSize(new Dimension(1200, 50));
        TypistArray[2].setPreferredSize(new Dimension(1200, 50));
        TypistArray[3].setPreferredSize(new Dimension(1200, 50));
        TypistArray[4].setPreferredSize(new Dimension(1200, 50));
        TypistArray[5].setPreferredSize(new Dimension(1200, 50));
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
            TypistArray[i].add(accessoriesLabelArray[i]);
            TypistArray[i].add(AccessoriesSelectionArray[i]);
        }
       

        TypistNumSelection.add(slide);

        for(int i = lastNum; i < slide.getValue(); i++){
            TypistNumSelection.add(TypistArray[i]);
        }

        
        lastNum = slide.getValue();
        //Now we need to make the summary section - this is where we will update the info as the user inputs it.

        JPanel[] TypistSummaryArray = new JPanel[6];
        TypistSummaryArray[0] = new JPanel();
        TypistSummaryArray[1] = new JPanel();
        TypistSummaryArray[2] = new JPanel();
        TypistSummaryArray[3] = new JPanel();
        TypistSummaryArray[4] = new JPanel();
        TypistSummaryArray[5] = new JPanel();



        JLabel[] typistSummaryNames = new JLabel[6];
        
        //We make an array of Typist2s to store the data
        Typist2[] typistDataArray = new Typist2[6];
        JButton[] typistDataButtons = new JButton[6];
        Border[] typistSummaryBorders = new Border[6];
        for (int i = 0; i < 6; i++) {
            typistDataArray[i] = new Typist2('|', ("Player " + (i + 1)), 0.5);
            typistDataArray[i].setTypingStyle("Hunt and Peck");
            typistDataArray[i].setKeyboardType("Mechanical");
            typistDataArray[i].setAccessory("Wrist Support");
            typistDataArray[i].updateStats();

        }
        for (int i = 0; i < 6; i++) {
                    typistSummaryNames[i] = new JLabel("<html>" + typistDataArray[i].getName() + "<br>" + "Accuracy: " + typistDataArray[i].getAccuracy() + "<br>" + "Slide Back Amount: " + typistDataArray[i].getSlideBackAmount() + "<br>" + "Burnout Risk: " + typistDataArray[i].getBurnoutRisk() + "<br>" + "Burnout Recovery Time: " + typistDataArray[i].getBurnoutRecoveryTime() + "<br>" + "Slide Back Risk: " + typistDataArray[i].getSlideBackRisk() + "</html>");
                    TypistSummaryArray[i].add(typistSummaryNames[i]);

                    typistDataButtons[i] = new JButton("Show Detailed Breakdown");
                    TypistSummaryArray[i].add(typistDataButtons[i]);

                    

                    TypistSummaryArray[i].setLayout(new BoxLayout(TypistSummaryArray[i], BoxLayout.Y_AXIS));

                    typistSummaryBorders[i] = BorderFactory.createLineBorder(Color.red, 1);
                    TypistSummaryArray[i].setBorder(typistSummaryBorders[i]);

                    typistInfo.add(TypistSummaryArray[i]);
                    //Add event listenrs to the inputs to update the typist data and summary when they are changed.
                    final int x = i;

                    typistDataButtons[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            detailedBreakdown(typistDataArray[x]);
                        }
                    });

                    typingStyleSelectionArray[i].addActionListener (new ActionListener () {
                        public void actionPerformed(ActionEvent e) {
                            typistDataArray[x].setTypingStyle((String) typingStyleSelectionArray[x].getSelectedItem());
                            typistDataArray[x].updateStats();
                            typistSummaryNames[x].setText("<html>" + typistDataArray[x].getName() + "<br>" + "Accuracy: " + typistDataArray[x].getAccuracy() + "<br>" + "Slide Back Amount: " + typistDataArray[x].getSlideBackAmount() + "<br>" + "Burnout Risk: " + typistDataArray[x].getBurnoutRisk() + "<br>" + "Burnout Recovery Time: " + typistDataArray[x].getBurnoutRecoveryTime() + "<br>" + "Slide Back Risk: " + typistDataArray[x].getSlideBackRisk() + "</html>");

                        }
                    });
                    KeyboardSelectionArray[i].addActionListener (new ActionListener () {
                        public void actionPerformed(ActionEvent e) {
                            typistDataArray[x].setKeyboardType((String) KeyboardSelectionArray[x].getSelectedItem());
                            typistDataArray[x].updateStats();
                            typistSummaryNames[x].setText("<html>" + typistDataArray[x].getName() + "<br>" + "Accuracy: " + typistDataArray[x].getAccuracy() + "<br>" + "Slide Back Amount: " + typistDataArray[x].getSlideBackAmount() + "<br>" + "Burnout Risk: " + typistDataArray[x].getBurnoutRisk() + "<br>" + "Burnout Recovery Time: " + typistDataArray[x].getBurnoutRecoveryTime() + "<br>" + "Slide Back Risk: " + typistDataArray[x].getSlideBackRisk() + "</html>");

                        }
                    });
                    AccessoriesSelectionArray[i].addActionListener (new ActionListener () {
                        public void actionPerformed(ActionEvent e) {
                            typistDataArray[x].setAccessory((String) AccessoriesSelectionArray[x].getSelectedItem());
                            typistDataArray[x].updateStats();
                            typistSummaryNames[x].setText("<html>" + typistDataArray[x].getName() + "<br>" + "Accuracy: " + typistDataArray[x].getAccuracy() + "<br>" + "Slide Back Amount: " + typistDataArray[x].getSlideBackAmount() + "<br>" + "Burnout Risk: " + typistDataArray[x].getBurnoutRisk() + "<br>" + "Burnout Recovery Time: " + typistDataArray[x].getBurnoutRecoveryTime() + "<br>" + "Slide Back Risk: " + typistDataArray[x].getSlideBackRisk() + "</html>");

                        }
                    });
                    playerNamesArray[i].addActionListener (new ActionListener () {
                        public void actionPerformed(ActionEvent e) {
                            typistDataArray[x].setName(playerNamesArray[x].getText());
                            typistSummaryNames[x].setText("<html>" + typistDataArray[x].getName() + "<br>" + "Accuracy: " + typistDataArray[x].getAccuracy() + "<br>" + "Slide Back Amount: " + typistDataArray[x].getSlideBackAmount() + "<br>" + "Burnout Risk: " + typistDataArray[x].getBurnoutRisk() + "<br>" + "Burnout Recovery Time: " + typistDataArray[x].getBurnoutRecoveryTime() + "<br>" + "Slide Back Risk: " + typistDataArray[x].getSlideBackRisk() + "</html>");

                        }
                    });
                    
                     ColorSelectionArray[i].addActionListener (new ActionListener () {
                        public void actionPerformed(ActionEvent e) {
                            typistDataArray[x].setColour((String) ColorSelectionArray[x].getSelectedItem());
                            if(typistDataArray[x].getColour().equals("Red")) {
                                typistSummaryBorders[x] = BorderFactory.createLineBorder(Color.red, 1);
                            }
                            else if(typistDataArray[x].getColour().equals("Blue")) {
                                typistSummaryBorders[x] = BorderFactory.createLineBorder(Color.blue, 1);
                            }
                            else if(typistDataArray[x].getColour().equals("Green")) {
                                typistSummaryBorders[x] = BorderFactory.createLineBorder(Color.green, 1);
                            }
                            else if(typistDataArray[x].getColour().equals("Yellow")) {
                                typistSummaryBorders[x] = BorderFactory.createLineBorder(Color.yellow, 1);
                            }
                            else if(typistDataArray[x].getColour().equals("Pink")) {
                                typistSummaryBorders[x] = BorderFactory.createLineBorder(Color.pink, 1);
                            }
                            else if(typistDataArray[x].getColour().equals("Cyan")) {
                                typistSummaryBorders[x] = BorderFactory.createLineBorder(Color.cyan, 1);
                            }
                            else if(typistDataArray[x].getColour().equals("Magenta")) {
                                typistSummaryBorders[x] = BorderFactory.createLineBorder(Color.magenta, 1);
                            }
                            else if(typistDataArray[x].getColour().equals("Orange")) {
                                typistSummaryBorders[x] = BorderFactory.createLineBorder(Color.orange, 1);
                            }
                            else if(typistDataArray[x].getColour().equals("Gray")) {
                                typistSummaryBorders[x] = BorderFactory.createLineBorder(Color.gray, 1);
                            }
                            else if(typistDataArray[x].getColour().equals("Black")) {
                                typistSummaryBorders[x] = BorderFactory.createLineBorder(Color.black, 1);
                            }
                            TypistSummaryArray[x].setBorder(typistSummaryBorders[x]);

                        }
                    });



        }

        slide.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(lastNum != slide.getValue()){
                    //Here we update a set of inputs - 
                    //so you have the same amount as the thing on the listener
                    //We also update the outputs
                    //java C:\Users\danie\Desktop\button.java
                    for(int i = 5; i >= slide.getValue(); i--){
                        TypistNumSelection.remove(TypistArray[i]);
                        typistInfo.remove(TypistSummaryArray[i]);

                    }
                    for(int i = lastNum; i < slide.getValue(); i++){
                        TypistNumSelection.add(TypistArray[i]);
                        typistInfo.add(TypistSummaryArray[i]);
                    }

                    updateLast(slide.getValue());

                    TypistNumSelection.revalidate();
                    TypistNumSelection.repaint();
                    
                }
                

            }
        });

        

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
                f.remove(TypistNumSelection);
                f.remove(typistInfo);
                f.remove(globalModifiers);
                f.revalidate();
                f.repaint();

                midRaceGui midRace = new midRaceGui();
                midRace.midRaceGuiSetup(f, typistDataArray, slide.getValue(), (String) globalmodifiersSelection.getSelectedItem(), (String) passageLengthSecelction.getSelectedItem());
                
                
                Thread backgroundRun = new Thread(new TypingRacer(f, typistDataArray, slide.getValue(), (String) globalmodifiersSelection.getSelectedItem(), midRace.passage, midRace.qouteOutput));
                backgroundRun.start();




                return;
            }
        });

        

        f.add(TypistNumSelection);
        f.add(typistInfo);
        f.add(globalModifiers);

        f.setSize(1400, 1000);

        f.setVisible(true);
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
class TypingRacer implements Runnable {
    String passage = "";

    Typist2[] typistDataArray;
    int typistCount;
    String globalModifier;
    JPanel outputLabel;
    JFrame frame;
   
    TypingRacer(JFrame x, Typist2[] typistDataArray, int typistCount, String globalModifier, String inputPassage, JPanel outputLabel){
        this.frame = x;
        this.typistDataArray = typistDataArray;
        this.typistCount = typistCount;
        this.globalModifier = globalModifier;
        this.passage = inputPassage;
        this.outputLabel = outputLabel;
        System.out.println("Typing Racer Initialized with " + typistCount + " typists and passage length of " + passage.length() + " characters.");

    }
    
    public TypingRace2 setupRace(Typist2[] typistDataArray, int typistCount, String globalModifier){
        
        //Start the TypingRaceClass
        TypingRace2 typingRace = new TypingRace2(passage.length());

        if(globalModifier.equals("Autocorrect On")){
            typingRace.slideBackModifier = -1;
        }
        else if(globalModifier.equals("Caffine Mode")){
            typingRace.burnoutModifier = -1;
        }
        else if(globalModifier.equals("Night Shift")){
            typingRace.accuracyModifier = -0.05;
        }
        else if(globalModifier.equals("All Modifiers")){
            typingRace.accuracyModifier = -0.05;
            typingRace.slideBackModifier = -1;
            typingRace.burnoutModifier = -1;
        }
        


        for(int i = 0; i < typistCount; i++){
            typingRace.addTypist(typistDataArray[i], i);
        }
        return typingRace;

    }
        

    
    @Override
    public void run() {
        // runs through the turns
        TypingRace2 race = setupRace(typistDataArray, typistCount, globalModifier);
        Boolean finished = false;
        while(!finished){
            finished = race.runTurn();
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (Exception e) {}

            //String tempOutput = race.TypingRacePrintString(typistCount, passage);
            String tempOutput = "<HTML>";
            for(int i = 0; i < typistCount; i++){
                tempOutput += race.TypingRacePrintString(i, passage) + "<br> <br>";
            }
            tempOutput += "</HTML>";

            Thread updateGui = new Thread(new guiUpdater(outputLabel, tempOutput));
            updateGui.start();

        }
        System.out.println("Race Finished!");
         try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (Exception e) {}
        Thread FinalGUI = new Thread(new finalGUI(outputLabel, race, frame));
        FinalGUI.start();
        

    }
}
class finalGUI implements Runnable {

        



    JPanel labelToClear;
    TypingRace2 race;
    JFrame frame;
    finalGUI(JPanel labelToClear, TypingRace2 race, JFrame x){
        this.labelToClear = labelToClear;
        this.race = race;
        this.frame = x;
    }
    @Override
    public void run() {

        

        // goes through, and clears the screen.
        JPanel[] TypistSummaryArray = new JPanel[6];
        TypistSummaryArray[0] = new JPanel();
        TypistSummaryArray[1] = new JPanel();
        TypistSummaryArray[2] = new JPanel();
        TypistSummaryArray[3] = new JPanel();
        TypistSummaryArray[4] = new JPanel();
        TypistSummaryArray[5] = new JPanel();



        JLabel[] typistSummaryNames = new JLabel[6];
        
        
        labelToClear.removeAll();
        labelToClear.revalidate();
        labelToClear.repaint();


        JPanel MainContainer = new JPanel();
        JPanel summaryContainer = new JPanel();
        summaryContainer.setLayout(new BoxLayout(summaryContainer, BoxLayout.X_AXIS));
        MainContainer.setLayout(new BoxLayout(MainContainer, BoxLayout.X_AXIS));


        

        Typist2[] competitors = race.TypistArray;
        //Then sort them based on their position in the race
        for(int x = 0; x < competitors.length - 1; x++){
            for(int y = 0; y < competitors.length - x - 1; y++){
                if(competitors[y].getProgress() < competitors[y + 1].getProgress()){
                    Typist2 temp = competitors[y];
                    competitors[y] = competitors[y + 1];
                    competitors[y + 1] = temp;
                }
            }
        }
        //So we have a sorted list, based on who came first
        int numOFTurns = race.turnCounter;
        Double timePerTurn = 0.2;
        Double totalTime = numOFTurns * timePerTurn;

        for (int i = 0; i < competitors.length; i++) {
            typistSummaryNames[i] = new JLabel("<html>" + competitors[i].getName() + "<br>" + "Accuracy: " + competitors[i].getAccuracy() + "<br>" + "Slide Back Amount: " + competitors[i].getSlideBackAmount() + "<br>" + "Burnout Risk: " + competitors[i].getBurnoutRisk() + "<br>" + "Burnout Recovery Time: " + competitors[i].getBurnoutRecoveryTime() + "<br>" + "Slide Back Risk: " + competitors[i].getSlideBackRisk() + "</html>");
            TypistSummaryArray[i].add(typistSummaryNames[i]);
        }
        



        JPanel[] finalResults = new JPanel[competitors.length];
        JLabel[] winnerLabel = new JLabel[competitors.length];
        for(int i = 0; i < competitors.length; i++){
            //get stats
            int Succesfulturns = competitors[i].successfulTypeCounter;
            int slideBackCount = competitors[i].slideBackCounter;

            Double LPM = (competitors[i].getProgress() / totalTime) * 60.0;
            LPM = Math.round(LPM * 100.0) / 100.0;

            Double accuracyPercentage = (double) Succesfulturns / (Succesfulturns + slideBackCount) * 100;
            accuracyPercentage = Math.round(accuracyPercentage * 100.0) / 100.0;


            int burnoutCount = competitors[i].burnoutCounter;


            Double afterAccuracy = competitors[i].getAccuracy();
            competitors[i].updateStats();
            Double beforeAccuracy = competitors[i].getAccuracy();

            Double accuracyModifierFromBurnout = (( afterAccuracy * 100.0) - (beforeAccuracy * 100.0))/100.0;
            competitors[i].setAccuracy(afterAccuracy);


            //Change based on sponser
            int moneyGained = (int) ((i + 1) * 10 + LPM * 10 - burnoutCount *5) + ((int) (race.getRaceLength()) / 2);

            // CyanCorp 10 coins per slideback
            if(competitors[i].sponsor.equals("CyanCorp")){
                moneyGained += (int) (slideBackCount * 10);
            }
            //OrangeFast 5 coins per LPM
            if(competitors[i].sponsor.equals("OrangeFast")){
                moneyGained += (int)(LPM * 5);
            }
            //RedRight 3 coins per accuracy percentage point
            if(competitors[i].sponsor.equals("RedRight")){
                moneyGained +=  (int)(accuracyPercentage * 3);
            }
            //GreenMaster 50 coins per accuracy lost percentage point
            if(competitors[i].sponsor.equals("GreenMaster")){
                moneyGained += (int)(accuracyModifierFromBurnout * -100 * 50);
            }

            //BlueBoost 75 coins per burnout 
            if(competitors[i].sponsor.equals("BlueBoost")){
                moneyGained += (int)(burnoutCount * 75);
            }
            //GrayCris coins * 105%
            if(competitors[i].sponsor.equals("GrayCris")){
                moneyGained = (int)(moneyGained * 1.05);
            }
            //PinkPower doules Coins gained from position.
            if(competitors[i].sponsor.equals("PinkPower")){
                moneyGained += (int)((competitors.length - i) * 10);
            }






            
            if(moneyGained < race.getRaceLength()){
                moneyGained = race.getRaceLength();
            }

            competitors[i].financialScore += moneyGained;

            //Update the overall score
            competitors[i].overallScore += competitors.length -i;

            //Need to add titles

            //Speedy - finish in the top half three rounds in a row
            //Zooming finish in the top half six rounds in a row
            //Supersonic finish in the top half nine rounds in a row
            if(i < competitors.length / 2){
                competitors[i].top3GamesInRowCounter += 1;

            }else{
                competitors[i].top3GamesInRowCounter = 0;
            }
            //Accurate - achieve over 90% accuracy three rounds in a row
            //Pinpoint - achieve over 90% accuracy six rounds in a row
            //Impeccable - achieve over 90% accuracy nine rounds in a row

            if(accuracyPercentage > 90){
                competitors[i].z90PercentAccuracyCounter += 1;
            }else{
                competitors[i].z90PercentAccuracyCounter = 0;
            }

            //Copper Fingers - complete a race without burning out
            //Iron Fingers - complete three races without burning out
            //Steel Fingers - complete five races without burning out

            if(burnoutCount == 0){
                competitors[i].noBurnoutCounter += 1;
            }else{
                competitors[i].noBurnoutCounter = 0;
            }
            //Now assign the titles based on the counters
            String competeTitle = "";


            if (competitors[i].top3GamesInRowCounter >=9) {
                competeTitle = "Supersonic";
                
            }
            else if (competitors[i].top3GamesInRowCounter >=6){
                competeTitle = "Zooming";
            }else if (competitors[i].top3GamesInRowCounter >=3){
                competeTitle = "Speedy";

            }

            if (competitors[i].z90PercentAccuracyCounter >=9) {
                competeTitle += "Impeccable";
                
            }
            else if (competitors[i].z90PercentAccuracyCounter >=6){
                competeTitle += "Pinpoint";
            }else if (competitors[i].z90PercentAccuracyCounter >=3){
                competeTitle += "Accurate";

            }if (competitors[i].noBurnoutCounter >=5) {
                competeTitle += " Steel Fingered";
                
            }
            else if (competitors[i].noBurnoutCounter >=3){
                competeTitle += " Iron Fingered";
            }else if (competitors[i].noBurnoutCounter >=1){
                competeTitle += " Copper Fingered";

            }
            if(competeTitle.equals("")){
                competitors[i].title = (competeTitle + " Typist ");
            }

            




            typistHistory[] history = new typistHistory[competitors[i].history.length + 1];
            for(int x = 0; x < competitors[i].history.length; x++){
                history[x] = competitors[i].history[x];
            }
            history[history.length - 1] = new typistHistory(competitors[i].getName(), LPM, accuracyPercentage, slideBackCount, burnoutCount, i + 1);
            competitors[i].history = history;

           



            finalResults[i] = new JPanel();
            winnerLabel[i] = new JLabel("<HTML><b>" + (i + 1) + ": " + competitors[i].getName() + "</b><br>" + competitors[i].title + "<br>" + "Sponser: " + competitors[i].sponsor + "<br>" + "LPM: " + LPM + "<br>" + "Achieved Accuracy: " + accuracyPercentage + "%<br>" + "Burnout Count: " + burnoutCount + "<br>" + "Base Accuracy Change: " + accuracyModifierFromBurnout + "<br>" + "Total Earnings: " + competitors[i].financialScore + "<br>" + "Overall Score: " + competitors[i].overallScore + "<br>");
            if(LPM >= competitors[i].personalBest)
            {
                competitors[i].personalBest = LPM;
                winnerLabel[i].setText(winnerLabel[i].getText() + "<br><b>New Personal Best!</b>"  + "</HTML>") ;

            }else{
                winnerLabel[i].setText(winnerLabel[i].getText() + "</HTML>") ;
            }
            winnerLabel[i].setFont(new Font("Serif", Font.BOLD, 16));
            finalResults[i].add(winnerLabel[i]);
            summaryContainer.add(TypistSummaryArray[i]);

            //Now Add buttons to view history, Accept a sponser and to spend gained money.

            //100 for +0.1 acuracy.
            //250 for -1 burnout time
            //300 for -1 slideback distance
            //500 for a random sponser 
            JButton viewHistoryButton = new JButton("View History");
            final int x = i;
            final Double finalLPM = LPM;
            final Double finalaccuracyPercentageq = accuracyPercentage;
            
            viewHistoryButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    openHistory(competitors[x]);
                }
            });
            JButton spendMoneyButton = new JButton("Boost Accuracy (500)");

             spendMoneyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(competitors[x].financialScore >= 500){
                        competitors[x].setAccuracy((competitors[x].getAccuracy() * 100 + 1) / 100);
                        competitors[x].financialScore -= 500;

                        //Update the accuracy in the GUI
                        winnerLabel[x].setText("<HTML><b>" + (x + 1) + ": " + competitors[x].getName() + "</b><br>" + competitors[x].title + "<br>" + "Sponser: " + competitors[x].sponsor + "<br>" + "LPM: " + finalLPM + "<br>" + "Achieved Accuracy: " + finalaccuracyPercentageq + "%<br>" + "Burnout Count: " + burnoutCount + "<br>" + "Base Accuracy Change: " + accuracyModifierFromBurnout + "<br>" + "Total Earnings: " + competitors[x].financialScore + "<br>" + "Overall Score: " + competitors[x].overallScore + "<br>");
                        if(finalLPM >= competitors[x].personalBest){
                            winnerLabel[x].setText(winnerLabel[x].getText() + "<br><b>New Personal Best!</b>"  + "</HTML>") ;
                        }
                        else{
                            winnerLabel[x].setText(winnerLabel[x].getText() + "</HTML>") ;
                        }
                        typistSummaryNames[x].setText("<html>" + competitors[x].getName() + "<br>" + "Accuracy: " + competitors[x].getAccuracy() + "<br>" + "Slide Back Amount: " + competitors[x].getSlideBackAmount() + "<br>" + "Burnout Risk: " + competitors[x].getBurnoutRisk() + "<br>" + "Burnout Recovery Time: " + competitors[x].getBurnoutRecoveryTime() + "<br>" + "Slide Back Risk: " + competitors[x].getSlideBackRisk() + "</html>");


                    }
                }
            });

            JButton reduceBurnoutTimeButton = new JButton("Shorter Burnouts (500)");

            reduceBurnoutTimeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(competitors[x].financialScore >= 500 && competitors[x].getBurnoutRecoveryTime() > 1){
                        competitors[x].financialScore -= 500;

                        competitors[x].setBurnoutRecoveryTime(competitors[x].getBurnoutRecoveryTime() - 1);


                        //Update the accuracy in the GUI
                        winnerLabel[x].setText("<HTML><b>" + (x + 1) + ": " + competitors[x].getName() + "</b><br>" + competitors[x].title + "<br>" + "Sponser: " + competitors[x].sponsor + "<br>" + "LPM: " + finalLPM + "<br>" + "Achieved Accuracy: " + finalaccuracyPercentageq + "%<br>" + "Burnout Count: " + burnoutCount + "<br>" + "Base Accuracy Change: " + accuracyModifierFromBurnout + "<br>" + "Total Earnings: " + competitors[x].financialScore + "<br>" + "Overall Score: " + competitors[x].overallScore + "<br>");
                        if(finalLPM >= competitors[x].personalBest){
                            winnerLabel[x].setText(winnerLabel[x].getText() + "<br><b>New Personal Best!</b>"  + "</HTML>") ;

                        }
                        else{
                            winnerLabel[x].setText(winnerLabel[x].getText() + "</HTML>") ;
                        }
                        typistSummaryNames[x].setText("<html>" + competitors[x].getName() + "<br>" + "Accuracy: " + competitors[x].getAccuracy() + "<br>" + "Slide Back Amount: " + competitors[x].getSlideBackAmount() + "<br>" + "Burnout Risk: " + competitors[x].getBurnoutRisk() + "<br>" + "Burnout Recovery Time: " + competitors[x].getBurnoutRecoveryTime() + "<br>" + "Slide Back Risk: " + competitors[x].getSlideBackRisk() + "</html>");


                    }                
                }
            });

            JButton reduceSlideBackButton = new JButton("Shorter SlideBack (600)");

            reduceSlideBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(competitors[x].financialScore >= 600 && competitors[x].getSlideBackAmount() > 1){
                        competitors[x].financialScore -= 600;
                        competitors[x].setSlideBackAmount(competitors[x].getSlideBackAmount() - 1);
                        

                        //Update the accuracy in the GUI
                        winnerLabel[x].setText("<HTML><b>" + (x + 1) + ": " + competitors[x].getName() + "</b><br>" + competitors[x].title + "<br>" + "Sponser: " + competitors[x].sponsor + "<br>" + "LPM: " + finalLPM + "<br>" + "Achieved Accuracy: " + finalaccuracyPercentageq + "%<br>" + "Burnout Count: " + burnoutCount + "<br>" + "Base Accuracy Change: " + accuracyModifierFromBurnout + "<br>" + "Total Earnings: " + competitors[x].financialScore + "<br>" + "Overall Score: " + competitors[x].overallScore + "<br>");
                        if(finalLPM >= competitors[x].personalBest){
                            winnerLabel[x].setText(winnerLabel[x].getText() + "<br><b>New Personal Best!</b>"  + "</HTML>") ;

                        }
                        else{
                            winnerLabel[x].setText(winnerLabel[x].getText() + "</HTML>") ;
                        }
                        typistSummaryNames[x].setText("<html>" + competitors[x].getName() + "<br>" + "Accuracy: " + competitors[x].getAccuracy() + "<br>" + "Slide Back Amount: " + competitors[x].getSlideBackAmount() + "<br>" + "Burnout Risk: " + competitors[x].getBurnoutRisk() + "<br>" + "Burnout Recovery Time: " + competitors[x].getBurnoutRecoveryTime() + "<br>" + "Slide Back Risk: " + competitors[x].getSlideBackRisk() + "</html>");


                    }
                }
            });

            JButton randomSponserButton = new JButton("Random Sponser (850)");

             randomSponserButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if(competitors[x].financialScore >= 850 && competitors[x].sponsor.equals("None")){
                        competitors[x].financialScore -= 850;
                        //Grab random Sponser
                        String[] sponserArray = {"CyanCorp", "OrangeFast", "RedRight", "GreenMaster", "BlueBoost", "GrayCris", "PinkPower"};
                        int randomIndex = (int) (Math.random() * sponserArray.length);
                        competitors[x].sponsor = sponserArray[randomIndex];


                        //Update the accuracy in the GUI
                        winnerLabel[x].setText("<HTML><b>" + (x + 1) + ": " + competitors[x].getName() + "</b><br>" + competitors[x].title + "<br>" + "Sponser: " + competitors[x].sponsor + "<br>" + "LPM: " + finalLPM + "<br>" + "Achieved Accuracy: " + finalaccuracyPercentageq + "%<br>" + "Burnout Count: " + burnoutCount + "<br>" + "Base Accuracy Change: " + accuracyModifierFromBurnout + "<br>" + "Total Earnings: " + competitors[x].financialScore + "<br>" + "Overall Score: " + competitors[x].overallScore + "<br>");
                        if(finalLPM >= competitors[x].personalBest){
                            winnerLabel[x].setText(winnerLabel[x].getText() + "<br><b>New Personal Best!</b>"  + "</HTML>") ;

                        }
                        else{
                            winnerLabel[x].setText(winnerLabel[x].getText() + "</HTML>") ;
                        }
                        typistSummaryNames[x].setText("<html>" + competitors[x].getName() + "<br>" + "Accuracy: " + competitors[x].getAccuracy() + "<br>" + "Slide Back Amount: " + competitors[x].getSlideBackAmount() + "<br>" + "Burnout Risk: " + competitors[x].getBurnoutRisk() + "<br>" + "Burnout Recovery Time: " + competitors[x].getBurnoutRecoveryTime() + "<br>" + "Slide Back Risk: " + competitors[x].getSlideBackRisk() + "</html>");


                    }
                }
            });

            finalResults[i].add(viewHistoryButton);
            finalResults[i].add(spendMoneyButton);
            finalResults[i].add(reduceBurnoutTimeButton);
            finalResults[i].add(reduceSlideBackButton);
            finalResults[i].add(randomSponserButton);


            finalResults[i].setPreferredSize(new Dimension(200, 450));

            MainContainer.add(finalResults[i]);

        }


        //allows for different leaderboards to be viewed - overall score, and financial score.
        MainContainer.setPreferredSize(new Dimension(1200, 450));
        JPanel leaderboard = new JPanel();
        summaryContainer.setPreferredSize(new Dimension(1200, 100));
        leaderboard.setPreferredSize(new Dimension(1200, 200));
        frame.add(summaryContainer);
        frame.add(leaderboard);

        Typist2[] overallSorted = competitors.clone();
        for(int x = 0; x < overallSorted.length - 1; x++){
            for(int y = 0; y < overallSorted.length - x - 1; y++){
                if(overallSorted[y].overallScore < overallSorted[y + 1].overallScore){
                    Typist2 temp = overallSorted[y];
                    overallSorted[y] = overallSorted[y + 1];
                    overallSorted[y + 1] = temp;
                }
            }
        }
        String overallString = "<HTML><b>Overall Leaderboard:</b><br>";
        for(int i = 0; i < overallSorted.length; i++){
            overallString += (i + 1) + ": " + overallSorted[i].getName() + " - " + overallSorted[i].overallScore + "<br>"; 
        }
        overallString += "</HTML>";
        JLabel overallLabel = new JLabel(overallString);
        overallLabel.setFont(new Font("Serif", Font.BOLD, 16));
        leaderboard.add(overallLabel);

        Typist2[] moneySorted = competitors.clone();
        for(int x = 0; x < moneySorted.length - 1; x++){
            for(int y = 0; y < moneySorted.length - x - 1; y++){
                if(moneySorted[y].financialScore < moneySorted[y + 1].financialScore){
                    Typist2 temp = moneySorted[y];
                    moneySorted[y] = moneySorted[y + 1];
                    moneySorted[y + 1] = temp;
                }
            }
        }
        String moneyString = "<HTML><b>Financial Leaderboard:</b><br>";
        for(int i = 0; i < moneySorted.length; i++){
            moneyString += (i + 1) + ": " + moneySorted[i].getName() + " - " + moneySorted[i].financialScore + "<br>"; 
        }
        moneyString += "</HTML>";
        JLabel moneyLabel = new JLabel(moneyString);
        moneyLabel.setFont(new Font("Serif", Font.BOLD, 16));
        leaderboard.add(moneyLabel);


        

       

        labelToClear.add(MainContainer);
        JComboBox<String> globalmodifiersSelection = new JComboBox<>(new String[] {"No  Modifiers", "Autocorrect On", "Caffine Mode", "Night Shift", "All Modifiers"});
        JComboBox<String> passageLengthSecelction = new JComboBox<>(new String[] {"Short Passage", "Medium Passage", "Long Passage", "Random Length Passage"});

        JPanel globalModifiersSelect = new JPanel();


        globalModifiersSelect.add(new JLabel("Global Modifiers:"));
        globalModifiersSelect.add(globalmodifiersSelection);

        JPanel passageLenSelect = new JPanel();

        passageLenSelect.add(new JLabel("Passage Length:"));
        passageLenSelect.add(passageLengthSecelction);


        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.setPreferredSize(new Dimension(200, 50));
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Call a function to reset the game here
                frame.remove(globalModifiersSelect);
                frame.remove(passageLenSelect);
                frame.remove(playAgainButton);
                frame.remove(labelToClear);
                frame.remove(leaderboard);
                frame.remove(summaryContainer);
                
                frame.revalidate();
                frame.repaint();
                if(competitors[0].getAccuracy() > 0.9){
                    competitors[0].setAccuracy((competitors[0].getAccuracy() * 100 - 3) / 100);

                }

                for(int i = 0; i < competitors.length; i++){
                    competitors[i].resetToStart();
                }

                System.out.println("Play Again Clicked!");

                midRaceGui midRace = new midRaceGui();
                midRace.midRaceGuiSetup(frame, competitors, competitors.length, (String) globalmodifiersSelection.getSelectedItem(), (String) passageLengthSecelction.getSelectedItem());
                
                
                Thread backgroundRun = new Thread(new TypingRacer(frame, competitors, competitors.length, (String) globalmodifiersSelection.getSelectedItem(), (String) midRace.passage ,  midRace.qouteOutput));
                backgroundRun.start();
                return;

            }

        });


        frame.add(globalModifiersSelect);
        frame.add(passageLenSelect);
        frame.add(playAgainButton);


        labelToClear.revalidate();
        labelToClear.repaint();






        return;
        
    }
    int count = 0;
    public void openHistory(Typist2 typist){
        //This is where we will make a pop up with the history of the typist - this is called when the user clicks the "View History" button on a typist summary.
        //Pull up a new window for it
        JFrame history = new JFrame();
        history.setLayout(new FlowLayout());
        history.setTitle("History of " + typist.getName());

        //So now, I get the data from the typist, and display it in a nice way on the window.

        String historyString = "<HTML><b>History of " + typist.getName() + ":</b><br><br>";
        count = typist.history.length - 1;
        JButton nextButton = new JButton("Next");
        JButton prevButton = new JButton("Previous");

        history.add(prevButton);
        history.add(nextButton);

        historyString = "<HTML><b>History of " + typist.getName() + ":</b><br>" + "Race " + (count + 1) + ": " + "LPM: " + typist.history[count].LPM + ", Accuracy: " + typist.history[count].accuracy + ", Slide Backs: " + typist.history[count].slideBacks + ", Burnouts: " + typist.history[count].burnouts + ", Position: " + typist.history[count].positionFinished + "<br></HTML>";
        JLabel historyLabel = new JLabel(historyString);
        history.add(historyLabel);


        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                changeCount(count + 1);

                String  historyString2 = "<HTML><b>History of " + typist.getName() + ":</b><br>" + "Race " + (count + 1) + ": " + "LPM: " + typist.history[count].LPM + ", Accuracy: " + typist.history[count].accuracy + ", Slide Backs: " + typist.history[count].slideBacks + ", Burnouts: " + typist.history[count].burnouts + ", Position: " + typist.history[count].positionFinished + "<br></HTML>";
                historyLabel.setText(historyString2);


            }
        });
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                changeCount(count - 1);
                //So now, I get the data from the typist, and display it in a nice way on the window.
                String  historyString2 = "<HTML><b>History of " + typist.getName() + ":</b><br>" + "Race " + (count + 1) + ": " + "LPM: " + typist.history[count].LPM + ", Accuracy: " + typist.history[count].accuracy + ", Slide Backs: " + typist.history[count].slideBacks + ", Burnouts: " + typist.history[count].burnouts + ", Position: " + typist.history[count].positionFinished + "<br></HTML>";
                historyLabel.setText(historyString2);
                
            }
        });
                
    

        
        

        history.setSize(600, 200);
        history.setVisible(true);

    }
    public void changeCount(Integer x){
        count = x;
    }
    
}
class guiUpdater implements Runnable {
    String newText;
    JPanel labelToUpdate;
    guiUpdater(JPanel labelToUpdate, String newText){
        this.labelToUpdate = labelToUpdate;
        this.newText = newText;
    }
    @Override
    public void run() {
        // goes through, and replaces the text in the label with the new text.
        labelToUpdate.removeAll();
        JLabel x = new JLabel();
        x.setText(newText);
        x.setPreferredSize(new Dimension(1200, 800));
        x.setHorizontalAlignment(SwingConstants.CENTER);
        x.setVerticalAlignment(SwingConstants.CENTER);

        

        labelToUpdate.add(x);
        labelToUpdate.revalidate();
        labelToUpdate.repaint();
        return;
        
    }
}

class midRaceGui{
     //Here are some extracts 
    //<100 character qoutes
    String passage = "w";
    String[] shortQoutes = {
    "‘Victory comes,’ Angron smiled, showing a crescent of bloody teeth, ‘to the last man standing.’", 
    "Argel Tal often said that Fate had a vicious sense of humour. Khârn never doubted it for a second.", 
    "Nature of a compromise is that it leaves everyone more or less equally unhappy.", 
    "This was it. Finally, everyone was working together.", 
    "Freedom is the only thing worth fighting for. It is why tyrants always fall."};
    //500+ Character qoutes
    String[] longQoutes = {
    "“Why… does it matter?” “Because I think you have a chance to come back from this. Not much of a chance. Part of that rides on me. I could help you, or I could stop you from troubling anyone ever again. Part of that? It’s up to you to win the fight, to take control and keep the administrator from claiming everything you have, leaving you a shell.” I felt a chill. Was part of it my passenger? Both of us? I opened my mouth to reply, and I couldn’t. Didn’t deserve to, either way. “It’s okay. I got the answer, myself.” I looked away. I looked up. My eyes were wet. So many stars. The universe so vast. We’re s- so very small, in the end. The first bullet hit me from behind, where my mask offered no coverage, and I slowly toppled. The second hit me before I could fall, before there could be any pain. ", 
    "He nodded over the battlefield again. ‘And I say once more – your men are losing. You know why? Because yours have something to live for. They care. Mine fight for pleasure, knowing any life outside of war is denied to them. Their own lives are as meaningless to themselves as they are to me, and that is the gift given by the Butcher’s Nails. Warriors, not soldiers. Warriors with no fear of death, and no caution to guard against it. They don’t protect, they kill. They cast aside all thoughts of their own lives in the hunger to end others’. Remember that, Russ. Remember it well.’", 
    "I never wanted this. I never wanted to unleash my legions. Together, we banished the ignorance of Old Night. But you betrayed me, you betrayed us all. You stole power from the Gods and lied to your sons. Mankind has only one chance to prosper, if you will not seize it, then I WILL. So let it be war, from the skies of Terra to the Galactic Rim. Let the seas boil, let the stars fall. Though it takes the last drop of my blood, I will see the galaxy freed once more. And if I cannot save it from your failure, Father, then let the galaxy BURN!", 
    "He remembered being blinded by his father's light. He remembered refusing to abandon his brothers and sisters, beneath a blue sky at high-sun, far from the city of Desh'ea. He remembered the mechanical thunder of absolute betrayal, when he was stolen from the death he'd so richly earned. He remembered the cold moment of truth as he stood in the dark, his hurting eyes healing, that every day he breathed was an unwanted gift. He was walking another man's destiny now. His destiny was to be with the men and women who needed him, who called for him, who followed him into the mountains, and died without him. A destiny denied. He was Angron of Desh'ea. After that, nothing mattered. He'd listened to the others that begged him, that needed it all to matter. He'd played their games, living another man's life. He'd led his fleets, he'd embraced his sons, he'd told himself that blood was thicker than water, and that the Eaters of Worlds were the army he wanted and the horde he deserved. He'd sustained himself on lies, letting none see how he starved. And he served in his cold-hearted father's empire, enduring the silent sneers of brothers he despised."};
    //100-500 character qoutes
    String[] midQoutes = {
    "“More assault and battery,” I said, feeling a touch weary. “Whatever charges come up with the thing at the school. I sort of arranged to have a psychopath kill herself. Um. However you’d charge putting maggots in someone’s eyeballs. In self-defense.”",
    "Perfection has never been about the body, or even the mind. Perfection is a state only the soul can achieve, and, my poor, ignorant brother, there is such perfection in rage.",
    "Sometimes...’ He lays a hand on Angron’s shoulder. ‘Sometimes what you need more than anything in the world is to know that there is someone lower than you. That no matter how dark it may seem, you’re not at the absolute bottom. It isn’t much, but people take power where they can in this world to survive. Watching us die while they still get to live, it’s all the power they’ll ever have",
    "Listen to your blue-clad wretches yelling of courage and honour, courage and honour, courage and honour. Do you even know the meaning of those words? Courage is fighting the kingdom that enslaves you, no matter that their armies overshadow yours by ten thousand to one. You know nothing of courage. Honour is resisting a tyrant when all others suckle and grow fat on the hypocrisy he feeds them. You know nothing of honour",
    "I could have become a mass murderer after I hacked my governor module, but then I realized I could access the combined feed of entertainment channels carried on the company satellites. It had been well over 35,000 hours or so since then, with still not much murdering, but probably, I don't know, a little under 35,000 hours of movies, serials, books, plays and music consumed. As a heartless killing machine, I was a terrible failure.",
    "You could just try being yourself, you know.’ The thought was terrifying. I’d spent so long hiding behind masks I was no longer sure there was a genuine Ciaphas underneath them any more, just a quivering little bundle of self-interest.", 
    "From the moment I understood the weakness of my flesh, it disgusted me. I craved the strength and certainty of steel. I aspired to the purity of the Blessed Machine. Your kind cling to your flesh, as if it will not decay and fail you. One day the crude biomass that you call a temple will wither, and you will beg my kind to save you. But I am already saved, for the Machine is immortal"};
    JPanel qouteOutput;

    public void midRaceGuiSetup(JFrame f, Typist2[] typistDataArray, int typistCount, String globalModifier, String passageLength){

        //Setup the GUI with this function
        String passageTemp = "123456789012345";

        if(passageLength.equals("Short Passage")){
            passageTemp = shortQoutes[(int)(Math.random() * shortQoutes.length)];
        }
        else if(passageLength.equals("Medium Passage")){
            passageTemp = midQoutes[(int)(Math.random() * midQoutes.length)];
        }
        else if(passageLength.equals("Long Passage")){
            passageTemp = longQoutes[(int)(Math.random() * longQoutes.length)];
        }
        else if(passageLength.equals("Random Length Passage")){
            int rand = (int)(Math.random() * 3);
            if(rand == 0){
                passageTemp = shortQoutes[(int)(Math.random() * shortQoutes.length)];
            }
            else if(rand == 1){
                passageTemp = midQoutes[(int)(Math.random() * midQoutes.length)];
            }
            else{
                passageTemp = longQoutes[(int)(Math.random() * longQoutes.length)];
            }
        }
        passage = passageTemp;



        qouteOutput = new JPanel();
        qouteOutput.add(new JLabel("<html><div style='text-align: center;'>" + passage + "</div></html>"));
        


        Border blackline = BorderFactory.createLineBorder(Color.gray, 1);

        qouteOutput.setBorder(blackline);
        f.add(qouteOutput);
        f.setLayout(new FlowLayout());
        f.revalidate();
        f.repaint();
        f.setVisible(true);
        

        System.out.println("Rendered Race GUI with passage: " + passage);

        



        return;
    }
    public synchronized void updateQouteOutput(String newQoute){
        qouteOutput.removeAll();
        qouteOutput.add(new JLabel("<html><div style='text-align: center;'>" + newQoute + "</div></html>"));
        qouteOutput.revalidate();
        qouteOutput.repaint();
    }
    
    

    

}

class endRaceGui{

}
class raceGUI{
    //run with java "C:\Users\danie\Desktop\OOP PROJECT\TypingRaceSimulator\Part2\raceGUI.java"
    public static void main(String[] args) {

        setupGUI x = new setupGUI();
        


    }
    

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