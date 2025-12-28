// https://leetcode.com/problems/minimum-window-substring/
// https://www.youtube.com/watch?v=jSto0O4AJbM

/*
Time Complexity: O(n + m) where n = length of both strings and m = number of unique characters in each string.
Space Complexity: O(m) where m = number of unique characters in each string.
*/

class Solution {
    public String minWindow(String s, String t) {
        
        // Edge case
        if (t.isEmpty()) {
            return t;
        }

        // Create a map to keep track of letter frequencies
        // IMPORTANT: The windowMap will only hold letters that exist in tMap
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // Populate map for t-string
        for (int i = 0; i < t.length(); i++) {
            Character letter = Character.valueOf(t.charAt(i));
            tMap.put(letter, tMap.getOrDefault(letter, 0) + 1);
        }

        // These counters represent the size of each map
        // haveCounter = size of windowMap. 
        // needCounter = size of tMap.
        int haveCounter = 0;
        int needCounter = tMap.size();

        // Create a return variables.
        // result[] will be used to hold left and right pointers in future sliding window
        int[] result = new int[]{-1, -1};
        int resultLen = Integer.MAX_VALUE;

        // Create left and right pointer, then iterate s-string
        int leftPtr = 0;
        int rightPtr = 0;
        for (; rightPtr < s.length(); rightPtr++) {

            // Get character at rightPtr index and add it to windowMap
            Character letterAtRightPtr = Character.valueOf(s.charAt(rightPtr));
            windowMap.put(letterAtRightPtr, windowMap.getOrDefault(letterAtRightPtr, 0) + 1);

            // If this letter exist in tMap and has the same frequency, update haveCounter
            if (tMap.containsKey(letterAtRightPtr) && windowMap.get(letterAtRightPtr).equals(tMap.get(letterAtRightPtr))) {
                haveCounter++;
            }

            // While needCounter == haveCounter, check if the current sliding window can be smaller.
            // If so, that would be great.
            while (haveCounter == needCounter) {

                // If current sliding window is smaller than previously recorded, update return variables
                if ((rightPtr - leftPtr + 1) < resultLen) {
                    result[0] = leftPtr;
                    result[1] = rightPtr;

                    resultLen = rightPtr - leftPtr + 1; // NOTE: We start counting at 0
                }             
                
                // Update windowMap with dropped letter, then update haveCounter
                Character letterAtLeftPtr = Character.valueOf(s.charAt(leftPtr));
                windowMap.put(letterAtLeftPtr, windowMap.get(letterAtLeftPtr) - 1);
                if (tMap.containsKey(letterAtLeftPtr) && windowMap.get(letterAtLeftPtr) < tMap.get(letterAtLeftPtr)) {
                    haveCounter--;
                }

                // Move leftPtr to make current sliding window smaller
                leftPtr++;
            }
        }

        // If resultLen did change from its original value, then a substring was found.
        if (resultLen != Integer.MAX_VALUE) {
            leftPtr = result[0];
            rightPtr = result[1];
            return s.substring(leftPtr, rightPtr + 1);
        }

        return "";
    }
}
