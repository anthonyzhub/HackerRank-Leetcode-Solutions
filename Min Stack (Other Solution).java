// https://leetcode.com/problems/min-stack/

/*
Time Complexity: O(1) because of stack operations.
Space Complexity: O(n) where n = length of mainStack.

IMPORTANT:
I created this solution after reading the hint and because Neetcode's solution wasn't efficient imo. Although Neetcode's solution did work, I didn't like how minStack would insert duplicate numbers. I found that redundant, so I implemented a solution 
based on the hint.

The hint mentioned to create a node. Immediately, I thought how a node can hold 2 values - recently inserted data and a record of the smallest number inside the stack. Each node will hold the smallest number from its position to the bottom of the 
stack. If the newly inserted value is the newest smallest, that's fine because if that node ever gets popped, the next node will hold the next smallest number. This approach still guarantees a O(1) time complexity.
*/

class Node {
    public Integer val;
    public Integer minVal; // <= Every node will hold the smallest value of the entire stack. At least from it's position to the bottom.
}

class MinStack {

    private Stack<Node> mainStack;

    public MinStack() {
        this.mainStack = new Stack<>();
    }
    
    public void push(int val) {
        Integer valAsInt = Integer.valueOf(val);
        Node newNode = new Node();
        newNode.val = valAsInt;

        if (mainStack.empty()) {
            newNode.minVal = valAsInt;
        }
        else {
            Node stackHead = mainStack.peek();
            newNode.minVal = Math.min(valAsInt, stackHead.minVal);
        }

        mainStack.push(newNode);
    }
    
    public void pop() {
        mainStack.pop();
    }
    
    public int top() {
        Node stackHead = mainStack.peek();
        return stackHead.val.intValue();
    }
    
    public int getMin() {
        Node stackHead = mainStack.peek();
        return stackHead.minVal.intValue();
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
