public class Health extends Collectable
{
    private final int modID = 1; //modID lets Collectable know what type of mod this is
    private final int modQty = 3;//modQTY gives the amount that is modified
    private int xPos, yPos; //variables for x and y position
    private String symbol = "\uD83D\uDC89";//String for the Character's Symbol
    private static String type = "Collectable";
    
    public Health(){
        
    }
    
    public int getModID(){return modID;}//returns modID
    
    public int getModQty(){return modQty;}//returns modQty
    
    public String getType(){return type;}//returns what type of cCharacter this is (Health)
    
    public String toString(){
        return("health pack");
    }
    
    public String getSymbol(){return symbol;}//returns the object's symbol
    
    //Other symbol options \u26E8,\u26D1 , \uD83D\uDC89
}