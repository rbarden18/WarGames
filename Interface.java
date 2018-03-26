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
    
    
}
