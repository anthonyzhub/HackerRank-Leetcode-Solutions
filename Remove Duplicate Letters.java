// https://leetcode.com/problems/remove-duplicate-letters/

class Solution {
    public String removeDuplicateLetters(String s) {
        
        // If string is empty or only has 1 letter, return it
        if (s == null || s.length() <= 1) {return s;}
        
        // Convert string to char array
        char[] sArray = s.toCharArray();
        
        // Create a HashMap to hold every letter and its last recorded index
        HashMap<Character, Integer> last_occurrence = new HashMap<Character, Integer>();
        
        // Create a stack and a set to hold characters
        Stack<Character> stack = new Stack<Character>();
        HashSet<Character> visited = new HashSet<Character>();
        
        // Traverse char array and add letter with its last recorded position to hash map
        for (int i=0; i<sArray.length; i++) {
            last_occurrence.put(sArray[i], i);
        }
        
        // Traverse char array and add current letter in stack in lexicographical order
        for (int i=0; i<sArray.length; i++) {
            
            // If s[i] wasn't visited before, add it
            if (!visited.contains(sArray[i])) {
                
                // Before adding new letter, go through stack and pop any elements that is greater than s[i]
                // NOTE: stack.peek() returns value of head element inside of stack.
                while (stack.size() != 0 && stack.peek() > sArray[i] && last_occurrence.get(stack.peek()) > i) {
                    visited.remove(stack.pop());
                }
                
                // Add new letter to stack and visited
                stack.push(sArray[i]);
                visited.add(sArray[i]);
            }
        }
        
        // Return stack as a string
        StringBuilder ans = new StringBuilder();
        for (char letter: stack) {ans.append(letter);}
        return ans.toString();
    }
}
