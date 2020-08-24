import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        // Accept input from keyboard and get string
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();

        // Remove leading and trailing whitespaces
        s = s.trim();

        // Print 0, if s is blank or too long. Then, exit program.
        if (s.length() == 0 || s.length() > 4000000)
        {
            System.out.printf("0");
            return;
        }

        // Turn string to array
        // Create a new entry, if one of the regular expressions were met
        String[] arr = s.split("[ !,?.\\_'@]+");

        // Print array's length
        System.out.printf("%d%n", arr.length);

        // Iterate array with a for-in loop
        for (String tmp: arr)
        {
            System.out.printf("%s%n", tmp);
        }
    }
}