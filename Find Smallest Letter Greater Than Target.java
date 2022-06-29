// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

class Solution {
    
    public int binarySearch(char[] letters, char target, int leftPtr, int rightPtr) {
        
        // If pointers don't overlap, continue
        if (leftPtr <= rightPtr) {
            
            // Create a middle pointer
            int midPtr = (leftPtr + rightPtr) / 2;
            
            // If element at midPtr is less than or equal to target, update midPointer
            /* NOTE: We're trying to find the index of the SMALLEST, LARGEST element of target.
                I.e., Of all the possible elements that is larger than target, return the smallest of them */
            if (letters[midPtr] <= target) {
                return binarySearch(letters, target, midPtr + 1, rightPtr);
            }
            else {
                return binarySearch(letters, target, leftPtr, midPtr - 1);
            }
        }
        return leftPtr;
    }
    
    public char nextGreatestLetter(char[] letters, char target) {
        
        // If array is empty, exit function
        if (letters == null) {return 'a';}
        
        // Find index of where to insert target
        int targetIdx = binarySearch(letters, target, 0, letters.length - 1);
        return letters[targetIdx % letters.length];
    }
}
