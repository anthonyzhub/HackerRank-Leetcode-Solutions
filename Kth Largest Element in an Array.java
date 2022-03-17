// https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
    
    public int partitionArray(int[] nums, int startIdx, int endIdx) {
        
        // Get element at pivot point
        int pivotElem = nums[endIdx];
        int i = (startIdx - 1);
        
        // Cycle through list
        for (int j=startIdx; j<endIdx; j++) {
            
            if (nums[j] <= pivotElem) {
                i++;
                
                // Swap elements
                int oldValue = nums[i];
                nums[i] = nums[j];
                nums[j] = oldValue;
            }
        }
        
        // Do one last swap
        int oldValue = nums[i + 1];
        nums[i + 1] = nums[endIdx];
        nums[endIdx] = oldValue;
        
        return i + 1;
        
    }
    
    public void quickSort(int[] nums, int startIdx, int endIdx) {
        
        if (startIdx < endIdx) {
            
            // Create a pivot
            int pivot = partitionArray(nums, startIdx, endIdx);
            
            // Sort left and right half
            quickSort(nums, startIdx, pivot - 1);
            quickSort(nums, pivot + 1, endIdx);
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
        
        // If nums only has 1 element, return it
        if (nums.length == 1) {return nums[0];}
        
        // Sort array
        quickSort(nums, 0, nums.length - 1);
        for (int i: nums) {
            System.out.printf("%d ", i);
        }
        
        // Return Kth LARGEST element
        return nums[nums.length - k];
    }
}
