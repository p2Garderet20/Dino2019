
/**
 * Write a description of class Triceratops here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Triceratops extends Dinosaur
{
    
    public Triceratops()
    {
        super("Triceratops");
    }

    public boolean attack(Dinosaur def)
    {
        if(def.getType().equals("Triceratops"))//Defender is a triceratops
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
        else if(def.getType().equals("TRex"))//Defender is a TRex
        {
            if(Math.random() < .45)
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
        else if(def.getType().equals("Stego"))//Defender is a stegosauras
        {
            if(Math.random() < .60)
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
        else //defender is an unknown dinosaur
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
