// https://leetcode.com/problems/evaluate-reverse-polish-notation/
// https://youtu.be/iu0082c4HDE?si=Qf4o-TxZhNRzZz3v

/*
Time Complexity: O(n) where n = length of tokens.
Space Complexity: O(n) where n = length of stack.
*/

class Solution {

    private Integer performOperation(Stack<Integer> numberStack, String operator) {
        
        // IMPORTANT: Order matters here. 2nd number is popped first because we're doing based on insertion.
        //  A stack uses FILO, so the top number is the 2nd number.
        //
        //  Also, problem states that input array will always carry a valid expression, so I don't need to 
        //  worry if stack actually has 1 number instead of 2.
        Integer secondNum = numberStack.pop();
        Integer firstNum = numberStack.pop();
        
        if (operator.equals("+")) {
            return firstNum + secondNum;
        }
        else if (operator.equals("-")) {
            return firstNum - secondNum;
        }
        else if (operator.equals("*")) {
            return firstNum * secondNum;
        }
        else {
            return Integer.valueOf((int) firstNum / secondNum);
        }
    }

    public int evalRPN(String[] tokens) {
        Set<String> validOperators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> numberStack = new Stack<>();

        for (String elem: tokens) {

            if (validOperators.contains(elem)) {
                Integer result = performOperation(numberStack, elem);
                numberStack.push(result);
            }
            else {
                numberStack.push(Integer.valueOf(elem));
            }
        }

        return numberStack.peek().intValue();
    }
}
