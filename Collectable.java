
public abstract class Collectable extends Character
{
    public int ammo, hp;
    private int[] modIDArr = {ammo,hp};
    private int modID,modQty;
    public Collectable()
    {
        super();
    }
    
    public void addMods(Character claimer,Collectable aqire){
        int max=5;
        if(aqire.getModID()==0){
            max =claimer.getMaxAmmo();
        }else if(aqire.getModID()==1){
            max =claimer.getMaxHp();
        }
        modIDArr[0]=claimer.ammo;
        modIDArr[1]=claimer.hp;
        modIDArr[aqire.getModID()] += aqire.getModQty();
        if(modIDArr[aqire.getModID()]>max){
            modIDArr[aqire.getModID()] = max;
        }
        claimer.ammo = modIDArr[0];
        claimer.hp = modIDArr[1];
    }
    
    public int getModID(){return modID;}
    public int getModQty(){return modQty;}
    public abstract String getType();
    
    public String toString(){
     return ("==============\nmodID0 = " + modIDArr[0] +"\nmodID1 = " + modIDArr[1]);
    }
    
    public abstract String getSymbol();
    
}
