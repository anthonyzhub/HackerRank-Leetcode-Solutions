// https://leetcode.com/problems/min-stack/
// https://youtu.be/qkLl7nAwDPo?si=_Z5hYCZI4qnlr7dI

/*
Time Complexity: O(1) for all operations because all stack operations guarantees O(1) time
Space Complexity: O(n) where n = size of mainStack and minStack (whichever is the largest).
*/

class MinStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        Integer valAsInt = Integer.valueOf(val);
        mainStack.push(valAsInt);
        valAsInt = Math.min(valAsInt, !minStack.empty() ? minStack.peek() : valAsInt);
        minStack.push(valAsInt);
    }
    
    public void pop() {
        mainStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
