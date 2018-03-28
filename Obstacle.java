
public class Obstacle extends Character
{
    //HP in Obstacles is for potential future use
    private final int maxHp = 15;//int which maintains the max HP capacity for a character
    public int hp;//int that holds Character's hp
    private String symbol = "\u26A0"; //String for the Character's symbol
    private int xPos, yPos; //variables for x and y position

    public Obstacle() //default Obstacle constructor. Sets HP of obstacle
    {
        hp = maxHp;
    }
    public Obstacle(int hp) //cunstructor with customizable HP values
    {
        this.hp = hp;
    }
    
    public String toString()//returns symbol and HP of the obstacle
    {
        return (this.symbol + " " + this.hp);
    }
    public String getType(){return "Obstacle";}//returns the Character type of this class (Obstacle)
    public String getSymbol(){return(symbol);} //returns the object's symbol
    //Other options \u2623,  \u2622, \u26DD
}
