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
    //create Initial GUI Variables
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private static JButton[][] chessBoardSquares = new JButton[10][10];
    private static JPanel chessBoard;
    
    //create Initial essential class int variables
    private static int roundNumber =1; //used to find the round number
    private static int playerTurn =0;  //used to find which player's turn it is
    private static int targetNumber = 0;//target number is used to find which player is being targeted
    
    //create essential class arrays and arrayLists
    private static ArrayList<Hero> turnOrder = new ArrayList<Hero>(); //used to find which player's turn it is
    private static ArrayList<Hero> invalidList = new ArrayList<Hero>(); //used to find which players are no longer active  
    private static Character[] playerNums; //keeps player Numbers constant
    
    //create JLabels for the GUI
    public final static JLabel message = new JLabel("Make your move, Player 1.");
    private static  JLabel roundDisplay = new JLabel("Round "+roundNumber+":"); 
    private static  JLabel playerTurnDisplay = new JLabel("Player "+(playerTurn+1)+"'s turn"); 
    private JLabel targetInstructions = new JLabel ("Select who to Target: ");
    private JLabel targetDisplay = new JLabel("Target: Player " + targetNumber);
    private JLabel player1Display;
    private JLabel player2Display;
    private JLabel player3Display;
    private JLabel player4Display;
    private JLabel player1Info;
    private JLabel player2Info;
    private JLabel player3Info;
    private JLabel player4Info;

    GameBoard(Grid board) {//constructor
        initializeGui(board);
    }

    public final void initializeGui(Grid board) {//method creates the GUI
        addHeros(board);////adds heros created in (Grid board) to turnOrder arrayList
        
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        
        tools.setFloatable(false);//sets it so the toolbar cannot be moved
        gui.add(tools, BorderLayout.PAGE_START);//ads the toolbar to the begnning of the page
        
        //create toolbar buttons
        JButton moveNorth = new JButton("moveNorth");
        JButton moveEast = new JButton("moveEast");
        JButton moveSouth = new JButton("moveSouth");
        JButton moveWest = new JButton("moveWest");
        JButton attack = new JButton("Attack");
         
        //add toolbar buttons
        tools.add(moveNorth);
        tools.add(moveEast); 
        tools.add(moveSouth); 
        tools.add(moveWest); 
        tools.addSeparator(); //adds a gap in between components on the toolbar
        tools.add(attack); 
        tools.addSeparator();
        tools.add(roundDisplay);
        tools.addSeparator();
        tools.add(playerTurnDisplay);
        
        
        //set up status diplay
        JToolBar status = new JToolBar();//creates a new toolbar (default horizontal positioning)
        status.setFloatable(false);
        gui.add(status, BorderLayout.SOUTH);//adds this toolbar to the bottom of the panel
        
        //Adds status message JLabel to status toolbar
        status.addSeparator();
        status.add(message);
        
        
        //set up targeting system
        JRadioButton playerOne = new JRadioButton("Player 1");
        JRadioButton playerTwo = new JRadioButton ("Player 2");
        JRadioButton playerThree = new JRadioButton ("Player 3");
        JRadioButton playerFour = new JRadioButton ("Player 4");
        
        //creats JLabels to show information about each hero
        player1Display = new JLabel("Player 1  "+ playerNums[0].getSymbol());
        player1Info = new JLabel("Health: " + playerNums[0].hp +"   Ammo: " + playerNums[0].ammo);
        player2Display = new JLabel("Player 2  "+ playerNums[1].getSymbol());
        player2Info = new JLabel("Health: " + playerNums[1].hp +"   Ammo: " + playerNums[1].ammo);
        
        
        
        //create Button group and assign Radio buttons to it
        ButtonGroup selectGroup = new ButtonGroup();
        selectGroup.add(playerOne);
        selectGroup.add(playerTwo);
        selectGroup.add(playerThree);
        selectGroup.add(playerFour);
        
        //create a new toolbar
        JToolBar selection = new JToolBar(1);//creates a vertical toolbar
        selection.setFloatable(false);
        
        //add elements to selection toolbar
        selection.addSeparator();
        selection.add(targetInstructions);
        selection.addSeparator();
        selection.add(playerOne);
        selection.add(playerTwo);
        if(turnOrder.size()>2){ //only adds 3rd radioButton if there is a 3rd player
           selection.add(playerThree);
        }
        if(turnOrder.size()>3){//only adds 4th radioButton if there is a 4th player
           selection.add(playerFour); 
        }
        selection.addSeparator();
        selection.add(targetDisplay);
        selection.addSeparator();
        selection.addSeparator();
        selection.add(player1Display);
        selection.add(player1Info);
        selection.addSeparator();
        selection.add(player2Display);
        selection.add(player2Info);
        if(playerNums.length>2){ //only adds 3rd player information if there is a 3rd player
           selection.addSeparator();
           player3Display = new JLabel("Player 3  "+ playerNums[2].getSymbol());
           player3Info = new JLabel("Health: " + playerNums[2].hp +"   Ammo: " + playerNums[2].ammo);
           selection.add(player3Display);
           selection.add(player3Info);
        }
        if(playerNums.length>3){//only adds 4th player information if there is a 4th player
           selection.addSeparator();
           
           player4Display = new JLabel("Player 4  "+ playerNums[1].getSymbol());
           player4Info = new JLabel("Health: " + playerNums[2].hp +"   Ammo: " + playerNums[2].ammo);
           selection.add(player4Display);
           selection.add(player4Info);
        }
        //adds selction toolbar to the left side
        gui.add(selection,BorderLayout.WEST);
        
        //adds functionality for radioButtons on the selection toolbar(Left Side)
          playerOne.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    targetNumber=0; //player 1 is being targeted
                    targetDisplay.setText("Target: Player " + (targetNumber+1)); //sets text to target player 1
                    //System.out.println(turnOrder.get(targetNumber).getSymbol());//targeted char is correct
                    }
          });
          playerTwo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    targetNumber=1;//player 2 is being targeted
                    targetDisplay.setText("Target: Player " + (targetNumber+1)); //sets text to target player 2
                    //System.out.println(turnOrder.get(targetNumber).getSymbol());
                    }
          });
          playerThree.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    targetNumber=2;//player 3 is being targeted
                    targetDisplay.setText("Target: Player " + (targetNumber+1)); //sets text to target player 3
                    //System.out.println(turnOrder.get(targetNumber).getSymbol());
                    }
          });
          playerFour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    targetNumber=3; //player 4 is being targeted
                    targetDisplay.setText("Target: Player " + (targetNumber+1)); //sets text to target player 4
                    //System.out.println(turnOrder.get(targetNumber).getSymbol());
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
                System.out.println(turnOrder.get(playerTurn)+" vs: " + turnOrder.get(targetNumber));
                (turnOrder.get(playerTurn)).attack(board,turnOrder.get(targetNumber));
                System.out.println("After: "+turnOrder.get(targetNumber));
                    
                    
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
    
    public static void addHeros(Grid board){//adds heros to turnOrder arrayList and sets PlayerNums array
        for (int i=0; i<board.charList.size(); i++){
            if(board.charList.get(i).getType().equals("Hero")){
                turnOrder.add((Hero)board.charList.get(i));
            }
        }
        playerNums = new Character[turnOrder.size()];
        for (int k=0; k<turnOrder.size(); k++){
            playerNums[k] = turnOrder.get(k);
        }
    }
    
    public static void turn(Grid board){ //calls methods needed to keep the GUI updated properly
        turnCounter(board);
        updateBoard(board);
        checkDed(board);
    }
    public static void turnCounter(Grid board){
        if (playerTurn +1 ==turnOrder.size()){
            roundNumber++;
            playerTurn=0;
            roundDisplay.setText("Round "+roundNumber+":"); 
            playerTurnDisplay.setText("Player "+(playerTurn+1)+"'s turn"); 
            
        }else{
            playerTurn++;
            playerTurnDisplay.setText("Player "+(playerTurn+1)+"'s turn");
            
        }
    }
    
    public static void checkDed(Grid board){
       for (int i = 0; i<turnOrder.size(); i++){ 
          if(turnOrder.get(i).hp<=0){
             System.out.println(turnOrder.get(i).getSymbol());    
             turnOrder.get(i).setInvalidSymbol();
             AddUnicode.addColoredUnicodeCharToContainer(
                            "\u274E", //gets the symbol
                            chessBoardSquares[board.getXPos(turnOrder.get(i))][board.getYPos(turnOrder.get(i))],
                            new Color(203,203,197),
                            Color.DARK_GRAY); 
                            turnOrder.get(i).setInvalidSymbol();
                            invalidList.add(turnOrder.get(i));
                            System.out.println(playerTurn);
                            if(i==playerTurn){
                             turnCounter(board);  
                            }
                            System.out.println(playerTurn);
                            turnOrder.remove(i);
                            //System.out.println(board.getXPos(turnOrder.get(i)));
                            
            }
        }   
        
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
    public static void updateBoard(Grid board){
      for(int i=0; i<board.getSize(); i++){
                    for(int j=0; j<board.getSize(); j++){
                        if(board.getPos(i,j) < 0){
                            AddUnicode.addColoredUnicodeCharToContainer(
                            "", //gets the symbol
                            chessBoardSquares[i][j],
                            new Color(203,203,197),
                            Color.WHITE);  
                        }else{
                            AddUnicode.addColoredUnicodeCharToContainer(
                            board.charList.get(board.getPos(i,j)).getSymbol(), //gets the symbol
                            chessBoardSquares[i][j],
                            new Color(203,203,197),
                            Color.DARK_GRAY);     
                        }
                    }
                }  
    }
}
