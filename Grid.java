import java.util.ArrayList;
public class Grid
{
    private int[][] gridArray;
    public ArrayList<Character> charList = new ArrayList<Character>();
    private final int size = 10;
    public Grid(){
        gridArray = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
             gridArray[i][j] = -1;
            }
        }
    }
    
    public int getSize(){return size;}
    public int getPos(int i,int j){return gridArray[i][j];}
    public int getXPos(Character aChar){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(this.getPos(i,j)==aChar.index){
                    return i;
                }
            }
        }
        return -1;
    }
    public int getYPos(Character aChar){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(this.getPos(i,j)==aChar.index){
                    return j;
                }
            }
        }
        return -1;
    }
    public void addChar(Character aChar){
        int counter = 0;
        int kick = 0;
        int tempI;
        int tempJ;
        while (kick <1){
            tempI = ((int)(Math.random() * 10));
            tempJ = ((int)(Math.random() * 10));
            if(gridArray[tempI][tempJ] < 0){
                charList.add(aChar);
                gridArray[tempI][tempJ] = charList.indexOf(aChar);
                aChar.index =gridArray[tempI][tempJ];
                kick++;
            } else{
                counter++;
                if(counter<100){ //if statement to prevent infinite loop
                    kick = 1;
                }
              }
        }      
    }
    
    
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
    }
    
} 
