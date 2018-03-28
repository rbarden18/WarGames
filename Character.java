
public abstract class Character
{
    private int xPos, yPos; //variables for x and y position
    private final int maxHp=7;//int which maintains the max HP capacity for a character
    public int hp;//int that holds Character's hp
    private final int maxAmmo=5;//int which maintains the max Ammo capacity for a character
    public int ammo;//int for ammo
    public int index;//index of the character in Grid.charList
    private String symbol; //String for the symbol
    //private int attackVal; unused variable for Objects with different attack values
    //private int accuracyMod;? unused variable for Objects with accuracy values

    public Character()//default constructor
    {
        
    }
    public int getDistance(Character aChar){//returns the distance between two characters using trig, truncated to an int
        return((int)Math.sqrt(Math.pow(this.xPos - aChar.xPos,2) + Math.pow(this.yPos - aChar.yPos,2)));
    }
    
    public int getXPos(Grid board){//returns the x positon of a character on the grid
        for(int i=0; i<board.getSize(); i++){
            for(int j=0; j<board.getSize(); j++){
                if(board.getPos(i,j)==index){//checks if the value of board.gridArr[i][j] is equal to the index of this character in charList, if so i=xPos
                    return i;
                }
            }
        }
        return -1; //returns -1 if there is an error
    }
    
    public int getYPos(Grid board){//returns the y positon of a character on the grid
        for(int i=0; i<board.getSize(); i++){
            for(int j=0; j<board.getSize(); j++){
                if(board.getPos(i,j)==index){//checks if the value of board.gridArr[i][j] is equal to the index of this character in charList, if so j=yPos
                    return j;
                }
            }
        }
        return -1; //returns -1 if there is an error
    }
    
    public void takeDamage(int amount){//function has the character take damage equal to amount
        this.hp = this.hp-amount;
    }
    public void setInvalidSymbol(){ //sets the symbol of a 0HP character to an X
        this.symbol ="\u274E";
    }
    
    //attack tries to remove HP from and opponent and always calls the GameBoard.turn fuction
    public void attack (Grid board, Character aChar){
        int roll = (int)(Math.random()*100);
        if (roll > (5 + (this.getDistance(aChar)*5))){//if statement creates an accuracy system
               aChar.takeDamage(1);
            }else{
               //miss
            }//target Char HP not being removed; however, this.hp can be removede.
            
            GameBoard.turn(board);//calls methods needed to keep the GUI updated 
    }
    
    public abstract String getType(); //forces subclasses to have a getType() method that returns the name of the Subclass
    
    public int getMaxAmmo(){ return maxAmmo;}//retuns maxAmmo; Subclasses inherit this
    
    public int getMaxHp(){ return maxHp;}//retuns maxHp; Subclasses inherit this
    
    
    public String toString()//toString Function displays Characters ammo and HP
    {
        return ("======\nChar Ammo = " +ammo + "\nChar HP = " + hp);
    }
    
    public abstract String getSymbol();//abstract method that would return the symbol variable
    }

