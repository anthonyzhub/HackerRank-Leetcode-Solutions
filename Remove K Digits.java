// https://leetcode.com/problems/remove-k-digits/

class Solution {
    public String removeKdigits(String num, int k) {
        
        // If string's length is greater than or equal to K, exit function
        if (num.length() <= k) {return "0";}
        
        // Create a stack
        Stack<Character> charStack = new Stack();
        
        // Iterate num as a character array
        for (char curChar: num.toCharArray()) {
            
            // While stack isn't empty, K isn't 0, and stack's head is greater than curChar, pop tail element and subtract k
            // NOTE: "K" signifies how many more digits are left for me to take out
            while (!charStack.isEmpty() && k > 0 && charStack.peek() > curChar) {
                charStack.pop();
                k--;
            }
            
            // Add curChar to stack
            // NOTE: curChar will be added to stack on first run
            charStack.push(curChar);
        }
        
        // Continue to remove all K elements from stack
        while (!charStack.isEmpty() && k > 0) {
            charStack.pop();
            k--;
        }
        
        // Create a new string
        StringBuilder answer = new StringBuilder();
        
        // Add all characters from stack to string
        while (!charStack.isEmpty()) {
            answer.append(charStack.pop());
        }
        
        // Reverse string since characters came from a stack
        // NOTE: Stack follows FILO (first in, last out)
        answer.reverse();
        
        // Remove leading 0's
        // NOTE: Without first condition, program will crash. E.g., num=10 and k=1. Correct output is 0.
        while (answer.length() > 1 && answer.charAt(0) == '0') {
            answer.deleteCharAt(0);
        }
        
        // Return answer as string
        return answer.toString();
    }
}
