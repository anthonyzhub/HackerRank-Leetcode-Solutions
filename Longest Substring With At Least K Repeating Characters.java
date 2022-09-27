// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

class Solution {
    
    public int getUniqueLetters(String s) {
        
        // OBJECTIVE: Return the number of unique letters in s
        
        // Create a boolean array
        boolean[] letters = new boolean[26];
        
        // Create a variable to hold number of unique letters
        int uniqueLetters = 0;
        
        // Iterate string
        for (int i=0; i<s.length(); i++) {
            
            // If element at index is false, set it to true and increment counter
            // I.e., Set element to true indicating that we came across this letter
            if (!letters[s.charAt(i) - 'a']) {
                uniqueLetters++;
                letters[s.charAt(i) - 'a'] = true;
            }
        }
        
        return uniqueLetters;
    }
    
    public int longestSubstring(String s, int k) {
        
        // Convert string to char array
        char[] str = s.toCharArray();
        
        // Create an array where each index represents a character and its frequency
        // E.g., a = 12, b = 3, c = 64, etc.
        int[] countMap = new int[26];
        
        // Count how many unique letters there are in s
        int maxUnique = getUniqueLetters(s);
        
        // Hold ouput
        int res = 0;
        
        // Adjust window size
        for (int curUnique = 1; curUnique <= maxUnique; curUnique++) {
            
            // Reset array
            Arrays.fill(countMap, 0);
            
            // Set window dimensions
            int windowStart = 0;
            int windowEnd = 0;
            
            // Set index, number of unique letters, and how many subsequences appear k times
            int idx = 0;
            int unique = 0;
            int countAtLeastK = 0;
            
            // Move window and find a subsequence that doesn't appear more than curUnique times
            while (windowEnd < str.length) {
                
                // Expand sliding window
                if (unique <= curUnique) {
                    
                    // Calculate index
                    idx = str[windowEnd] - 'a';
                    
                    // If element equals to 0, increment unique counter because this is the 1st time we see this letter
                    if (countMap[idx] == 0) {unique++;}
                    
                    // Increment the number of occurrences this letter has appeared
                    countMap[idx]++;
                    
                    // If sequence appears at least k times, update k counter
                    if (countMap[idx] == k) countAtLeastK++;
                    
                    // Make window bigger
                    windowEnd++;
                }
                
                // Shrink sliding window
                else {
                    
                    // Calculate index
                    idx = str[windowStart] - 'a';
                    
                    // If letter appeared at least k times, decrement k counter
                    if (countMap[idx] == k) {countAtLeastK--;}
                    
                    // Decrement the number of occurrences this letter has appeared
                    countMap[idx]--;
                    
                    // If letter's frequency is 0, decrement unique counter
                    if (countMap[idx] == 0) {unique--;}
                    
                    // Shrink window
                    windowStart++;
                }
                
                if (unique == curUnique && unique == countAtLeastK) {
                    res = Math.max(windowEnd - windowStart, res);
                }
            }
        }
        return res;
    }
}
