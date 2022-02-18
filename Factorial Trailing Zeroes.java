// https://leetcode.com/problems/factorial-trailing-zeroes
// NOTE: For some reason Java is returning 13! as "1,932,053,504" instead of "6,227,020,800". This is found in other Java programs as well.
//        The same code converted to Python does give the correct answer!
//        My Python program: https://github.com/anthonyzhub/HackerRank-Leetcode-Solutions/blob/master/Factorial%20Trailing%20Zeroes.py

class Solution {
    
    public int factorial(int num) {
        if (num == 0) {
            return 1;
        }
      
        return num * factorial(num-1);
    }
    
    public int trailingZeroes(int n) {
        
        // Anything below 5! doesn't have a trailing 0
        // if (n <= 4) {return 0;}
        
        // Compute factorial and save answer as a string
        String completeNum = ""+factorial(n);
        char[] charArray = completeNum.toCharArray();
        // System.out.println(completeNum);
        
        // Traverse string in reverse order
        int numOfZeros = 0;
        for (int i=charArray.length-1; i>=0; i--) {
            
            // If character is a '0', increment counter and move to next character
            if (charArray[i] == '0') {
                numOfZeros++;
                continue;
            }
            
            // If condition above wasn't met, then character isn't a 0.
            // Exit loop
            break;
        }
        return numOfZeros;
    }
}
