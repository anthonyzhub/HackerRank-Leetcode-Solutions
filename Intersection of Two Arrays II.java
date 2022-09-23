// https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution {
    
    public int findElem(int[] arr, int target) {
        
        // OBJECTIVE: Return index of target's index inside of array
        
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == target) {return i;}
        }
        
        return -1;
    }
    
    public int[] intersect(int[] nums1, int[] nums2) {
        
        /*
        OBJECTIVE: Return intserction of both arrays
        Time Complexity: O(mn + i) where m = length of nums1, n = length of nums2, and i = length of arr.
        Space Complexity: O(i) where i = number of intersecting elements between nums1 and nums2 that are
                            stored in arr.
        */
        
        // If both arrays are the same, return either array
        if (Arrays.equals(nums1, nums2)) {return nums1;}
        
        // If either array is empty, return an empty array
        if (nums1.length < 0 || nums2.length < 0) {return null;}
        
        // Create a new array
        ArrayList<Integer> res = new ArrayList<>();
        
        // Traverse both arrays
        int n = nums2.length;
        for (int elem: nums1) {
            
            // Check if n is greater than 0 and elem exist in nums2
            int targetIdx = findElem(nums2, elem);
            System.out.println(targetIdx);
            if (n > 0 && targetIdx != -1) {
                
                // Add elem to res
                res.add(elem);
                
                // Update n and remove elem from nums2
                n--;
                nums2[targetIdx] = -1;
            }
        }
        
        // Add elements from ArrayList to an array
        int[] arr = new int[res.size()];
        for (int i=0; i<arr.length; i++) {
            arr[i] = res.get(i);
        }
        
        // Return array
        return arr;
    }
}
