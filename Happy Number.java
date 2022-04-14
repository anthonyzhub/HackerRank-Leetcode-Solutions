// https://leetcode.com/problems/happy-number/

class Solution {
    
    public int sumAndSquareNumber(int n) {
        
        // OBJECTIVE: Square each digit and calculate sum of all digits
        
        // Create a new number
        int final_num = 0;
        
        // Convert integer to string, in order to cover to char array, then iterate array
        for (char c: String.valueOf(n).toCharArray()) {
            
            // Convert character to integer
            int tmp_int = Character.getNumericValue(c);
            
            // Square number then add it to final_num
            final_num += Math.pow(tmp_int, 2);
        }
        
        return final_num;
    }
    
    public boolean isHappy(int n) {
        
        // If n is less than 0, return false
        if (n <= 0) {return false;}
        
        // If n is already 1, return true
        if (n == 1) {return true;}
        
        // Create an array list
        ArrayList<Integer> results = new ArrayList();
        
        // While "n" doesn't exist inside of "results", continue to square and sum digits
        while (results.contains(n) == false) {
            
            // Add "n" to list
            results.add(n);
            
            // Create new number from n
            n = sumAndSquareNumber(n);
            
            // If n equals 1, return true
            if (n == 1) {return true;}
        }
        
        // If "n" already exist inside of "results", return false to avoid repetition
        return false;
    }
}
