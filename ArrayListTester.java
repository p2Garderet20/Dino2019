import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class ArrayListTester here.
 *
 * @author (your name)
 * @version (a version number or a date) 
 */
public class ArrayListTester
{
    public static void main(String[] args)
    {
        System.out.print("How many words? ");
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int numWords = s1.nextInt();
        System.out.println(numWords);
        
        ArrayList<String> words = new ArrayList<String>();
        
        System.out.println(words.size());
        words.add("fun");
        words.add("work");
        words.add(0, "sleep");
        System.out.println(words.size());
        words.remove(1);
        System.out.println(words);
    }
}
