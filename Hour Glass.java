import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Link: https://www.hackerrank.com/challenges/java-2d-array/problem

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create a 2D array
        int[][] arr = new int[6][6];

        // Add input to array
        for (int i = 0; i < 6; i++) 
        {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) 
            {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        System.out.println(max_glass_sum(arr));
    }
    
    public static int max_glass_sum(int [][] arr) 
    {

        // OBJECTIVE: Create all possible hour glass to find the max possible value

        // Get minimum value now
        int max = Integer.MIN_VALUE;

        // 4 was selected because it's how many times an hour glasses can move vertically
        for (int row = 0; row < 4; row++) 
        {

            // 4 was selected because it's how many times an hour glasses can move vertically
            for (int col = 0; col < 4; col++) 
            {
                // Call get_sum() to get sum of all the values in the hour glass
                int sum = get_sum(arr, row, col);

                // Return highest number
                max = Math.max(max, sum);
            }
        }

        // Return final highest number
        return max;
    }
    
    private static int get_sum(int [][] arr, int row, int col) 
    {
        // OBJECTIVE: Compute sum of all values inside the hour glass
        
        // Get sum of each row
        int top = arr[row+0][col+0] + arr[row+0][col+1] + arr[row+0][col+2];
        int mid = arr[row+1][col+1];
        int bottom = arr[row+2][col+0] + arr[row+2][col+1] + arr[row+2][col+2];

        // Return sum
        return top+mid+bottom;
    }
}
