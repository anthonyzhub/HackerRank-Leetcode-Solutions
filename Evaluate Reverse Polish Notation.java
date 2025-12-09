// https://leetcode.com/problems/evaluate-reverse-polish-notation/
// https://youtu.be/iu0082c4HDE?si=Qf4o-TxZhNRzZz3v

/*
Time Complexity: O(n) where n = length of tokens.
Space Complexity: O(n) where n = length of stack.
*/

class Solution {

    private Integer performOperation(Integer topNumber, Integer bottomNumber, String operation) {

        // IMPORTANT: Order matters here. 2nd number is popped first because we're doing based on insertion.
        //  A stack uses FILO, so the top number is the 2nd number.
        //
        //  Also, problem states that input array will always carry a valid expression, so I don't need to 
        //  worry if stack actually has 1 number instead of 2.

        if (operation.equals("+")) {
            return bottomNumber + topNumber;
        
        } else if (operation.equals("-")) {
            return bottomNumber - topNumber;
        
        } else if (operation.equals("*")) {
            return bottomNumber * topNumber;
        
        } else if (operation.equals("/")) {
            return Integer.valueOf(bottomNumber / topNumber);
        }

        return Integer.valueOf(1);
    }

    public int evalRPN(String[] tokens) {
        Set<String> validOperations = Set.of("+", "-", "*", "/");
        Stack<Integer> numberStack = new Stack<>();

        for (String elem: tokens) {

            if (!validOperations.contains(elem)) {
                numberStack.push(Integer.parseInt(elem));
            } else {
                Integer topNumber = numberStack.pop();
                Integer bottomNumber = numberStack.pop();

                Integer result = performOperation(topNumber, bottomNumber, elem);

                numberStack.push(result);
            }
        }

        return numberStack.peek().intValue();
    }
}
