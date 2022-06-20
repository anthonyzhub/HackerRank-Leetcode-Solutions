// https://leetcode.com/problems/valid-mountain-array/

class Solution {
    public boolean validMountainArray(int[] arr) {
        
        // If array's size is less than 3, return false
        if (arr.length < 3) {return false;}
        
        // Create a pointer and get array's size
        int peak = 0;
        int arrSize = arr.length;
        
        // Traverse the array from left-to-right
        // I.e., Climb up the mountain
        while (peak + 1 < arrSize && arr[peak] < arr[peak + 1]) {
            peak++;
        }
        
        // If pointer is either at the beginning or the end of the array, return false
        // I.e., Peak element can't be at either endpoints, or else it's not a mountain array
        if (peak == 0 || peak == arrSize - 1) {
            return false;
        }
        
        // Continue to traverse the array
        // I.e., Climb down the mountain
        while (peak + 1 < arrSize && arr[peak] > arr[peak + 1]) {
            peak++;
        }
        
        // If mountain climber (pointer) reached the end of the mountain, return true
        return peak == arrSize - 1;
    }
}
