

public class Interface
{
    public static void main(String[] args) {
        //create all necessary objects
        Grid mainGrid = new Grid();
        Hero c0 = new Hero();
        Hero c1 = new Hero();
        Health c2 = new Health();
        Ammo c3 = new Ammo();
        Obstacle c4 = new Obstacle();
        
        //add all character Objects to mainGrid
        mainGrid.addChar(c2);
        mainGrid.addChar(c3);
        mainGrid.addChar(c0);
        mainGrid.addChar(c4);
        mainGrid.addChar(c1);
        
        //Generates the game board and begins game
        GameBoard.generateBoard(mainGrid);
    }
}

