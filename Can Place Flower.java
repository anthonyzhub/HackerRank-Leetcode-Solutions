// https://leetcode.com/problems/can-place-flowers/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        // Create a counter to count how many new plants were planted
        int counter = 0;
        
        // Get size of flowerbed
        int bedSize = flowerbed.length;
        
        // Iterate array
        for (int i=0; i<bedSize; i++) {
            
            // Check if ith plot is empty
            if (flowerbed[i] == 0) {
                
                // Check neighboring plots
                // NOTE: 1st condition is used to check if ith element is the beginning or the end of array
                boolean isLeftEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean isRightEmpty = (i == bedSize - 1 || flowerbed[i + 1] == 0);
                
                // If both neighboring plots are empty, update counter and element
                if (isLeftEmpty && isRightEmpty) {
                    
                    // Update counter and element
                    counter++;
                    flowerbed[i] = 1;
                    
                    // If counter is greater than or equal to n, return true
                    if (counter >= n) {return true;}
                }
            }
        }
        
        return counter >= n;
    }
}
