
public class Ammo extends Collectable
{
    private final int modID = 0;//modID lets Collectable know what type of mod this is
    private final int modQty = 3;//modQTY gives the amount that is modified
    private int xPos, yPos; //variables for x and y position
    private String symbol ="\uD83D\uDD0B"; //String for the Character's Symbol
    public Ammo(){
        
    }
    
    public int getModID(){return modID;}//returns modID
    
    public int getModQty(){return modQty;}//returns modQty
    
    public String getType(){return "Collectable";}//returns what type of cCharacter this is (Collectable)
    
    public String getSymbol(){return symbol;}//returns the object's symbol
        
    //other symbol possibilities \uD83D\uD83D, \uD83D\uDD2B, \uD83D\uDDD1,\uFF03
}