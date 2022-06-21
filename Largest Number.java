// https://leetcode.com/problems/largest-number/

class CustomSort implements Comparator<String> {
    
    // OBJECTIVE: Create a class that inherits from Comparator type String and override comparison function
    
    @Override
    public int compare(String strA, String strB) {
        String outcome1 = strA + strB;
        String outcome2 = strB + strA;
        
        // NOTE: compareTo() compares outcome2 against outcome1 in lexicographical order
        return outcome2.compareTo(outcome1);
    }
}

class Solution {
    
    public void intToString(String[] numsStr, int[] nums) {
        
        // OBJECTIVE: Turn integer to string, then store it in numsStr
        for (int i=0; i<nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
    }
    
    public String arrayToString(String[] numsStr) {
        
        // OBJECTIVE: Convert array to string and return it
        
        // Create a StringBuilder
        StringBuilder ans = new StringBuilder();
        
        // Iterate array
        for (String letter: numsStr) {
            ans.append(letter);
        }
        
        return ans.toString();
    }
    
    public String largestNumber(int[] nums) {
        
        /*
        * OBJECTIVE: Return largest possible number as a string
        *
        * Time Complexity: O(n + nlogn) where n = length of nums. The map() will iterate the list and convert every element to a string. Although a
        *                   custom sorting algorithm is being used, the time complexity will still be O(n log n).
        *
        * Space Complexity: O(n) where n = length of return string. map() is overriding the input list, so it will still take the same amount of space.
        *                   However, a new string, with the same size as nums, is created and is the function's return value.
        */
        
        // Store integers as a string into a different array
        String[] numsStr = new String[nums.length];
        intToString(numsStr, nums);
        
        // Sort array in custom order
        Arrays.sort(numsStr, new CustomSort());
        
        // If first digit is a 0, return 0
        if (numsStr[0].equals("0")) {
            return "0";
        }
        
        // Return array as a string
        return arrayToString(numsStr);
    }
}
