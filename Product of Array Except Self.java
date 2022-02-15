// Link: https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    
    public int[] productExceptSelf(int[] nums) {
        
        // Create a new array filled with 1's.
        int[] answer = new int[nums.length];
        Arrays.fill(answer, 1);
        
        // Create pointers
        int leftIdx = 1;
        int rightIdx = 1;
        
        // Iterate nums
        for (int i=0; i<nums.length; i++)
        {
            // Start at 2nd to last element
            int answerIdx = nums.length - i - 1;
            
            // Update left and right element in answer
            answer[i] = leftIdx * answer[i];
            answer[answerIdx] = rightIdx * answer[answerIdx];
            
            // Update pointers
            leftIdx *= nums[i];
            rightIdx *= nums[answerIdx];
        }
        
        return answer;
    }
}
