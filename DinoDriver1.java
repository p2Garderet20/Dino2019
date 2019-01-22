
/**
 * Write a description of class DinoDriver1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver1
{
    public static void main(String[] args)
    {
        Dinosaur d1 = new TRex();
        Dinosaur d2 = new Stego();
        Dinosaur d3 = new Triceratops();
        d1.setHealth(100);
        d2.setHealth(100);
        
        // if(d2.attack(d1) == true)
        // {
            // d2.update(true);
            // d1.update(false);
            // System.out.println("Attacker wins!");
            
        // }
        // else
        // {
            // d1.update(true);
            // d2.update(false);
            // System.out.println("Defender wins!");
        // }
        
        int winCount = 0;
        for(int i = 0 ; i < 100; i++)
        {

            if(d1.attack(d2) == true)
            {
                winCount++; 
            }
            
            System.out.println(d1.toString() + "   *******   " + d2.toString());
            
        }
        System.out.println(" " + winCount + " out of 100 attacks yee yee");
    }
}
