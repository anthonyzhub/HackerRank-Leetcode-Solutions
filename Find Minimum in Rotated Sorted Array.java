// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    
    // SOLUTION 1
    public int findMinSolutionOne(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
    
    // SOLUTION 2
    public int findMinSolutionTwo(int[] nums) {
        
        // If array is empty, exit function. 
        if (nums == null) {return 0;}
        
        // If array only has 1 element, return 1st element
        if (nums.length == 1) {return nums[0];}
        
        // Create left and right pointers
        int leftPtr = 0;
        int rightPtr = nums.length - 1;
        
        // If Nth element is bigger than 1st element, then array wasn't rotated
        if (nums[rightPtr] > nums[leftPtr]) {return nums[0];}
        
        // Perform binary search
        while (rightPtr >= leftPtr) {
            
            // Get mid element
            int midPtr = leftPtr + (rightPtr - leftPtr) / 2;
            
            // If mid element is bigger than mid+1, then inflection point has been found yet.
            /* NOTE: Since array has been rotated, an ordinary binary search wouldn't work.
                    The inflection point is where the array original started. E.g., [2, 1, 3]. Inflection is between "2" and "1".
                    Until inflection point is found, we won't know where the true first element is.
                    Remember, array started in a sorted, ascending order.
            */
            if (nums[midPtr] > nums[midPtr + 1]) {return nums[midPtr + 1];}
            
            // If mid element is smaller than mid-1, than mid element is the inflection point
            if (nums[midPtr] < nums[midPtr - 1]) {return nums[midPtr];}
            
            // If infliction hasn't been found yet, set leftPtr one unit to the right of midPtr
            // NOTE: The first true element will be somewhere on the right
            if (nums[midPtr] > nums[0]) {
                leftPtr = midPtr + 1;
            }
            else {
                rightPtr = midPtr - 1;
            }
        }
        
        // Java expects a value to be returned even if conditions inside while-loop fails
        return 0;
    }

    // SOLUTION 3
    public int findMinSolutionThree(int[] nums) {

        /*
         * Time Complexity: O(log n) where n = length of nums. Nums is split by half until one element remains.
         *  Then, the algorithm compares that one element in its half.
         * 
         * Space Complexity: O(1) because no dynamic data structure or stack was created.
         */

        if (nums.length == 1) {
            return nums[0];
        }

        // Create a return variable. This will hold the smallest element
        int res = nums[0];

        // Create a left and right pointer
        int leftPtr = 0;
        int rightPtr = nums.length - 1;
        
        // Iterate array
        while (leftPtr <= rightPtr) {

            // If the array between left and right pointer is already sorted in ascending order, return the smallest value
            if (nums[leftPtr] < nums[rightPtr]) {
                res = Math.min(res, nums[leftPtr]);
                break;
            }

            // Calculate middle index
            int midIdx = (int) rightPtr - leftPtr / 2;
            res = Math.min(res, nums[midIdx]);

            // If left half of subarray is already sorted in ascending order, then move leftPtr to the right half to investigate the right side.
            // E.g., [3, 4, 5, 1, 2]
            if (nums[midIdx] >= nums[leftPtr]) {
                leftPtr = midIdx + 1;
            }
            else {
                // If right half of subarray is already sorted in ascending order, then move rightPtr to the left left half.
                // E.g., [1, 2, 3, 4, 5]
                rightPtr = midIdx - 1;
            }
        }

        return res;
    }
}
