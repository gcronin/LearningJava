import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 * 
 * Visualization of randomly generated numbers.
 * 
 * @author TheUzo007
 *         http://theuzo007.wordpress.com
 * 
 * More on the blog: http://theuzo007.wordpress.com/2012/10/09/visual-random-numbers
 * 
 */

public class VisualRandomNumbers {

    // Numbers that will be generated from 0 to MAX_NUMBER. Including 0 and MAX_NUMBER.
    public static int MAX_NUMBER = 50;
    
    // Size of squares that will represents numbers.
    public static int SIZE_OF_SQUARE = 5;
    
    // Speed of squares. Should NOT be heigher then SIZE_OF_SQUARE!
    public static int SPEED_OF_SQUARE = 3;
    
    // How often should numbers be written on the axes of the coordinate system?
    public static int COORDINATE_SYSTEM_DENSITY = 5; // e.g. if 10 then will be 0 10 20 30 ...
    
    
    // Coordinate system margin from edges of a screen.
    public static final int COORDINATE_SYSTEM_MARGIN = 35;
    
    public static final Font FONT = new Font("monospaced", Font.PLAIN, 12);
    
    
    
    public static void main(String[] args) {
        VisualRandomNumbers program = new VisualRandomNumbers();
        program.startProgram();
    }
    
    private SettingsFrame startProgram(){
        return new SettingsFrame();
    }
    
    
    
    private class SettingsFrame {
        
        private JFrame settingsFrame;
        private JPanel settingsCanvas;
        private JLabel labelUrl;
        private JLabel labelDescription1;
        private JLabel labelDescription2;
        private JLabel labelMaxNumber;
        private JLabel labelSizeOfSquare;
        private JLabel labelSpeedOfSquare;
        private JLabel labelCoordinateSystemDensity;
        private JTextField textFieldMaxNumber;
        private JTextField textFieldSizeOfSquare;
        private JTextField textFieldSpeedOfSquare;
        private JTextField textFieldCoordinateSystemDensity;
        private JButton okButton;
        
        public SettingsFrame(){
            settingsFrame = new JFrame();
            settingsCanvas = new JPanel();
            labelUrl = new JLabel();
            labelDescription1 = new JLabel();
            labelDescription2 = new JLabel();
            labelMaxNumber = new JLabel();
            labelSizeOfSquare = new JLabel();
            labelSpeedOfSquare = new JLabel();
            labelCoordinateSystemDensity = new JLabel();
            textFieldMaxNumber = new JTextField();
            textFieldSizeOfSquare = new JTextField();
            textFieldSpeedOfSquare = new JTextField();
            textFieldCoordinateSystemDensity = new JTextField();
            okButton = new JButton();
            
            initComponents();
            setListeners();
        }
        
        private void initComponents(){
            labelUrl.setText("TheUzo007.wordpress.com");
            labelUrl.setForeground(Color.LIGHT_GRAY);
            
            labelDescription1.setText("This program randomly generates numbers, from 0 to max");
            labelDescription2.setText("random number that you set, and shows them on coordinate system.");
           
            labelMaxNumber.setText("Max random number");
            labelSizeOfSquare.setText("Size of square");
            labelSpeedOfSquare.setText("Speed of square (Should not be greater than size of square!)");
            labelCoordinateSystemDensity.setText("Coordinate system numbers density");
            
            textFieldMaxNumber.setPreferredSize(new Dimension(36, 20));
            textFieldMaxNumber.setText( Integer.toString(VisualRandomNumbers.MAX_NUMBER) );
            
            textFieldSizeOfSquare.setPreferredSize(new Dimension(36, 20));
            textFieldSizeOfSquare.setText( Integer.toString(VisualRandomNumbers.SIZE_OF_SQUARE) );
            
            textFieldSpeedOfSquare.setPreferredSize(new Dimension(36, 20));
            textFieldSpeedOfSquare.setText( Integer.toString(VisualRandomNumbers.SPEED_OF_SQUARE) );
            
            textFieldCoordinateSystemDensity.setPreferredSize(new Dimension(36, 20));
            textFieldCoordinateSystemDensity.setText( Integer.toString(VisualRandomNumbers.COORDINATE_SYSTEM_DENSITY) );
            
            okButton.setText("Start");
            
            GroupLayout layout = new GroupLayout(settingsCanvas);
            settingsCanvas.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelDescription1)
                        .addComponent(labelDescription2)
                        .addComponent(labelMaxNumber)
                        .addComponent(textFieldMaxNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelSizeOfSquare)
                        .addComponent(textFieldSizeOfSquare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelSpeedOfSquare)
                        .addComponent(textFieldSpeedOfSquare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelCoordinateSystemDensity)
                        .addComponent(textFieldCoordinateSystemDensity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(okButton)
                        .addComponent(labelUrl)))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelDescription1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labelDescription2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGap(18, 18, 18)
                    .addComponent(labelMaxNumber)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textFieldMaxNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(labelSizeOfSquare)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textFieldSizeOfSquare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(labelSpeedOfSquare)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textFieldSpeedOfSquare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(labelCoordinateSystemDensity)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textFieldCoordinateSystemDensity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(okButton)
                    .addGap(18, 18, 18)
                    .addComponent(labelUrl))
            );
            
            //settingsFrame.setResizable(false);
            
            settingsCanvas.setPreferredSize(new Dimension(430, 370));
            
            settingsFrame.setContentPane(settingsCanvas);
            settingsFrame.setTitle("Visual Random Numbers - Settings");
            settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close program when closing frame.
            settingsFrame.pack(); // Resize frame to the size of canvas.
            settingsFrame.setLocationRelativeTo(null); // Put frame to center of the screen.
            settingsFrame.setVisible(true);
        }
        
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
        }
        
    } 
    
    
    
    private abstract class Canvas extends JPanel {
        
        public final int CANVAS_WIDTH  = VisualRandomNumbers.MAX_NUMBER * VisualRandomNumbers.SIZE_OF_SQUARE + VisualRandomNumbers.COORDINATE_SYSTEM_MARGIN * 2;
        public final int CANVAS_HEIGHT = VisualRandomNumbers.MAX_NUMBER * VisualRandomNumbers.SIZE_OF_SQUARE + VisualRandomNumbers.COORDINATE_SYSTEM_MARGIN * 2;
        
        public Canvas(){
            this.setPreferredSize(new Dimension(this.CANVAS_WIDTH, this.CANVAS_HEIGHT));
        }
        
        @Override
        public void paintComponent(Graphics g)
        {
            Graphics2D g2d = (Graphics2D)g;
            super.paintComponent(g2d);
            DrawRandingNumbers(g2d);
        }
        
        public abstract void DrawRandingNumbers(Graphics2D g2d);
    }
    
    
    private class RenderingNumbers extends Canvas {
        
        // Use this to generate a random number.
        private Random random = new Random();
        
        // Array list of all rendomly generated numbers. <- moving
        private ArrayList<Integer[]> generatedNumbers = new ArrayList<Integer[]>();
        // Array list of all rendomly generated numbers. <- not moving, waiting for squares to come on top of this squares
        private ArrayList<Integer[]> generatedNumbersOnPlaceOnTop = new ArrayList<Integer[]>();
        // Array list of all rendomly generated numbers. <- not moving
        private ArrayList<Integer[]> generatedNumbersOnPlace = new ArrayList<Integer[]>();
        
        // When squares will be to the top of the coordinate system.
        private boolean isTopReached = false;
        
        /**
         * Time of one second in nanoseconds.
         * 1 second = 1 000 000 000 nanoseconds
         */
        final long secInNanosec = 1000000000L;

        /**
         * Time of one millisecond in nanoseconds.
         * 1 millisecond = 1 000 000 nanoseconds
         */
        final long milisecInNanosec = 1000000L;
        
        // App start time in nanoseconds.
        private long startTime;
        // Time of number rendering in 00:00 format.
        private String renderingTime;
        
        
        public void startRenderingNumbers(){
            Thread gameThread = new Thread() {
                @Override
                public void run(){
                    startTime = System.nanoTime();
                    
                    renderNumbers();
                }
            };
            gameThread.start();
        }
        
        
        private void renderNumbers(){
           /**
            * UPS - Updates per second
            */
            final int UPS = 60;
            /**
            * Pause between updates. It is in nanoseconds.
            */
            final long UPDATE_PERIOD = this.secInNanosec / UPS;
            
            // This variables are used for calculating the time that defines for how long we should put threat to sleep to meet the UPS.
            long beginTime, timeTaken, timeLeft;
        
            while(true)
            {
                beginTime = System.nanoTime();

                if(!isTopReached){
                    if(generatedNumbers.size() > 0){
                        // Only make number if ther's no number above the 0 on y coordinate.
                        if(!(generatedNumbers.get(generatedNumbers.size() - 1)[1] <= 0))
                            generateNewNumber();
                    }
                    else
                        generateNewNumber();
                }
                
                updateNumbers();
                
                // Repaint the screen.
                repaint();
                
                if(generatedNumbers.size() <= 0)
                    break;

                // Here we calculate the time that defines for how long we should put threat to sleep to meet the UPS.
                timeTaken = System.nanoTime() - beginTime;
                timeLeft = (UPDATE_PERIOD - timeTaken) / this.milisecInNanosec; // In milliseconds
                // If the time is less than 10 milliseconds, then we will put thread to sleep for 10 millisecond so that some other thread can do some work.
                if (timeLeft < 10) 
                    timeLeft = 10; //set a minimum
                
                try {
                    //Provides the necessary delay and also yields control so that other thread can do work.
                    Thread.sleep(timeLeft);
                } catch (InterruptedException ex) { }
            }
        }

        private void generateNewNumber(){
            // Generate random number.
            int newNumber = random.nextInt(VisualRandomNumbers.MAX_NUMBER + 1); // +1 is because last number is excluded/never generated.
            newNumber *= VisualRandomNumbers.SIZE_OF_SQUARE;
            Integer[] newNumber_in_coordinateSystem = new Integer[2];
            newNumber_in_coordinateSystem[0] = newNumber + VisualRandomNumbers.COORDINATE_SYSTEM_MARGIN; // x coordinate. Add margin so that number will be drown corectly on coordinate system.
            if(generatedNumbers.size() > 0)
                newNumber_in_coordinateSystem[1] = generatedNumbers.get(generatedNumbers.size() - 1)[1] - VisualRandomNumbers.SIZE_OF_SQUARE; // y coordinate. We do that so that squares are one above another on y coordinate. 
            else
                newNumber_in_coordinateSystem[1] = 0; // y coordinate. only first number/square
            generatedNumbers.add(newNumber_in_coordinateSystem);
        }
        
        private void updateNumbers(){
            // Move squares numbers on y coordinate.
            for(int i=0; i < generatedNumbers.size(); i++){
                generatedNumbers.get(i)[1] += VisualRandomNumbers.SPEED_OF_SQUARE; // Move the square on y coordinate.
            }

            // Checks if any square is on the bottom of coordinate system.
            if(generatedNumbersOnPlaceOnTop.size() <= VisualRandomNumbers.MAX_NUMBER){ // Only check until bottom have empty spaces.
                for(int i=0; i < generatedNumbers.size(); i++){
                    Integer[] number = generatedNumbers.get(i);

                    int yCoordinateLine = this.CANVAS_HEIGHT - VisualRandomNumbers.COORDINATE_SYSTEM_MARGIN;
                    if( number[1].intValue() >= (yCoordinateLine - VisualRandomNumbers.SIZE_OF_SQUARE) )
                    {
                        // So that the square are directly on line.
                        number[1] = yCoordinateLine - VisualRandomNumbers.SIZE_OF_SQUARE;
                        
                        generatedNumbersOnPlaceOnTop.add(number);
                        generatedNumbers.remove(i);
                    }
                }
            }
            // Checks if any square is on another square.
            for(int i=0; i < generatedNumbers.size(); i++){
                Integer[] number = generatedNumbers.get(i);

                for(int j=0; j < generatedNumbersOnPlaceOnTop.size(); j++){
                    Integer[] numberOnPlaceOnTop = generatedNumbersOnPlaceOnTop.get(j);

                    if( number[0].intValue() == numberOnPlaceOnTop[0].intValue() && // x coordinate
                        number[1].intValue() >= numberOnPlaceOnTop[1].intValue() - VisualRandomNumbers.SIZE_OF_SQUARE )  // y coordinate
                    {
                        // So that the squre is on right y coordinate, (number)it can be lower so we need to set y coordinate to that.
                        number[1] = numberOnPlaceOnTop[1].intValue() - VisualRandomNumbers.SIZE_OF_SQUARE;
                        
                        generatedNumbersOnPlace.add(numberOnPlaceOnTop);
                        generatedNumbersOnPlaceOnTop.remove(j);
                        generatedNumbersOnPlaceOnTop.add(number);
                        generatedNumbers.remove(i);

                        if(number[1].intValue() <= VisualRandomNumbers.COORDINATE_SYSTEM_MARGIN)
                            isTopReached = true;
                        
                        // Square was placed so we can move to another square/number.
                        break;
                    }
                }
            }
        }
        
        
        @Override
        public void DrawRandingNumbers(Graphics2D g2d){
            g2d.setFont(VisualRandomNumbers.FONT);
            
            drawCoordinateSystem(g2d);
            drawSquaresNumbers(g2d);
            drawInfo(g2d);
            drawTime(g2d);
        }
        
        private void drawSquaresNumbers(Graphics2D g2d){
            // Draw squares already on place.
            for(int i=0; i < generatedNumbersOnPlace.size(); i++){
                g2d.setColor(Color.BLUE);
                Integer[] number = generatedNumbersOnPlace.get(i);
                g2d.fillRect(number[0] - VisualRandomNumbers.SIZE_OF_SQUARE / 2, number[1], VisualRandomNumbers.SIZE_OF_SQUARE, VisualRandomNumbers.SIZE_OF_SQUARE);
            }
            
            // Draw moving squares.
            for(int i=0; i < generatedNumbers.size(); i++){
                g2d.setColor(Color.BLACK);
                Integer[] number = generatedNumbers.get(i);
                g2d.fillRect(number[0] - VisualRandomNumbers.SIZE_OF_SQUARE / 2, number[1], VisualRandomNumbers.SIZE_OF_SQUARE, VisualRandomNumbers.SIZE_OF_SQUARE);
            }
            
            // Draw squares on place on top.
            for(int i=0; i < generatedNumbersOnPlaceOnTop.size(); i++){
                g2d.setColor(Color.RED);
                Integer[] number = generatedNumbersOnPlaceOnTop.get(i);
                g2d.fillRect(number[0] - VisualRandomNumbers.SIZE_OF_SQUARE / 2, number[1], VisualRandomNumbers.SIZE_OF_SQUARE, VisualRandomNumbers.SIZE_OF_SQUARE);
            }
        }

        private void drawCoordinateSystem(Graphics2D g2d){
            // y coordinate line
            int x1 = VisualRandomNumbers.COORDINATE_SYSTEM_MARGIN - 1 - VisualRandomNumbers.SIZE_OF_SQUARE / 2;
            int y1 = VisualRandomNumbers.COORDINATE_SYSTEM_MARGIN;
            int x2 = x1;
            int y2 = this.CANVAS_HEIGHT - VisualRandomNumbers.COORDINATE_SYSTEM_MARGIN;
            g2d.drawLine(x1, y1, x2, y2);
            // y coordinate numbers
            String space;
            for(int i=0; i <= VisualRandomNumbers.MAX_NUMBER; i += VisualRandomNumbers.COORDINATE_SYSTEM_DENSITY){
                int string_y2 = y2 - i * VisualRandomNumbers.SIZE_OF_SQUARE;
                int line_y2 = string_y2;
                
                if(i==0)
                    g2d.drawLine(x1 + VisualRandomNumbers.SIZE_OF_SQUARE / 2, line_y2, x1 - 2, line_y2);
                else
                    g2d.drawLine(x1, line_y2, x1 - 2, line_y2);
                
                if(i < 10)
                    space = "  ";
                else if(i < 100)
                    space = " ";
                else
                    space = "";
                g2d.drawString(space + i, x1 - 25, string_y2 + 4);
            }
            
            // x coordinate line
            x1 = VisualRandomNumbers.COORDINATE_SYSTEM_MARGIN;
            y1 = this.CANVAS_HEIGHT - VisualRandomNumbers.COORDINATE_SYSTEM_MARGIN;
            x2 = this.CANVAS_WIDTH  - VisualRandomNumbers.COORDINATE_SYSTEM_MARGIN;
            y2 = y1;
            g2d.drawLine(x1, y1, x2, y2);
            // x coordinate numbers
            int offset;
            for(int i=0; i <= VisualRandomNumbers.MAX_NUMBER; i += VisualRandomNumbers.COORDINATE_SYSTEM_DENSITY){
                int string_x1 = x1 + i * VisualRandomNumbers.SIZE_OF_SQUARE;
                int line_x1 = string_x1;
                
                g2d.drawLine(line_x1, y1, line_x1, y1 + 2);
                
                if(i >= 10 && i <= 99)
                    offset = 7;
                else if(i >= 100)
                    offset = 11;
                else
                    offset = 3;
                g2d.drawString("" + i, string_x1 - offset, y1 + 14);
            }
        }
        
        
        private void drawInfo(Graphics2D g2d){
            g2d.setColor(Color.GRAY);
            String info = "Red:"+generatedNumbersOnPlaceOnTop.size() + " Black:"+generatedNumbers.size() + " Blue:"+generatedNumbersOnPlace.size();
            g2d.drawString(info, 2, this.CANVAS_HEIGHT - 2);
        }
        
        private void drawTime(Graphics2D g2d){
            if(!isTopReached)
                this.renderingTime = formatTime(System.nanoTime() - this.startTime);
            g2d.setColor(Color.GRAY);
            g2d.drawString(this.renderingTime, this.CANVAS_WIDTH / 2 - 15, 12);
        }
        
        
       /**
        * Format given time into 00:00 format.
        * 
        * @param time Time that is in nanoseconds.
        * @return Time in 00:00 format.
        */
        private String formatTime(long time){
                // Given time in seconds.
                int sec = (int)(time / this.milisecInNanosec / 1000);

                // Given time in minutes and seconds.
                int min = sec / 60;
                sec = sec - (min * 60);

                String minString, secString;

                if(min <= 9)
                    minString = "0" + Integer.toString(min);
                else
                    minString = "" + Integer.toString(min);

                if(sec <= 9)
                    secString = "0" + Integer.toString(sec);
                else
                    secString = "" + Integer.toString(sec);

                return minString + ":" + secString;
        }
    }
    
}
