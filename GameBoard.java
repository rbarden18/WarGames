import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;
//https://stackoverflow.com/questions/21077322/create-a-chess-board-with-jpanel
//https://stackoverflow.com/questions/18686199/fill-unicode-characters-in-labels
public class GameBoard {
    
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private static JButton[][] chessBoardSquares = new JButton[10][10];
    private static JPanel chessBoard;
    private final JLabel message = new JLabel(
            "Make your move.");

    GameBoard() {
        initializeGui();
    }

    public final void initializeGui() {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("moveNorth")); // TODO - add functionality!
        tools.add(new JButton("moveEast")); // TODO - add functionality!
        tools.add(new JButton("moveSouth")); // TODO - add functionality!
        tools.add(new JButton("moveWest")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(new JButton("Attack")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(message);

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
    
    

    public final JComponent getChessBoard() {
        return chessBoard;
    }

    public final JComponent getGui() {
        return gui;
    }
    
    
    public static void generateBoard(Grid g1){
        Runnable r = new Runnable() {

            @Override
            public void run() {
                GameBoard gb =
                        new GameBoard();

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
                
                for(int i=0; i<g1.getSize(); i++){
                    for(int j=0; j<g1.getSize(); j++){
                        if(g1.getPos(i,j) < 0){
                                 
                        }else{
                            AddUnicode.addColoredUnicodeCharToContainer(
                            g1.charList.get(g1.getPos(i,j)).getSymbol(), chessBoardSquares[i][j],
                            new Color(203,203,197),
                            Color.DARK_GRAY);     
                        }
                    }
                }
            }
        };
        SwingUtilities.invokeLater(r);
    }
}
