/**
 * This game is based on a classic snake game, but with a christmas twist!
 * Developer: Jasraj Dhanoa
 * Date: 1/14/2019
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import sun.audio.*;
import java.io.*;
import java.io.File;


public class Game extends JPanel implements ActionListener {
  //global variables
    
  CardLayout cdLayout = new CardLayout ();
  JLabel s_image,title,s2_image,s3_image; 
  AudioStream audios;
  int spd = 60;
  Color customColor = new Color(83,205,255);
  String c = ("Music.wav");
  Color color = Color.RED; 
  Color color2 = customColor; 
  JTextField username_f; 
  JPasswordField password_f; 

  
public static void main (String[] args){
    Game content = new Game();
    JFrame window = new JFrame("Santa Snake Game");
    window.setContentPane( content);
    window.setSize(1000,700);
    window.setLocation(100, 100);
    window.setVisible(true);
    }
//method for palying music
// file location is an argument as it will be needed to play the music
    public static void playMusic (String c)
{
   
    InputStream music;
    AudioStream audios;  
    try
   {
       
       music = new FileInputStream (new File(c));
       audios = new AudioStream (music);
       AudioPlayer.player.start(audios);
    }
   catch (Exception e)
    {
     System.out.println ("Error");   
    }
}
   

    
public Game (){
      //play music method is called and argument c is passed as c contains the location of the music
      playMusic (c);
      //apllying cd layout on top of panels to allow transitions
      setLayout (cdLayout);
      Login();
      Menu();
      Instructions();
      Settings();
      
    }
public void Login(){
     JPanel login_panel = new JPanel ();
     //border layout is applied to organize widgets
     login_panel.setLayout(new BorderLayout());
     add (login_panel);
     
     //methods are called to create various panels
     JPanel title_Panel = createTitlelPanel(); 
     JPanel left_Panel = createLeftlPanel();
     JPanel right_Panel = createRightlPanel();
     JPanel center_Panel = createCenterlPanel();
     JPanel bottom_Panel = createBottomlPanel();
     
     //returned panels are added to the main panel
     login_panel.add(title_Panel, java.awt.BorderLayout.PAGE_START);
     login_panel.add(left_Panel, java.awt.BorderLayout.LINE_START);
     login_panel.add(right_Panel, java.awt.BorderLayout.LINE_END);
     login_panel.add(center_Panel, java.awt.BorderLayout.CENTER);
     login_panel.add(bottom_Panel, java.awt.BorderLayout.PAGE_END);
    
     
}
public void Menu (){
     JPanel main_panel = new JPanel ();
     //border layout is applied to organize widgets
     main_panel.setLayout(new BorderLayout());
     add ("1", main_panel);
     
     //methods are called to create various panels
     JPanel title_Panel = createTitlePanel(); 
     JPanel left_Panel = createLeftPanel();
     JPanel right_Panel = createRightPanel();
     JPanel center_Panel = createCenterPanel();
     JPanel bottom_Panel = createBottomPanel();
     
     //returned panels are added to the main panel
     main_panel.add(title_Panel, java.awt.BorderLayout.PAGE_START);
     main_panel.add(left_Panel, java.awt.BorderLayout.LINE_START);
     main_panel.add(right_Panel, java.awt.BorderLayout.LINE_END);
     main_panel.add(center_Panel, java.awt.BorderLayout.CENTER);
     main_panel.add(bottom_Panel, java.awt.BorderLayout.PAGE_END);
     
}
public void Instructions (){
    JPanel mainintruction_panel = new JPanel ();
    //border layout is applied to organize widgets
    mainintruction_panel.setLayout(new BorderLayout ());
    add("3", mainintruction_panel);
    
    //methods are called to create various panels
    JPanel title2_Panel = createTitle2Panel ();
    JPanel center2_Panel = createCenter2Panel ();
    JPanel bottom2_Panel = createBottom2Panel ();
    JPanel left2_Panel = createLeft2Panel ();
    JPanel right2_Panel = createRight2Panel ();
    
    //returned panels are added to the main panel
    mainintruction_panel.add(title2_Panel, java.awt.BorderLayout.PAGE_START);
    mainintruction_panel.add(center2_Panel, java.awt.BorderLayout.CENTER);
    mainintruction_panel.add(bottom2_Panel, java.awt.BorderLayout.PAGE_END);
    mainintruction_panel.add(left2_Panel, java.awt.BorderLayout.LINE_START);
    mainintruction_panel.add(right2_Panel, java.awt.BorderLayout.LINE_END);
        
}
public void Settings (){
 JPanel mainsetting_panel = new JPanel ();
 //border layout is applied to organize widgets
 mainsetting_panel.setLayout (new BorderLayout ());
 add ("4", mainsetting_panel);
 
 //methods are called to create various panels
 JPanel title3_Panel = createTitle3Panel();
 JPanel center3_Panel = createCenter3Panel ();
 JPanel bottom3_Panel = createBottom3Panel ();
 JPanel left3_Panel = createLeft3Panel ();
 JPanel right3_Panel = createRight3Panel ();
 
 //returned panels are added to the main panel
 mainsetting_panel.add(title3_Panel, java.awt.BorderLayout.PAGE_START);
 mainsetting_panel.add(left3_Panel, java.awt.BorderLayout.LINE_START);
 mainsetting_panel.add(center3_Panel, java.awt.BorderLayout.CENTER);
 mainsetting_panel.add(right3_Panel, java.awt.BorderLayout.LINE_END);
 mainsetting_panel.add(bottom3_Panel, java.awt.BorderLayout.PAGE_END);
}

public void actionPerformed (ActionEvent e){
   // this group of if-else statements allows player/user to control the speed of the snake
   if (e.getActionCommand().equals ("Normal")) {
      
      spd = 60;
      
    } 
    else if (e.getActionCommand().equals ("Low")) {
      
      spd = 100;
      
    } 
    else if (e.getActionCommand().equals ("High")) {
      
      spd = 30;
      
    } 
   // this group of if-else statements allows player/user to control the head colour of the snake
   if (e.getActionCommand().equals ("red")) {
      
      color = Color.RED;
      
    } 
   else if (e.getActionCommand().equals ("green")) {
      
      color = Color.GREEN;
      
    } 
   else if (e.getActionCommand().equals ("pink")) {
      
      color = Color.PINK;
            
    } 
    // this group of if-else statements allows player/user to control the body colour of the snake
   if (e.getActionCommand().equals ("blue")) {
      
      color2 = customColor;
      
      
    } 
   else if (e.getActionCommand().equals ("green2")) {
      
      color2 = Color.GREEN;
      
      
    } 
   else if (e.getActionCommand().equals ("pink2")) {
      
      color2 = Color.PINK;
      
            
    } 
  // when play button is pressed, the snakeplay class is called
  // some arguments are passed as they will control the properties of the snake
  // this group of if-else statements allows user to transition between various panels/screens
   if (e.getActionCommand().equals ("2")) {
   
    Snakeplay s = new Snakeplay(spd, color, color2);
        
    }
  else if (e.getActionCommand().equals ("3")) {
  
      cdLayout.show (this, "3");
  
    }
  else if (e.getActionCommand().equals ("4")) {
   
      cdLayout.show (this, "4");
      
    }
    else if (e.getActionCommand().equals ("5")) {
     
       cdLayout.show (this, "1");
    
    }

  //recieving the text entered in the login page
    String text_username = username_f.getText();
    String text_password = password_f.getText();
    // if everything in login page is entered correctly, user will be taken to main menu
    if (e.getActionCommand().equals ("login") && text_username.equals("comsci") && text_password.equals("jasraj")){
  
       cdLayout.show (this, "1");
       
}
  else if (e.getActionCommand().equals ("login")){
      
      JOptionPane.showMessageDialog(null,"Password and/or Username was incorrect");
    
    }
} 

protected static ImageIcon createImageIcon (String path){
      java.net.URL imgURL = Game.class.getResource( path);
        if (imgURL != null){
          return new ImageIcon (imgURL);
        } else {
          System.err.println( "Couldn't find file: " + path);
          return null;
}
}
//method will create title panel for login page
public JPanel createTitlelPanel(){
    JPanel titlepanel= new JPanel();
    titlepanel.setBackground(Color.black);
    JLabel mssg = new JLabel("LOGIN PAGE");
    mssg.setFont (new Font ("Jokerman", Font.BOLD, 40));
    mssg.setForeground(Color.red);
    titlepanel.add(mssg);
    
    return titlepanel;
}
//method will create left panel for login page   
public JPanel createLeftlPanel(){
    JPanel leftPanel = new JPanel();
    leftPanel.setBackground(customColor);
    return leftPanel;
}
//method will create right panel for login page  
public JPanel createRightlPanel(){
    JPanel rightPanel = new JPanel ();
    rightPanel.setBackground (Color.red);
    
    //adding a gif to the page
    ImageIcon ii = new ImageIcon(this.getClass().getResource("canta2.png"));
    s3_image = new JLabel ();
    s3_image.setIcon(ii);
    rightPanel.add(s3_image);
    return rightPanel;
}
//method will create center panel for login page  
public JPanel createCenterlPanel(){

    JPanel rightPanel = new JPanel ();
    rightPanel.setBackground(customColor);
    
    JLabel intruct = new JLabel("PLEASE ENTER ALL CORRECT INFORMATION TO CONTINUE");
    intruct.setFont (new Font ("Arial", Font.BOLD, 15));
    
    JPanel center = new JPanel();
    center.setBackground(customColor);
    
    //gird layout is applied to organize the jlabel's
    center.setLayout (new GridLayout(5,1));
    
    JLabel username = new JLabel("Username:   ");
    username.setFont (new Font ("Times New Roman", Font.BOLD, 25));
    
    JLabel password = new JLabel("Password:   ");
    password.setFont (new Font ("Times New Roman", Font.BOLD, 25));
    
    JLabel blank = new JLabel("        ");
    blank.setFont (new Font ("Times New Roman", Font.BOLD, 25));
    
    JLabel blank2 = new JLabel("        ");
    blank2.setFont (new Font ("Times New Roman", Font.BOLD, 25));
    
    JLabel blank3 = new JLabel("        ");
    blank3.setFont (new Font ("Times New Roman", Font.BOLD, 25));
    
    center.add(blank3);
    center.add(username);
    center.add(blank);
    center.add(blank2);
    center.add(password);
    
    JPanel right = new JPanel();
    //gird layout is applied to organize the widgets
    right.setLayout (new GridLayout(5,1));
    right.setBackground(customColor);
    
    username_f = new JTextField(15);
    password_f = new JPasswordField(15);
    
    JLabel blank4 = new JLabel("        ");
    blank4.setFont (new Font ("Times New Roman", Font.BOLD, 25));
    blank4.setBackground(customColor);
    blank4.setForeground(customColor);
    
    JLabel blank5 = new JLabel("        ");
    blank5.setFont (new Font ("Times New Roman", Font.BOLD, 25));
    blank5.setBackground(customColor);
    
    JLabel blank6 = new JLabel("        ");
    blank6.setFont (new Font ("Times New Roman", Font.BOLD, 25));
    blank6.setBackground(customColor);
    
    right.add(blank4);
    right.add(username_f);
    right.add(blank5);
    right.add(blank6);
    right.add(password_f);
    
    //border layout is used on this panel to organize certain widgets
    rightPanel.add(intruct, java.awt.BorderLayout.PAGE_START);
    rightPanel.add(center, java.awt.BorderLayout.CENTER);
    rightPanel.add(right, java.awt.BorderLayout.LINE_END);
    
    
       
    return rightPanel;

}
//method will create bottom panel for login page 
public JPanel createBottomlPanel(){
    JPanel buttomPanel= new JPanel();
    buttomPanel.setBackground(Color.black);
    JButton login_button = new JButton ("");
    login_button.setBorderPainted(false);
    login_button.setContentAreaFilled(false);
    login_button.setIcon(new ImageIcon("login.png"));
    login_button.setActionCommand ("login");
    login_button.addActionListener (this);
    buttomPanel.add(login_button);
    
    buttomPanel.add(login_button);
   return buttomPanel;
    }
//method will create title panel for login page
    public JPanel createlTitlePanel(){
    JPanel titlepanel= new JPanel();
    JLabel mssg = new JLabel("To Play, You Must LOGIN ");
    mssg.setFont (new Font ("Jokerman", Font.BOLD, 40));
    mssg.setForeground(customColor);
    titlepanel.add(mssg);
    
    return titlepanel;
}
//method will create left panel for main menu 
public JPanel createLeftPanel(){
   
    JPanel leftPanel = new JPanel();
    leftPanel.setBackground(Color.red);
    return leftPanel;
}
//method will create center panel for main menu
public JPanel createCenterPanel(){
     
    JPanel centerPanel= new JPanel();
    centerPanel.setBackground(customColor);
    
    ImageIcon ii = new ImageIcon(this.getClass().getResource("santagif.gif"));
    s_image = new JLabel ();
    s_image.setIcon(ii);
    centerPanel.add(s_image);
    
    return centerPanel;
}
//method will create right panel for main menu
public JPanel createRightPanel(){
    
    JPanel rightPanel= new JPanel();
    rightPanel.setBackground(Color.red);
    return rightPanel;
}
//method will create bottom panel for main menu
public JPanel createBottomPanel(){
    
     JPanel buttomPanel= new JPanel();
     buttomPanel.setBackground(Color.black);

     JButton menubar1 = new JButton ("");
     //making the button an image
     menubar1.setBorderPainted(false);
     menubar1.setContentAreaFilled(false);
     menubar1.setIcon(new ImageIcon("BP3.png"));
     menubar1.setActionCommand ("2");
     menubar1.addActionListener (this);
      
     JButton menubar2 = new JButton ("");
     //making the button an image
     menubar2.setBorderPainted(false);
     menubar2.setContentAreaFilled(false);
     menubar2.setIcon(new ImageIcon("BP1.png"));
     menubar2.setActionCommand ("3");
     menubar2.addActionListener (this);
      
     JButton menubar3 = new JButton ("");
     //making the button an image
     menubar3.setBorderPainted(false);
     menubar3.setContentAreaFilled(false);
     menubar3.setIcon(new ImageIcon("BP4.png"));
     menubar3.setActionCommand ("4");
     menubar3.addActionListener (this);

     buttomPanel.add(menubar1);
     buttomPanel.add(menubar2);
     buttomPanel.add(menubar3);

     return buttomPanel;
}
//method will create title panel for main menu
public JPanel createTitlePanel(){
    Color customColor = new Color(83,205,255);
    
    JPanel titlePanel=new JPanel();
    titlePanel.setBackground(Color.black);
    
    JLabel title = new JLabel ("       Welcome to");
    JLabel title2 = new JLabel (" SANTA SNAKE GAME");
    title2.setFont (new Font ("Jokerman", Font.BOLD, 40));
    title.setFont (new Font ("Times New Roman", Font.BOLD, 40));
    title.setForeground(customColor);
    title2.setForeground(Color.red);
    titlePanel.add(title);
    titlePanel.add(title2);
     
    return titlePanel;
}
//method will create title panel for instruction page
public JPanel createTitle2Panel(){
    JPanel title2Panel=new JPanel();
    title2Panel.setBackground(Color.black);
    
    JLabel title2 = new JLabel ("Ins");
    JLabel title2_1 = new JLabel ("tru");
    JLabel title2_2 = new JLabel ("cti");
    JLabel title2_3 = new JLabel ("ons");
    title2.setFont (new Font ("Jokerman", Font.BOLD, 40));
    title2_1.setFont (new Font ("Jokerman", Font.BOLD, 40));
    title2_2.setFont (new Font ("Jokerman", Font.BOLD, 40));
    title2_3.setFont (new Font ("Jokerman", Font.BOLD, 40));
    title2.setForeground(customColor);
    title2_1.setForeground(Color.red);
    title2_2.setForeground(customColor);
    title2_3.setForeground(Color.red);
    title2Panel.add(title2);
    title2Panel.add(title2_1);
    title2Panel.add(title2_2);
    title2Panel.add(title2_3);
     
    return title2Panel;
}
//method will create center panel for instruction page
public JPanel createCenter2Panel(){
    GridLayout intructionsLayout = new GridLayout(4,1);
    JPanel center2Panel = new JPanel ();
    center2Panel.setLayout (intructionsLayout);
    center2Panel.setBackground (customColor);
    
    JLabel instruction1_Label = new JLabel ("1. Use arrow keys on the keyboard to control your snake");
    instruction1_Label.setForeground(Color.black);
    instruction1_Label.setHorizontalAlignment(JLabel.LEFT);
    instruction1_Label.setFont (new Font ("Arial", Font.BOLD, 20));
    
    JLabel intruction2_Label = new JLabel ("2. To gain points, help santa collect the marshmallows");
    intruction2_Label.setForeground(Color.black);
    intruction2_Label.setFont (new Font ("Arial", Font.BOLD, 20));
    intruction2_Label.setHorizontalAlignment(JLabel.LEFT);
    
    JLabel intruction3_Label = new JLabel ("3. Don't run into the wall or yourself. YOU WILL DIE !!!");
    intruction3_Label.setForeground(Color.black);
    intruction3_Label.setFont (new Font ("Arial", Font.BOLD, 20));
    intruction3_Label.setHorizontalAlignment(JLabel.LEFT);
    
    JLabel intruction4_Label = new JLabel ("4. You can't travel through yourself");
    intruction4_Label.setForeground(Color.black);
    intruction4_Label.setFont (new Font ("Arial", Font.BOLD, 20));
    intruction4_Label.setHorizontalAlignment(JLabel.LEFT);
    
    center2Panel.add(instruction1_Label);
    center2Panel.add(intruction2_Label);
    center2Panel.add(intruction3_Label);
    center2Panel.add(intruction4_Label);
    
    return center2Panel;
}
//method will create bottom panel for instruction page
public JPanel createBottom2Panel(){
    JPanel bottom2Panel = new JPanel ();
    bottom2Panel.setBackground (Color.black);
    
    //button is added to go back to main menu
    JButton back1_Button = new JButton ("");
    back1_Button.setBorderPainted(false);
    back1_Button.setContentAreaFilled(false);
    back1_Button.setIcon(new ImageIcon("BP5.png"));
    back1_Button.setActionCommand ("5");
    back1_Button.addActionListener (this);
    
    
    bottom2Panel.add (back1_Button);
    
    return bottom2Panel;
    
}
//method will create left panel for instruction page
public JPanel createLeft2Panel (){
    JPanel left2Panel = new JPanel ();
    left2Panel.setBackground (customColor);
    
    return left2Panel;
    
}
//method will create right panel for instruction page
public JPanel createRight2Panel (){
 JPanel right2Panel = new JPanel ();
 right2Panel.setBackground (Color.red);
 //gif is added to the panel
 ImageIcon ii = new ImageIcon(this.getClass().getResource("santa2.gif"));
 s2_image = new JLabel ();
 s2_image.setIcon(ii);
 right2Panel.add(s2_image);
 
 
 return right2Panel;
   
}
//method will create title panel for settings page
public JPanel createTitle3Panel(){
 JPanel title3Panel=new JPanel();
    title3Panel.setBackground(Color.black);
    
    JLabel title3 = new JLabel ("Sett");
    JLabel title3_2 = new JLabel ("ings");
    title3.setFont (new Font ("Jokerman", Font.BOLD, 40));
    title3_2.setFont (new Font ("Jokerman", Font.BOLD, 40));
    title3.setForeground(customColor);
    title3_2.setForeground(Color.red);
    title3Panel.add(title3);
    title3Panel.add(title3_2);
     
    return title3Panel;
 
}
//method will create center panel for settings page
public JPanel createCenter3Panel(){
    GridLayout settingLayout = new GridLayout(3,1);
    JPanel center3Panel = new JPanel ();
    center3Panel.setLayout (settingLayout);
    center3Panel.setBackground (Color.red);
        
    JPanel snake_speed = new JPanel();
    snake_speed.setBackground (Color.red);
    snake_speed.setLayout (new BorderLayout ());
    JLabel snake_speed_label = new JLabel ("Snake Speed:");
    snake_speed_label.setFont (new Font ("Arial", Font.BOLD, 20));
    snake_speed_label.setForeground(Color.white);
    
    //radio buttons will allow user to customize the game according to personal preference 
    JRadioButton low = new JRadioButton("LOW");
    low.setBackground(customColor);
    low.addActionListener (this);
    low.setActionCommand ("Low");
    
    JRadioButton medium = new JRadioButton("NORMAL");
    medium.setBackground(customColor);
    medium.addActionListener (this);
    medium.setActionCommand ("Normal");
    
    JRadioButton high = new JRadioButton ("HIGH");
    high.setBackground(customColor);
    high.addActionListener (this);
    high.setActionCommand ("High");
    
    
    //radio buttons are added to button group
    ButtonGroup group = new ButtonGroup();
    group.add(low);
    group.add(medium);
    group.add(high);
    
    
    JPanel speedbuttons = new JPanel();
    speedbuttons.setBackground (customColor);
    speedbuttons.setLayout (settingLayout);
    speedbuttons.add(low);
    speedbuttons.add(medium);
    speedbuttons.add(high);
    
    snake_speed.add(snake_speed_label, java.awt.BorderLayout.PAGE_START);
    
    snake_speed.add(speedbuttons, java.awt.BorderLayout.CENTER);
    
    
    JPanel color_1 = new JPanel();
    color_1.setBackground (Color.red);
    color_1.setLayout (new BorderLayout ());
    JLabel color_1_label = new JLabel ("Snake Head Color:");
    color_1_label.setFont (new Font ("Arial", Font.BOLD, 20));
    color_1_label.setForeground(Color.white);
    
    //radio buttons are added for user customization
    JRadioButton red = new JRadioButton("RED");
    red.setBackground(customColor);
    red.addActionListener (this);
    red.setActionCommand ("red");
    
    JRadioButton yellow = new JRadioButton ("GREEN");
    yellow.setBackground(customColor);
    yellow.addActionListener (this);
    yellow.setActionCommand ("green");
        
    JRadioButton green = new JRadioButton ("PINK");
    green.setBackground(customColor);
    green.addActionListener (this);
    green.setActionCommand ("pink");
    
    //radio buttons are added to a button group
    ButtonGroup group2 = new ButtonGroup();
    group2.add(red);
    group2.add(yellow);
    group2.add(green);
        
    JPanel color1buttons = new JPanel();
    color1buttons.setBackground (customColor);
    color1buttons.setLayout (settingLayout);
    color1buttons.add(red);
    color1buttons.add(green);
    color1buttons.add(yellow);
    
    color_1.add(color_1_label, java.awt.BorderLayout.PAGE_START);
    color_1.add(color1buttons, java.awt.BorderLayout.CENTER);
    
    
    JPanel color_2 = new JPanel();
    color_2.setBackground (Color.red);
    color_2.setLayout (new BorderLayout ());
    JLabel color_2_label = new JLabel ("Snake Body Color:");
    color_2_label.setFont (new Font ("Arial", Font.BOLD, 20));
    color_2_label.setForeground(Color.white);
    
    //radio buttons are added for user customization
    JRadioButton red2 = new JRadioButton("BLUE");
    red2.setBackground(customColor);
    red2.addActionListener (this);
    red2.setActionCommand ("blue");
    
    
    JRadioButton blue2 = new JRadioButton ("GREEN");
    blue2.setBackground(customColor);
    blue2.addActionListener (this);
    blue2.setActionCommand ("green2");
    
    JRadioButton pink2 = new JRadioButton ("PINK");
    pink2.setBackground(customColor);
    pink2.addActionListener (this);
    pink2.setActionCommand ("pink2");
    
    //radio buttons are added to a button group
    ButtonGroup group3 = new ButtonGroup();
    group3.add(red2);
    group3.add(blue2);
    group3.add(pink2);
        
    JPanel color2buttons = new JPanel();
    color2buttons.setBackground (customColor);
    color2buttons.setLayout (settingLayout);
    color2buttons.add(red2);
    color2buttons.add(blue2);
    color2buttons.add(pink2);
    
    color_2.add(color_2_label, java.awt.BorderLayout.PAGE_START);
    color_2.add(color2buttons, java.awt.BorderLayout.CENTER);
    
    center3Panel.add(snake_speed);
    center3Panel.add(color_1);
    center3Panel.add(color_2);
    
    return center3Panel;

}
//method is to create right panel for settings page
public JPanel createRight3Panel (){
 JPanel right3Panel = new JPanel ();
 right3Panel.setBackground (Color.red);
 
 ImageIcon ii = new ImageIcon(this.getClass().getResource("santa3.gif"));
 s3_image = new JLabel ();
 s3_image.setIcon(ii);
 right3Panel.add(s3_image);
 
 
 return right3Panel;
   
}
//method is to create left panel for settings page
public JPanel createLeft3Panel (){
 JPanel Left3Panel = new JPanel ();
 
 JLabel blank = new JLabel ("         ");
 blank.setForeground(Color.red);
 Left3Panel.add(blank);
 Left3Panel.setBackground (Color.red);

 return Left3Panel;
   
}
//method is to create bottom panel for settings page
public JPanel createBottom3Panel(){
    JPanel bottom3Panel = new JPanel ();
    bottom3Panel.setBackground (Color.black);
    
    //image is used for the button
    JButton back1_Button = new JButton ("");
    back1_Button.setBorderPainted(false);
    back1_Button.setContentAreaFilled(false);
    back1_Button.setIcon(new ImageIcon("BP5.png"));
    back1_Button.setActionCommand ("5");
    back1_Button.addActionListener (this);
    
    bottom3Panel.add (back1_Button);
    
    return bottom3Panel;
    
}
}
    




    
   

        
      
      
      
  
    
 