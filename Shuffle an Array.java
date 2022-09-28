// https://leetcode.com/problems/shuffle-an-array/

class Solution {
    
    // Create an array to hold input array
    int[] nums;
    
    // Create an array to hold elements from input array
    int[] orig;
    
    // Create a variable to hold size of input array
    int n;
    
    // Initialize Random class
    Random rand = new Random();

    public Solution(int[] nums) {
        
        // Pass nums to this.nums
        this.nums = nums;
        
        // Copy elements from nums to orig
        this.orig = nums.clone();
        
        // Get size of nums
        this.n = nums.length;
    }
    
    public int[] reset() {
        
        // OBJECTIVE: Return original array
        return orig;
    }
    
    public int[] shuffle() {
        
        // OBJECTIVE: Use Fisher-Yates algorithm to shuffle nums array
        
        // Iterate list
        for (int curIdx=0; curIdx<n; curIdx++) {
            
            // Generate random index
            int randIdx = rand.nextInt(n);
            
            // Swap elements from curIdx and randIdx
            int oldVal = nums[curIdx];
            nums[curIdx] = nums[randIdx];
            nums[randIdx] = oldVal;
        }
        
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
