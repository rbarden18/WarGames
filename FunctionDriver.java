/**
 * Write a description of class FunctionDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FunctionDriver
{
    public static void main (String[] args){
        Health h1 = new Health();
        Hero c1 = new Hero();
        System.out.println(h1);
        System.out.println(c1);
        h1.addMods(c1,h1);
        System.out.println(h1);
        System.out.println(c1);
        h1.addMods(c1,h1);
        System.out.println(h1);
        System.out.println(c1);
    }
}