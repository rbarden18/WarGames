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
    
    public void addChar(Character aChar){
        int counter = 0;
        int tempI = ((int)(Math.random() * 10));
        int tempJ = ((int)(Math.random() * 10));
        charList.add(aChar);
        if(gridArray[tempI][tempJ] < 0){
            gridArray[tempI][tempJ] = charList.indexOf(aChar);
         } else{
             counter++;
             if(counter<100){ //if statement to prevent infinite loop
                 addChar(aChar);
                }
            }
    }
    
    public String display(){
        String output = "";
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(charList.indexOf(gridArray[i][j]) == -1){ //make method for getDisplay in Character Class
                    output += " ";
                } else if (gridArray[i][j] == 0){
                    output += " ";
                } else{
                    
                }
            }
            output += "/n";
        }
        return(output);
    }
    public void testRead(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
             System.out.print("/" + gridArray[i][j]);
            }
            System.out.println();
        }
        System.out.println("=================================");
    }
}