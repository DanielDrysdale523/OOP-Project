import java.awt.*;
import java.awt.event.ActionListener; 
import  java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.*;

class setupGUI{
    //to setup we need to select
    //Race length
    //Number of Typists
    //Typist specialties/customisation
    //Difficulty modifiers
    //Start Button
    int lastNum;

    setupGUI(){
        //Making the frame where everything goes
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Selecting typist number
        Panel TypistNumSelection = new Panel();

        JSlider slide = new JSlider(JSlider.HORIZONTAL, 2, 6, 5);

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
        TypistArray[0].add(new Button("CANCEL"));
        TypistArray[1].add(new Button("CANCEL"));
        TypistArray[2].add(new Button("CANCEL"));
        TypistArray[3].add(new Button("CANCEL"));
        TypistArray[4].add(new Button("CANCEL"));
        TypistArray[5].add(new Button("CANCEL"));

        TypistNumSelection.add(slide);

        for(int i = lastNum; i < slide.getValue(); i++){
            TypistNumSelection.add(TypistArray[i]);
        }
        
        lastNum = slide.getValue();
        
        slide.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(lastNum != slide.getValue()){

                    System.out.println("----------");
                    //Here we update a set of inputs - 
                    //so you have the same amount as the thing on the listener
                    for(int i = 5; i >= slide.getValue(); i--){
                        System.out.println("Removing " + i);
                        TypistNumSelection.remove(TypistArray[i]);
                    }
                    for(int i = lastNum; i < slide.getValue(); i++){
                        TypistNumSelection.add(TypistArray[i]);
                        System.out.println("Adding " + i);
                    }

                    updateLast(slide.getValue());
                    
                }
                

            }
        });

        
        

    }
    public void updateLast(int i){
        lastNum = i;
    }

}
class raceGui{

}
class endRaceGui{

}
class raceGUI{

}