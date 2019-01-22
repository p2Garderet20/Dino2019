import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class DinoDriver3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver3
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        ArrayList<Dinosaur> myPop = new ArrayList<Dinosaur>();
        System.out.println("How many dinos in population? ");
        int numDinos = s.nextInt();
        for(int i = 0; i < numDinos; i++)
        {
            double r = Math.random();
            if(r < .33)
            {
                myPop.add(new TRex());
            }
            else if(r < .67)
            {
                myPop.add(new Triceratops());
            }
            else
            {
                myPop.add(new Stego());
            }
        }
        for(Dinosaur d: myPop)
        {
            int x = (int)(Math.random()*30);

            for(int i = 0; i < x; i ++)
            {
                d.ageUp();
            }

            System.out.println(d.toString());
        }

        while(DinoDriver3.getLivingDinos(myPop) > 1)
        {
            for(Dinosaur d: myPop)//Haves dinosaurs attack eachother
            {
                if((d.getIsAlive() == true) && (DinoDriver3.getLivingDinos(myPop) > 1))// The dinosaur d (attacker) is alive 
                //and there are more than 2 living dinosaurs, 
                {
                    Dinosaur Defender =  DinoDriver3.getDefender(myPop, d);

                    if(d.attack(Defender) == true)
                    {
                        d.update(Defender,true);
                    }
                }
            }
        }
    }

    public static int getDefender( ArrayList<Dinosaur> p, Dinosaur attacker  )
    {
        Dinosaur def;// = null;
        int rand = -1;
        do // def is the attacking dino 
        {
            rand = (int)(Math.random()*p.size());
            def = p.get(rand);
        }while( def == attacker || !def.getIsAlive() );

        return rand;
    }


    public static int getLivingDinos(ArrayList<Dinosaur> p) //Returns number of living dinosaurs
    {
        int living = 0;
        for(Dinosaur d: p)
        {
            if(d.getIsAlive() == true)
            {
                living++;
            }
        } 
        return living;
    }

    public static void removeDeadDinos( ArrayList<Dinosaur> p )
    {
        for(int i =0; i<p.size(); i++)
            if(p.get(i).getIsAlive() == false)
            {
                p.remove(i);
                i--;
            }
    }

}
