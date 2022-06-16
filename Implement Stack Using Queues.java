// https://leetcode.com/problems/implement-stack-using-queues/

import java.util.*;

class MyStack {

    LinkedList<Integer> queue;
    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        queue.push(x);
    }
    
    public int pop() {
        return queue.pop();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
