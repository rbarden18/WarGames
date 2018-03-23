
public class Obstacle extends Character
{
    private String name;
    private final int maxHp = 15;
    public int hp;
    public int xPos,yPos;
    //private int attackVal;

    public Obstacle()
    {
        super();
        this.name = "Name";
        hp = maxHp;
    }
    public Obstacle(String name, int hp)
    {
        //Grid.arrayList.add(thisCharacter)
        this.name = name;
        this.hp = hp;
    }
    
    public String toString()
    {
        return (this.name + "" + this.hp + this.ammo);
    }
    
    public String getSymbol(){
        return("X");
    }
}
