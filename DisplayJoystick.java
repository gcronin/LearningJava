import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class DisplayJoystick {


    // kind of like global variables
    public static int X_VALUE = 0;
    public static int Y_VALUE = 0;


    public static void main(String[] args) {
        DisplayJoystick program = new DisplayJoystick();
        program.startProgram();
    }

    // I think that this is just a wrapper that displays
    private SettingsFrame startProgram(){
        return new SettingsFrame();
    }

    private class SettingsFrame {
        
        // these are variables... sets the type
        private JFrame settingsFrame;
        private JPanel settingsCanvas;
        private JLabel labelUrl;
        private JTextField textFieldXValue;
        private JTextField textFieldYValue;
        private JButton okButton;

        //this is the definition of the class        
        public SettingsFrame(){
            
            // why can't this be combined with previous definitions
            settingsFrame = new JFrame();
            
            // by default uses flow manager
            settingsCanvas = new JPanel();
            labelUrl = new JLabel();
            textFieldXValue = new JTextField();
            textFieldYValue = new JTextField();
            okButton = new JButton();
            
            initComponents();
            //setListeners();
        }
        

        // this is a method that belongs to the class SettingsFrame.
        private void initComponents(){
            labelUrl.setText("LabelURL");
            labelUrl.setForeground(Color.LIGHT_GRAY);
            
            // Sets the size of the text box (x, y widths), and puts the value of X_Value in box
            textFieldXValue.setPreferredSize(new Dimension(50, 50));
            textFieldXValue.setText( Integer.toString(DisplayJoystick.X_VALUE) );
            
            textFieldYValue.setPreferredSize(new Dimension(36, 20));
            textFieldYValue.setText( Integer.toString(DisplayJoystick.Y_VALUE) );
            
            okButton.setText("Start");
            
            GroupLayout layout = new GroupLayout(settingsCanvas);
            settingsCanvas.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        //.addComponent(labelDescription1)
                        //.addComponent(labelDescription2)
                        //.addComponent(labelMaxNumber)
                        //.addComponent(textFieldMaxNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        //.addComponent(labelSizeOfSquare)
                        .addComponent(textFieldXValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        //.addComponent(labelSpeedOfSquare)
                        .addComponent(textFieldYValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        //.addComponent(labelCoordinateSystemDensity)
                        //.addComponent(textFieldCoordinateSystemDensity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(okButton)
                        .addComponent(labelUrl)))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    //.addComponent(labelDescription1)
                    //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    //.addComponent(labelDescription2)
                    //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    //.addGap(18, 18, 18)
                    //.addComponent(labelMaxNumber)
                    //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    //.addComponent(textFieldMaxNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    //.addGap(18, 18, 18)
                    //.addComponent(labelSizeOfSquare)
                    //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textFieldXValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    //.addComponent(labelSpeedOfSquare)
                    //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textFieldYValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    //.addComponent(labelCoordinateSystemDensity)
                    //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    //.addComponent(textFieldCoordinateSystemDensity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    //.addGap(18, 18, 18)
                    .addComponent(okButton)
                    .addGap(18, 18, 18)
                    .addComponent(labelUrl))
            );
            
            //settingsFrame.setResizable(false);
            
            settingsCanvas.setPreferredSize(new Dimension(430, 370));
            
            settingsFrame.setContentPane(settingsCanvas);
            settingsFrame.setTitle("Title for Settings Frame");
            settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close program when closing frame.
            settingsFrame.pack(); // Resize frame to the size of canvas.
            settingsFrame.setLocationRelativeTo(null); // Put frame to center of the screen.
            settingsFrame.setVisible(true);
        }
        /*
        private void setListeners(){
            okButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    // Close settings frame.
                    settingsFrame.dispose();
                    
                    VisualRandomNumbers.MAX_NUMBER = Integer.parseInt( textFieldMaxNumber.getText() );
                    VisualRandomNumbers.SIZE_OF_SQUARE = Integer.parseInt( textFieldSizeOfSquare.getText() );
                    VisualRandomNumbers.SPEED_OF_SQUARE = Integer.parseInt( textFieldSpeedOfSquare.getText() );
                    VisualRandomNumbers.COORDINATE_SYSTEM_DENSITY = Integer.parseInt( textFieldCoordinateSystemDensity.getText() );
                    
                    // Open app frame.
                    openAppFrame();
                }
            });
            
            labelUrl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    try {
                        Desktop desktop = Desktop.getDesktop();
                        URI uri = new URI("http://theuzo007.wordpress.com/2012/10/09/visual-random-numbers/");
                        desktop.browse( uri );
                    } catch ( Exception e ) {}
                }
                
                @Override
                public void mouseEntered(MouseEvent e) { 
                    settingsCanvas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                
                @Override
                public void mouseExited(MouseEvent e) { 
                    settingsCanvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            });
        }
        
        private void openAppFrame(){
            RenderingNumbers appLogic = new RenderingNumbers();

            JFrame frame = new JFrame();
            frame.setTitle("Visual Random Numbers");
            //frame.setResizable(false);
            frame.setContentPane(appLogic);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close program when closing frame.
            frame.pack(); // Resize frame to the size of canvas.
            frame.setLocationRelativeTo(null); // Put frame to center of the screen.
            frame.setVisible(true);

            appLogic.startRenderingNumbers();
        } */
        
    }





}