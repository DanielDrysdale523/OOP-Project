import java.awt.*;
import javax.swing.*;
import  javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
        

        mainFrame.add(TypistNumSelection);

        mainFrame.setSize(1000, 1000);

        mainFrame.setVisible(true);
    }
    public void updateLast(int x){

            lastNum = x;
    }

}
class raceGui{

}
class endRaceGui{

}
class raceGUI{

}

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