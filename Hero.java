
public class Hero extends Character
{
    private final int maxHp = 7;//int which maintains the max HP capacity for a hero
    public int hp;//int that holds Hero's hp
    private final int maxAmmo = 5;//int which maintains the max Ammo capacity for a hero
    public int ammo; //int for ammo
    public int xPos,yPos; //variables for x and y position
    private static int heroCount = 0;//int displaying number of heros
    private String symbol; //String for the symbol
    private final String[] symbArr = {"\u2603","\u260E","\u26DF","\u26F8","\u26CF","\u26F9","\u26f4"};//array of symbols for Hero Objects
    //private int attackVal; unused variable for Objects with different attack values

    public Hero()//default constructor
    {
        hp = 3;
        ammo = 1;
        symbol = (symbArr[heroCount]);
        heroCount ++;
    }
    
    
    public Hero(int hp)//constructor with parameter for custom HP
    {
        //Grid.arrayList.add(thisCharacter)
        
        this.hp = hp;
        ammo = 1;
        symbol = ("p" + heroCount);
        heroCount ++;
    }
    
    public void takeDamage(int amount){//function has the character take damage equal to amount
        this.hp = this.hp-amount;
    }
    
    //attack tries to remove HP from and opponent and always calls the GameBoard.turn fuction
    public void attack (Grid board, Character aChar){
        int roll = (int)(Math.random()*100);
        if (roll > (5 + (this.getDistance(aChar)*5))){ //if statement creates an accuracy system
               aChar.takeDamage(1);
            }else{
               GameBoard.message.setText(GameBoard.message.getText()+": Shot Missed!");
            }
            GameBoard.turn(board);//calls methods needed to keep the GUI updated 
    }
    
    public void setInvalidSymbol(){ //sets the symbol of a 0HP character to an X
        this.symbol ="\u274E";
    }
    
    public String getType(){return "Hero";}//returns what type of Character this is
    
    public String toString()//toString Function displays symbol Characters ammo and HP
    {
        return (this.symbol + " Health: " + this.hp +"  Ammo: "+ this.ammo);
    }
    
    public String getSymbol(){return symbol;}//method returns the symbol variable
}
