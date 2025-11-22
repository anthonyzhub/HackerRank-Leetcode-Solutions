// https://leetcode.com/problems/min-stack/
// https://youtu.be/qkLl7nAwDPo?si=_Z5hYCZI4qnlr7dI

/*
Time Complexity: O(1) for all operations because all stack operations guarantees O(1) time
Space Complexity: O(n) where n = size of mainStack and minStack (whichever is the largest).
*/

class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> minTrackerStack;

    public MinStack() {
        this.mainStack = new Stack<>();
        this.minTrackerStack = new Stack<>();
    }
    
    public void push(int val) {
        Integer valInteger = Integer.valueOf(val);

        if (mainStack.empty()) {
            mainStack.push(valInteger);
            minTrackerStack.push(valInteger);
        } else {
            mainStack.push(valInteger);

            Integer trackerPeekElem = minTrackerStack.peek();
            Integer smallestValue = valInteger > trackerPeekElem ? trackerPeekElem : valInteger;
            minTrackerStack.push(smallestValue);
        }
    }
    
    public void pop() {
        mainStack.pop();
        minTrackerStack.pop();
    }
    
    public int top() {
        return mainStack.peek().intValue();
    }
    
    public int getMin() {
        return minTrackerStack.peek().intValue();
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
