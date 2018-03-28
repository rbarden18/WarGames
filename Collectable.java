
public abstract class Collectable extends Character
{
    private int[] modIDArr = {ammo,hp};//array allows for need of only one addMods method
    private int modID,modQty; //modID and modQty are variables needed in Collectable subclasses
    private int xPos, yPos; //variables for x and y position
    private String symbol; //String for the Character's symbol
    public Collectable()
    {
        
    }
    
    public void addMods(Character claimer,Collectable aqire){//adds modifier to a Character
        int max=5; //sets a default max incase a Character does not have one
        //if statement finds which modifier is being added and sets max equal to the characters max of that type
        if(aqire.getModID()==0){ 
            max = claimer.getMaxAmmo();
        }else if(aqire.getModID()==1){
            max = claimer.getMaxHp();
        }
        
        modIDArr[0]=claimer.ammo; //ammo slot of array is set to the claimer's ammo value
        modIDArr[1]=claimer.hp;//hp slot of array is set to the claimer's hp value
        modIDArr[aqire.getModID()] += aqire.getModQty();//the index that is being modified is that increased by the quantity
        if(modIDArr[aqire.getModID()]>max){//if the new quantity is more than the max, the quantity will equal the max
            modIDArr[aqire.getModID()] = max;
        }
        //claimers variables get the corresponding array values
        claimer.ammo = modIDArr[0];
        claimer.hp = modIDArr[1];
    }
    
    public int getModID(){return modID;}//returns modID
    
    public int getModQty(){return modQty;}//returns modQty
    
    //abstract method get type requires subclasses to have a getType method
    public abstract String getType();//getType method returns what type of cCharacter this is (Ammo)
    
    public String toString(){//toString displays the values of modIDArr
     return (this.getType());
    }
    
    //abstract method get type requires subclasses to have a getSymbol method
    public abstract String getSymbol();//returns the object's symbol
    
}
