
public abstract class Character
{
    private String name;
    private int xPos;
    private int yPos;
    private final int maxHp=7;
    public int hp;
    private final int maxAmmo=5;
    public int ammo;
    public int index;
    //private int attackVal;
    //private int accuracyMod;?

    public Character()
    {
        //Grid.arrayList.add(thisCharacter)
    }
    public int getDistance(Character aChar){
        return((int)Math.sqrt(Math.pow(this.xPos + aChar.xPos,2) + Math.pow(this.yPos + aChar.yPos,2)));
    }
    
    public int getXPos(Grid board){
        for(int i=0; i<board.getSize(); i++){
            for(int j=0; j<board.getSize(); j++){
                if(board.getPos(i,j)==index){
                    return i;
                }
            }
        }
        return -1;
    }
    
    public int getMaxAmmo(){ return maxAmmo;}
    public int getMaxHp(){ return maxHp;}
    
    public int getYPos(Grid board){
        for(int i=0; i<board.getSize(); i++){
            for(int j=0; j<board.getSize(); j++){
                if(board.getPos(i,j)==index){
                    return j;
                }
            }
        }
        return -1;
    }
    public String toString()
    {
        return ("======\nChar Ammo = " +ammo + "\nChar HP = " + hp);
    }
    
    public abstract String getSymbol();
    }

