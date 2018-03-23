public class Interface
{
    public static void main(String[] args) {
        Grid testG = new Grid();
        testG.display();
        Hero c0 = new Hero();
        Hero c1 = new Hero();
        Health c2 = new Health();
        Ammo c3 = new Ammo();
        testG.addChar(c2);
        testG.addChar(c3);
        testG.addChar(c0);
        testG.display();
        testG.addChar(c1);
        testG.display();
        System.out.println(c1.getSymbol());
    }
}