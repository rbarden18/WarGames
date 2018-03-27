import java.awt.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
//https://stackoverflow.com/questions/21077322/create-a-chess-board-with-jpanel
//https://stackoverflow.com/questions/18686199/fill-unicode-characters-in-labels
//https://stackoverflow.com/questions/17511789/button-actionlistener
public class GameBoard{
    
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private static JButton[][] chessBoardSquares = new JButton[10][10];
    private static JPanel chessBoard;
    
    //private static JPanel selection;
    
    
    private final JLabel message = new JLabel("Make your move, Player 1.");
    
    private static int roundNumber =1;
    private static int playerTurn =0;        
    private static  JLabel roundDisplay = new JLabel("Round "+roundNumber+":"); 
    private static  JLabel playerTurnDisplay = new JLabel("Player "+(playerTurn+1)+"'s turn"); 
    
    private JLabel targetInstructions = new JLabel ("Select who to Target: ");
    private static int targetNumber = 0;
    private JLabel targetDisplay = new JLabel("Target: Player " + targetNumber);
    
    private static ArrayList<Hero> turnOrder = new ArrayList<Hero>();

    GameBoard(Grid board) {
        initializeGui(board);
    }

    public final void initializeGui(Grid board) {
        addHeros(board);
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        
        //create toolbar buttons
        JButton moveNorth = new JButton("moveNorth");
        JButton moveEast = new JButton("moveEast");
        JButton moveSouth = new JButton("moveSouth");
        JButton moveWest = new JButton("moveWest");
        JButton attack = new JButton("Attack");
        tools.add(moveNorth); 
        //add toolbar buttons
        tools.add(moveEast); 
        tools.add(moveSouth); 
        tools.add(moveWest); 
        tools.addSeparator();
        tools.add(attack); 
        tools.addSeparator();
        tools.add(roundDisplay);
        tools.addSeparator();
        tools.add(playerTurnDisplay);
        
        
        //set up turn counters
        JToolBar turns = new JToolBar();
        turns.setFloatable(false);
        gui.add(turns, BorderLayout.SOUTH);
        
        turns.addSeparator();
        turns.add(message);
        
        
        //set up targeting system
        JRadioButton playerOne = new JRadioButton("Player 1");
        JRadioButton playerTwo = new JRadioButton ("Player 2");
        JRadioButton playerThree = new JRadioButton ("Player 3");
        JRadioButton playerFour = new JRadioButton ("Player 4");
        
        //create Button group and assign Radio buttons to it
        ButtonGroup selectGroup = new ButtonGroup();
        selectGroup.add(playerOne);
        selectGroup.add(playerTwo);
        selectGroup.add(playerThree);
        selectGroup.add(playerFour);
        
        //create a new toolbar
        JToolBar selection = new JToolBar(1);//creates a vertical toolbar
        selection.setFloatable(false);
        
        //add elements to toolbar
        selection.addSeparator();
        selection.add(targetInstructions);
        selection.addSeparator();
        selection.add(playerOne);
        selection.add(playerTwo);
        if(turnOrder.size()>2){
           selection.add(playerThree);
        }
        if(turnOrder.size()>3){
           selection.add(playerFour); 
        }
        selection.addSeparator();
        selection.add(targetDisplay);
        
        
        gui.add(selection,BorderLayout.WEST);
        //add West toolbar functionality
          playerOne.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    targetNumber=0;
                    targetDisplay.setText("Target: Player " + (targetNumber+1));
                    }
          });
          playerTwo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    targetNumber=1;
                    targetDisplay.setText("Target: Player " + (targetNumber+1));
                    }
          });
          playerThree.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    targetNumber=2;
                    targetDisplay.setText("Target: Player " + (targetNumber+1));
                    }
          });
          playerFour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    targetNumber=3;
                    targetDisplay.setText("Target: Player " + (targetNumber+1));
                    }
          });
        //add Top toolbar button functionality
            moveNorth.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                message.setText("Player "+(playerTurn+1)+" moves North");    
                board.moveNeg(turnOrder.get(playerTurn),0,1);
                    
                    }
          });
         moveEast.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                message.setText("Player "+(playerTurn+1)+" moves East");    
                board.movePos(turnOrder.get(playerTurn),1,0);
                    
                    }
          });
         moveSouth.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                message.setText("Player "+(playerTurn+1)+" moves South");
                board.movePos(turnOrder.get(playerTurn),0,1);
                    
                    }
          });
          moveWest.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                message.setText("Player "+(playerTurn+1)+" moves West");    
                board.moveNeg(turnOrder.get(playerTurn),1,0);
                    
                    }
          });
          attack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                message.setText("Player "+(playerTurn+1)+" attacked Player "+(targetNumber+1));    
                (turnOrder.get(playerTurn)).attack(board,turnOrder.get(targetNumber));
                    
                    
                    }
          });

        chessBoard = new JPanel(new GridLayout(0, 10));
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);

        // create the chess board squares
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                b.setBackground(Color.WHITE);
                b.setBorder(new LineBorder(Color.BLACK));
                
                chessBoardSquares[jj][ii] = b;
            }
        }

        //fill the chess board
        for (int ii = 0; ii < 10; ii++) {
            for (int jj = 0; jj < 10; jj++) {
                        chessBoard.add(chessBoardSquares[jj][ii]);
            }
        }
        
    }
    
    public static int read(){ //scanner method
        Scanner sc = new Scanner(System.in); //constructor for scanner
        
        System.out.println("Enter the Number of the Player you wish to Attack (1,2,3,4,ETC."); //Interface for user
        return sc.nextInt(); //sets string value from scanner into par
    }
    

    public final JComponent getChessBoard() {
        return chessBoard;
    }

    public final JComponent getGui() {
        return gui;
    }
    
    public static void addHeros(Grid board){
        for (int i=0; i<board.charList.size(); i++){
            if(board.charList.get(i).getType().equals("Hero")){
                turnOrder.add((Hero)board.charList.get(i));
            }
        }
    }
    
    public static void turn(Grid board){
        if (playerTurn +1 ==turnOrder.size()){
            roundNumber++;
            playerTurn=0;
            roundDisplay.setText("Round "+roundNumber+":"); 
            playerTurnDisplay.setText("Player "+(playerTurn+1)+"'s turn"); 
        }else{
            playerTurn++;
            playerTurnDisplay.setText("Player "+(playerTurn+1)+"'s turn");
        }
        updateBoard(board);
    }
    
    public static void generateBoard(Grid board){
        Runnable r = new Runnable() {

            @Override
            public void run() {
                GameBoard gb =
                        new GameBoard(board);

                JFrame f = new JFrame("WarGames");
                f.add(gb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);
                

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
                
                
                updateBoard(board);
            }
        };
        SwingUtilities.invokeLater(r);
    }
    public static void updateBoard(Grid g1){
      for(int i=0; i<g1.getSize(); i++){
                    for(int j=0; j<g1.getSize(); j++){
                        if(g1.getPos(i,j) < 0){
                            AddUnicode.addColoredUnicodeCharToContainer(
                            "", //gets the symbol
                            chessBoardSquares[i][j],
                            new Color(203,203,197),
                            Color.WHITE);  
                        }else{
                            AddUnicode.addColoredUnicodeCharToContainer(
                            g1.charList.get(g1.getPos(i,j)).getSymbol(), //gets the symbol
                            chessBoardSquares[i][j],
                            new Color(203,203,197),
                            Color.DARK_GRAY);     
                        }
                    }
                }  
    }
}
