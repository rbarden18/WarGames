import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Font;
import javax.swing.SpringLayout;
 import javax.swing.*;
 import java.awt.Container;

public class Interface
{
    private static JButton[][] chessBoardSquares = new JButton[10][10];
    public static void main(String[] args) {
        Grid testG = new Grid();
        Hero c0 = new Hero();
        Hero c1 = new Hero();
        Health c2 = new Health();
        Ammo c3 = new Ammo();
        Obstacle c4 = new Obstacle();
        testG.addChar(c2);
        testG.addChar(c3);
        testG.addChar(c0);
        testG.addChar(c4);
        testG.addChar(c1);
        GameBoard.generateBoard(testG);
        System.out.println(testG.display());
    }
    
    private  static void displayGUI(Grid board){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment ();
        JFrame frame = new JFrame("WarGames");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //set up content pane
        Container contentPane = frame.getContentPane();
        SpringLayout layout = new SpringLayout();
        
        contentPane.setLayout(layout);
        
        //create and add components
        JTextArea label = new JTextArea(board.display(),3,20);
        //label.setEditable(false);
        JButton moveNorth= new JButton("moveNorth");
        JButton moveEast= new JButton("moveEast");
        JButton moveSouth= new JButton("moveSouth");
        JButton moveWest= new JButton("moveWest");
        JButton attack= new JButton("attack");
        contentPane.add(label);
        contentPane.add(moveNorth);
        contentPane.add(moveEast);
        contentPane.add(moveSouth);
        contentPane.add(moveWest);
        contentPane.add(attack);
        
        //set layout
        
        layout.putConstraint(SpringLayout.WEST, moveNorth, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.WEST, contentPane, 5, SpringLayout.WEST, label);
        layout.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.SOUTH, moveNorth);
        
        layout.putConstraint(SpringLayout.WEST, contentPane, 5, SpringLayout.WEST, moveNorth);
        layout.putConstraint(SpringLayout.WEST, moveEast, 5, SpringLayout.EAST, moveNorth);
        layout.putConstraint(SpringLayout.WEST, moveSouth, 5, SpringLayout.EAST, moveEast);
        layout.putConstraint(SpringLayout.WEST, moveWest, 5, SpringLayout.EAST, moveSouth);
        layout.putConstraint(SpringLayout.WEST, attack, 5, SpringLayout.EAST, moveWest);
        
        layout.putConstraint(SpringLayout.NORTH, moveNorth, 5, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, moveEast, 5, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, moveSouth, 5, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, moveWest, 5, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, attack, 5, SpringLayout.NORTH, contentPane);
        
        layout.putConstraint(SpringLayout.EAST, contentPane, 5, SpringLayout.EAST, label);
        //layout.putConstraint(SpringLayout.EAST, contentPane, 5, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.SOUTH, contentPane, 5, SpringLayout.SOUTH, label);
        
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                contentPane.add(b);
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((jj % 2 == 1 && ii % 2 == 1)
                        //) {
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[jj][ii] = b;
            }
        }
        
       Font [] fonts = ge.getAllFonts ();
       Font f = new Font("Dialog.Plain", Font.PLAIN, 1);
       f = fonts[16];
       contentPane.setFont(f.deriveFont(18.0f));
       label.setFont(f.deriveFont(18.0f));
        frame.pack();
        frame.setVisible(true);
       
    }
}