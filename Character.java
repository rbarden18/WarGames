
public abstract class Character
{
    private String name;
    public int xPos,yPos;
    private final int maxHp=7;
    public int hp;
    private final int maxAmmo=5;
    public int ammo;
    //private int attackVal;
    //private int accuracyMod;?

    public Character()
    {
        //Grid.arrayList.add(thisCharacter)
    }
    
    public int getDistance(Character aChar){
        
        return((int)Math.sqrt(Math.pow(this.xPos + aChar.xPos,2) + Math.pow(this.yPos + aChar.yPos,2)));
        
    }
    public int getXPos(){
        int findPos;
        findPos = 0; //temporary - formula needed
        return findPos;
    }
    
    public int getMaxAmmo(){ return maxAmmo;}
    public int getMaxHp(){ return maxHp;}
    
    public int getYPos(){
        int findPos;
        findPos = 0; //temporary - formula needed
        return findPos;
    }
    public String toString()
    {
        return ("======\nChar Ammo = " +ammo + "\nChar HP = " + hp);
    }
    
    public abstract String getSymbol();
    }

