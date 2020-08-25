import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Link: https://www.hackerrank.com/challenges/java-negative-subarray/problem

public class Solution {

    public static void main(String[] args) {

        // Read input from keyboard
        Scanner sc = new Scanner(System.in);

        // Get size of array
        int size = sc.nextInt();

        // Create array and add input as element
        int[] arr = new int[size];

        for (int i=0; i<size; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Count number of negative subarrays
        int counter = 0;

        // Iterate array
        for (int i=0; i<size; i++)
        {
            // Get ith value
            int ans=arr[i];

            // Check if arr[i] is already negative
            if (ans < 0)
            {
                counter++;
            }

            // Iterate array from position after ith
            for (int j=i+1; j<size; j++)
            {
                // Add jth value
                ans += arr[j];

                // Again, check if ans is negative
                if (ans < 0)
                {
                    counter++;
                }
            }
        }

        System.out.printf("%d%n", counter);
    }
}