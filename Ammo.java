
public class Ammo extends Collectable
{
    private final int modID = 0;
    private final int modQty = 3;
    
    public Ammo()
    {
        super();
    }
    
    public int getModID(){return modID;}
    
    public int getModQty(){return modQty;}
    
    public String getSymbol(){
        return("\uD83D\uDD0B");
        //Gun symbol \uD83D\uDD2B
        //other symbols \uD83D\uD83D, \uD83D\uDDD1,\uFF03
    }
}