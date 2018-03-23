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
        int kick = 0;
        int tempI;
        int tempJ;
        while (kick <1){
            tempI = ((int)(Math.random() * 10));
            tempJ = ((int)(Math.random() * 10));
            if(gridArray[tempI][tempJ] < 0){
                charList.add(aChar);
                gridArray[tempI][tempJ] = charList.indexOf(aChar);
                kick++;
            } else{
                counter++;
                if(counter<100){ //if statement to prevent infinite loop
                    kick = 1;
                }
              }
        }      
    }
    
    public void display(){
        System.out.print("\n\u254F");
            for(int k=0; k<size;k++){
                 System.out.print(" \uFF0D \u254F");
                }
            System.out.println();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(gridArray[i][j] < 0){
                    System.out.print("\u254F \u2B1A "); //\u2B1A
                }else{
                    System.out.print("\u254F " + (charList.get(gridArray[i][j])).getSymbol() +" ");
                }
            }
            System.out.print("\u254F\n\u254F");
            for(int k=0; k<size; k++){
                 System.out.print(" \uFF0D \u254F");
                 //dash \uFF0D      vert \u254F
                }
            System.out.println();
        }
        System.out.println("================================================");
        
    }
    public void testRead(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
             System.out.println("/" + gridArray[i][j]);
            }
        }
        System.out.println("=================================");
    }
} 