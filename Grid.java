import java.util.ArrayList;
public class Grid
{
    public ArrayList<Character> charList = new ArrayList<Character>();//main arrayList of Characters
    private  int[][] gridArray; //array of the indexes of charList layed out in a grid representing each character
    
    public static final int size = 10; //demensions of the grid
    public Grid(){
        gridArray = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
             gridArray[i][j] = -1;
            }
        }
    }
    
    public int getSize(){return size;}//returns size
    
    public int getPos(int i,int j){return gridArray[i][j];} //returns the characters index in charList
    
    public int getXPos(Character aChar){//returns the x positon of a character on the grid
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(this.getPos(i,j)==aChar.index){//checks if the value of board.gridArr[i][j] is equal to the index of this character in charList, if so i=xPos
                    return i;
                }
            }
        }
        return -1;//returns -1 if there is an error
    }
    public int getYPos(Character aChar){ //returns the y positon of a character on the grid
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(this.getPos(i,j)==aChar.index){ //checks if the value of board.gridArr[i][j] is equal to the index of this character in charList, if so j=yPos
                    return j;
                }
            }
        }
        return -1; //returns -1 if there is an error
    }
    public void addChar(Character aChar){ //tries to add a character to the grid
        int counter = 0; //counts to 100 to prevent an infinite loop
        int kick = 0; //stops while loop after the character is placed
        int tempI;
        int tempJ;
        while (kick <1){ //loops until character is placed or counter ==100
            //tempI and tempJ used to find a random index to try and place the character
            tempI = ((int)(Math.random() * 10));
            tempJ = ((int)(Math.random() * 10));
            if(gridArray[tempI][tempJ] < 0){
                charList.add(aChar); //adds the character to charList
                gridArray[tempI][tempJ] = charList.indexOf(aChar); //sets the array position equal to the character's index in charList
                aChar.index =gridArray[tempI][tempJ]; //sets the character's index variable
                kick++; //ends loop when placed
            } else{
                counter++;//adds to counter
                if(counter<100){ //if statement to prevent infinite loop
                    kick = 1;//ends while loop
                }
              }
        }      
    }
    

    public void movePos(Character currentChar, int xChange, int yChange){ //move method which adds yChange and xChange
        //set variables equal to the character's current position on gridArr
        int xLoc = this.getXPos(currentChar);
        int yLoc = this.getYPos(currentChar);
        if((xLoc + xChange) < 0 || (xLoc + xChange) > size - 1){
            //can't move
        } else if((yLoc + yChange) < 0 || (yLoc + yChange) > size - 1){
            //can't move
        } else if((gridArray[(this.getXPos(currentChar)) + xChange][this.getYPos(currentChar) + yChange] == -1)){ 
            //can only move if space is blank or a collectable
            String c1 = "" + (charList.get(0)).getType();
            //System.out.println(gridArray[(this.getXPos(currentChar)) + xChange][this.getYPos(currentChar) + yChange]);
            //System.out.println(c1);
            gridArray[(xLoc) + xChange][yLoc + yChange] = gridArray[(xLoc)][yLoc]; //new location is set for the character
            gridArray[(xLoc)][yLoc] = -1; //old location is set as blank
        } else{
            if(((charList.get(gridArray[xLoc + xChange][yLoc + yChange])).getType()).equals("Collectable")){
                ((Collectable)(charList.get(gridArray[xLoc + xChange][yLoc + yChange]))).addMods((charList.get(gridArray[xLoc][yLoc])), (Collectable)(charList.get(gridArray[xLoc + xChange][yLoc + yChange])));
                gridArray[(xLoc) + xChange][yLoc + yChange] = gridArray[(xLoc)][yLoc]; //new location is set for the character
                gridArray[(xLoc)][yLoc] = -1; //old location is set as blank
            }
            
            //can't move
        }
        GameBoard.turn(this);
    }
    public void moveNeg(Character currentChar, int xChange, int yChange){//move method which subtracts yChange and xChange
        int xLoc = this.getXPos(currentChar);
        int yLoc = this.getYPos(currentChar);
        if((xLoc - xChange) < 0 || (xLoc - xChange) > size - 1){
            //can't move
        } else if((this.getYPos(currentChar) - yChange) < 0 || (yLoc - yChange) > size - 1){
            //can't move
        } else if((gridArray[(this.getXPos(currentChar)) - xChange][this.getYPos(currentChar) - yChange] == -1)){
            //can only move if space is blank or a collectable
            String c1 = "" + charList.get(0).getType();
            //System.out.println(gridArray[(this.getXPos(currentChar)) - xChange][this.getYPos(currentChar) - yChange]);
            //System.out.println(c1);
            
            gridArray[(xLoc) - xChange][yLoc - yChange] = gridArray[(xLoc)][yLoc];//new location is set for the character
            gridArray[(xLoc)][yLoc] = -1;//old location is set as blank
        } else{
            if(((charList.get(gridArray[xLoc - xChange][yLoc - yChange])).getType()).equals("Collectable")){
                ((Collectable)(charList.get(gridArray[xLoc - xChange][yLoc - yChange]))).addMods((charList.get(gridArray[xLoc][yLoc])), (Collectable)(charList.get(gridArray[xLoc - xChange][yLoc - yChange])));
                gridArray[(xLoc) + xChange][yLoc + yChange] = gridArray[(xLoc)][yLoc]; //new location is set for the character
                gridArray[(xLoc)][yLoc] = -1; //old location is set as blank
            }
            //can't move
        }
        GameBoard.turn(this);
    }


    /* old testing String
   public String display(){
        String out = ("\n-\u254F-");
        for(int k=0; k<size;k++){
                 out +=("\uFF0D-\u254F-");
                 
                }
            out += "\n";
        for(int i=0; i<size; i++){
            out +=(" ");
            for(int j=0; j<size; j++){
                if(gridArray[i][j] < 0){
                    out +=("\u254F\u2009\u2009\u2009\u2009\u2B1A\u2009\u2009\u2009\u2009"); //\u2B1A
                }else{
                    out +=("\u254F " + (charList.get(gridArray[i][j])).getSymbol() +" ");
                }
            }
            out +=("\u254F \n-\u254F-");
            for(int k=0; k<size; k++){
                 out +=("\uFF0D-\u254F-");
                 //dash \uFF0D      vert \u254F
                }
            out += "\n";
        }
        out +=("================================================\n");
        
        return out;
    }*/

} 