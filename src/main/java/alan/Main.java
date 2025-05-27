package alan;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        /*
        * Initializes frame and adds panel
        * Implements additional settings for the frame
        */
        

        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Constants.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1,1 , 1, 1);
        gbc.fill = GridBagConstraints.BOTH; // Make the components expand
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        GridPanel gridPanel = new GridPanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        mainPanel.add(gridPanel, gbc);
        gridPanel.addKeyListener(gridPanel);

        GamePanel gamePanel = new GamePanel();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        mainPanel.add(gamePanel, gbc);
        gamePanel.addKeyListener(gamePanel);
        
        frame.add(mainPanel);

        // Tryout GridBagLayout
        

        frame.setTitle("Rogue Dungeons");
        frame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);           // Sets size of frame (window) (ratio of frameSize variable)
        frame.setVisible(true);                                               // Sets frame as visable
        frame.requestFocus();                                                   // Frame takes focus for keyboard and mouse
        gridPanel.requestFocus();                                               // Panel takes focus for keyboard and mouse
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                   // Program will terminate on exit from frame
        frame.setLocationRelativeTo(null);                                    // Sets Frame to center of screen
        frame.setResizable(false);                                    // Prevents resizing frame

        /*
        * Game Loop
        * Updates the frame evey 100 milliseconds
        */
        long startTime = System.currentTimeMillis();
        while(true){
            long elapsedTime = System.currentTimeMillis() - startTime;
            if(elapsedTime > Constants.REFRESH_RATE){
                
                gridPanel.update();
                startTime = System.currentTimeMillis();                         // This function must remain at the end of this statement
            }
        }
    }

}