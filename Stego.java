
/**
 * Write a description of class Stego here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Stego extends Dinosaur
{
    public Stego()
    {
        super("Stego");
    }

    public boolean attack(Dinosaur def)
    {
        if(def.getType().equals("Stego")) //Defender is also a stego
        {
            if(Math.random() < .55)
            {
                this.update(def, true);
                return true;
            }
            else
            {
                this.update(def, false);
   
                return false;
            }
        }
        else if(def.getType().equals("TRex")) // If defender is a TRex
        {
            if(Math.random() < .35)
            {
                this.update(def,true);
              
                return true;
            }
            else
            {
                this.update(def, false);
         
                return false;
            }
        }
        else // If defender is a random dinosaur
        {
            if(Math.random() < .5)
            {
                this.update(def, true);
   
                return true;
            }
            else
            {
                this.update(def, false);
          
                return false;
            }
        }
    }
}
