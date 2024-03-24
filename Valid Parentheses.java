// https://leetcode.com/problems/valid-parentheses/
// https://www.youtube.com/watch?v=WTzjTskDFMg&t=316

class Solution {
    public boolean isValid(String s) {

        /*
         * Time Complexity: O(n) where n = length of input string. String will be iterated
         *  and worse case is that it's long and has a valid parentheses.
         * 
         * Space Complexity: O(n) where n = length of stack. Stack height is based of string's
         *  length. Also, although hash map was created, it size isn't dynamic, which is why
         *  it didn't influence the space complexity.
         */
        
        // Create a hash map
        Map<Character, Character> closingCharacters = new HashMap<>(Map.of(
            '}', '{',
            ']', '[',
            ')', '('
        ));

        // Create a stack
        Stack<Character> mainStack = new Stack<>();

        // Iterate string
        for (int i = 0; i < s.length(); i++) {

            Character c = Character.valueOf(s.charAt(i));
            
            // Check if c is a closing character
            if (closingCharacters.containsKey(c)) {

                // If stack isn't empty AND stack head is a matching pair with c, pop stack head.
                // If not, return false because the string doesn't have a valid parentheses
                if (!mainStack.empty() && mainStack.peek() == closingCharacters.get(c)) {
                    mainStack.pop();
                }
                else {
                    return false;
                }
            }
            else { // If c is another opening character, add it to stack
                mainStack.push(c);
            }
        }

        // If stack is empty, then string had valid parentheses. If not, return false
        return mainStack.empty();
    }
}