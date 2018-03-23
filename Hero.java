
public class Hero extends Character
{
    private String name;
    private final int maxHp = 7;
    public int hp;
    private final int maxAmmo = 5;
    public int ammo;
    public int xPos,yPos;
    private static int heroCount = 1;
    private String heroSymbol;
    //private int attackVal;

    public Hero()
    {
        super();
        this.name = "Name";
        hp = 1;
        ammo = 1;
        heroSymbol = ("p" + heroCount);
        heroCount ++;
    }
    public Hero(String name, int hp)
    {
        //Grid.arrayList.add(thisCharacter)
        this.name = name;
        this.hp = hp;
        ammo = 1;
        heroSymbol = ("p" + heroCount);
        heroCount ++;
    }
    
    public void attack (Character aChar){
        int roll = (int)(Math.random()*100);
	if (roll > (5 + (this.getDistance(aChar)*5))){
		aChar.hp -= 1;
	}else{
		//miss
	}

    }
    
    public String toString()
    {
        return (this.name + "" + this.hp + this.ammo);
    }
    
    public String getSymbol(){
        return(heroSymbol);
    }
}
