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
        Map<Character, Character> matchingPairsMap = Map.of(
            '}', '{',
            ']', '[',
            ')', '('
        );

        // Create a stack
        Stack<Character> visitedElems = new Stack<>();

        // Iterate string
        for (int i = 0; i < s.length(); i++) {

            Character curCharacter = Character.valueOf(s.charAt(i));
            
            // Check if c is a closing character
            if (matchingPairsMap.containsKey(curCharacter)) {

                // If stack isn't empty AND stack head is a matching pair with curCharacter, pop stack head.
                // If not, return false because the string doesn't have a valid parentheses
                if (!visitedElems.empty() && visitedElems.peek() == matchingPairsMap.get(curCharacter)) {
                    visitedElems.pop();
                }
                else {
                    return false;
                }
            }
            else { // If curCharacter is another opening character, add it to stack
                visitedElems.push(curCharacter);
            }
        }

        // If stack is empty, then string had valid parentheses. If not, return false
        return visitedElems.empty();
    }
}
