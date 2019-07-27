import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;



public class Snakeplay extends JFrame {

    //declaring all global varaibles
    
    //properties of the board, stored under int varaibles
    //number of tiles/marshmallows multiplied by size of tiles/marshmallows
    int width = 30 * 35; 
    int height = 30 * 35;
    //size of each tile/marshmallow
    int tile_size = 35;
    int tile_total = 900; 
    
    //varaible for speed of snake 
    int Snake_speed;
    
    //array for snake coordinates
    int[] Snake_x = new int[tile_total];
    int[] Snake_y = new int[tile_total];
    
    //varaible for snake property. To start, I will only give the snake a lenght of 3
    int Snake_size = 2;

    // varaibles for coordinates for coal-something that is going to get eaten by snake
    int Coal_x;
    int Coal_y;

    //varaibles for recording key pressed
    //snake will be travelling down at the start of game
    int key_pressed = KeyEvent.VK_DOWN;
    //record what key was pressed before
    
    
    // to determine if the game is running or not, boolean variable is set to true when game is running (vise-versa)
    boolean Game_running = true;
    
    
    public static void main (String[] args) {
    
    }
    public void setSpeed(int speed){
        Snake_speed=speed;
    }
  
    public Snakeplay(int speed, Color snakeheadcolor, Color snakebodycolor){
    //setting size of plaing area
    setSize(1050, 1050);
    //setting location of playing area
    setLocation(0, 0);
    //setting speed of snake
    Snake_speed = speed;
      

    //calling the playboard class to contruct the board and all other playing elements
    Playboard b = new Playboard(Snake_speed, snakeheadcolor,snakebodycolor);
    addKeyListener(b);
    add(b);
    setVisible(true);

    //calling timer class to perform a task repeatedly as we want to perform our snake animations by updating the components in the playboard class
    Timer t = new Timer(Snake_speed, b);
    //start the timer...
    t.start();
  }  


  public class Playboard extends JPanel implements KeyListener, ActionListener {
    //global varaibles
      int Snake_speed;
    
    Color snakecolor;
    Color snakebodycolor; 
    //method for storing snake speed into global variable
    public void setSpeed(int speed){
        Snake_speed=speed;
    }
    //method for storing snake head color into global variable
    public void setColor(Color snakeheadcolor){
        snakecolor = snakeheadcolor;
    }
    //method for storing snake body color into global variable
    public void setColor2(Color snakebodycolor2){
        snakebodycolor = snakebodycolor2; 
    }
    Playboard(int speed, Color snakeheadcolor, Color snakebodycolor2){
        //setting background color of playing field
        setBackground(Color.black);
        setSpeed(speed);
        setColor(snakeheadcolor);
        setColor2(snakebodycolor2);

        //setting the starting coordinates of the snake
        for(int i = 0; i < Snake_size; i++){
          Snake_y[i] = 140 - (i * 35);
          Snake_x[i] = 140;
        }

        //making random coordinates for the coal as we want  it to be in random places each time
        int c = (int) (Math.random() * Math.sqrt(tile_total) - 1);
        Coal_x = ((c * tile_size));

        c = (int) (Math.random() * Math.sqrt(tile_total) - 1);
        Coal_y = ((c * tile_size));
    }

    // paint Component is the method to be called for painting graphics as it provides framework for all graphics operations
    // method's argument is an instance of the Graphics class 
    public void paintComponent(Graphics g) {
        //custom color I created, somewhat like sky blue
        Color customColor = new Color(83,205,255);
        
        
        //Super class is used when we don't want to override the paintComponent method and don't want to add/make our own impplementations
        super.paintComponent(g);

        if (Game_running) {

        //drawing the snake using rectangles
        for (int i = 0; i < Snake_size; i++) {
            //drawing the snake, it will obviously depend on the snake size
            if (i == 0) { 
              
     
               g.setColor(snakecolor); // Snakes head should red to represent santa
            } else {
              g.setColor(snakebodycolor);} //rest of body should be blue to match theme
            //calling the fillRect method to create a rectangle/square shape with the given cordinates
            g.fillRect(Snake_x[i], Snake_y[i], tile_size, tile_size);
        }
        
        //drawing the coal using rectangle
        g.setColor(Color.white);
        //calling the fillRect method to create a rectangle/square shape with the given cordinates
        g.fillRect(Coal_x, Coal_y, tile_size, tile_size);        

        //drawing/displaying the score using drawString method
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Score: " + (Snake_size - 2), 550, 30);

        } else {
          Game_notrunning(g);
        }
    }

    public void actionPerformed(ActionEvent e) {
        //method for checking if snake is in contact with itself and if snake is outside wall
        Snakeaction();
        //method for checking if coal collided with snake
        Coaladjustment();
        //adjusting cordinates fo snake depending upon user actions
        Cordadjusment();
        //we call the repaint method for showing the animations and adjust new coordinates, this causes a repaint of the entire component
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        key_pressed = e.getKeyCode();
    }

    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

    public void Snakeaction(){
        //cheking if snake went outside boundaries
        for (int i=0; i < Snake_size; i++){
        if ( Snake_x[i] > width || Snake_y[i] > height || Snake_y[i] < 0 || Snake_x[i] < 0) {
             Game_running = false;
           }}

        //checking if snake collided with itslef
        for(int i = 1; i < Snake_x.length; i++){
          if (Snake_x[0] == Snake_x[i] && Snake_y[0] == Snake_y[i]){
              Game_running = false;
          }
        }

    }
    
    public void Coaladjustment(){
    //checking if snake has eaten coal
        if ((Snake_x[0] == Coal_x) && (Snake_y[0] == Coal_y)) {
          // increase snake size by one if the coal is eaten by the snake
          Snake_size++;
          // making new coordinates of the coal
          int c = (int) (Math.random() * Math.sqrt(tile_total) - 1);
          Coal_x = ((c * tile_size));

          c = (int) (Math.random() * Math.sqrt(tile_total) - 1);
          Coal_y = ((c * tile_size));
        }
    }

    
    public void Game_notrunning(Graphics g ) {
        
        if (Snake_size - 2 == 1){
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 25));
            g.drawString(("GAME OVER! You ate " + ("" + (Snake_size - 2)) + " marshmallow!"), width / 4 - 50, height / 2);
        g.drawString("Press space to restart",width / 4 + 20 , height / 2 + 30);}
        
        if (Snake_size - 2 != 1){
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 25));
            g.drawString(("GAME OVER! You ate " + ("" + (Snake_size - 2)) + " marshmallows!"), width / 4 - 50, height / 2);
        g.drawString("Press space to restart",width / 4 + 20 , height / 2 + 30);}

        //restart game if space is pressed
        if (key_pressed == KeyEvent.VK_SPACE){
          Game_running = true;
          key_pressed = KeyEvent.VK_DOWN;
          setVisible(false); 
          //will dispose the current frame while retaining the values I have entered in that frame
          //our application will not be closed, but screen will be cleared
          dispose(); 
          Snakeplay s = new Snakeplay(Snake_speed, snakecolor, snakebodycolor);
        }
    }

    public void Cordadjusment(){

        //moving the coordinates of the snake
        for (int i = Snake_size; i > 0; i--) {
          Snake_x[i] = Snake_x[(i - 1)];
          Snake_y[i] = Snake_y[(i - 1)];
        }

        //changing the coordinates of the snake, depeding on pressed key
        
        if (key_pressed == KeyEvent.VK_DOWN)
          Snake_y[0] += tile_size;
          
        else if (key_pressed == KeyEvent.VK_UP) 
          Snake_y[0] -= tile_size;
          
        else if (key_pressed == KeyEvent.VK_LEFT)
          Snake_x[0] -= tile_size;
          
        else if (key_pressed == KeyEvent.VK_RIGHT)
          Snake_x[0] += tile_size;
    }
  }      
}
