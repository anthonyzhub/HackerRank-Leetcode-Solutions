// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        // Create an array
        int[] tmpArray = new int[2];
        
        // If numbers only has 2 element, return it
        if (numbers.length == 2) {
            tmpArray[0] = 1;
            tmpArray[1] = 2;
            return tmpArray;
        }
        
        // Iterate array
        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                
                // Once the only solution has been found, return it
                if (numbers[i] + numbers[j] == target) {
                    tmpArray[0] = i + 1;
                    tmpArray[1] = j + 1;
                    
                    return tmpArray;
                }
            }
        }
        
        // NOTE: The problem states that each test with only have one solution.
        //      However, Java doesn't know that, so it will claim that there is an error since SOMETHING has to be returned.
        //      Therefore, I added this return statement even if it won't ever be used.
        return tmpArray;
    }
}
