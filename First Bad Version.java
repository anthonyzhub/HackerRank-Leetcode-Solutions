// https://leetcode.com/problems/first-bad-version/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        // Create left and right pointer
        int leftPtr = 1;
        int rightPtr = n;
        
        // Move pointers until 1st bad version is found
        while (leftPtr <= rightPtr) {
            
            // Select mid point
            int midPtr = leftPtr + (rightPtr - leftPtr) / 2;
            
            // If midPtr is bad, then move rightPtr to element before mid point
            // This will narrow the range of possible bad versions
            if (isBadVersion(midPtr) == true) {
                rightPtr = midPtr - 1;
                continue;
            }
            
            // Update leftPtr
            leftPtr = midPtr + 1;
        }
      
        // Once while-loop ends, return leftPtr because it's at 1st bad version
        return leftPtr;
    }
}
