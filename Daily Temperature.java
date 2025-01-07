// https://leetcode.com/problems/daily-temperatures/
// https://youtu.be/cTBiBSnjO3c?si=83SNP0LT1tt30kro

/*
Time Complexity: O(n) where n = length of temperatures
Space Complexity: O(n) where n = length of stack
*/

class Node {
    int val;
    int idx;
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);

        Stack<Node> tmpStack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            Node newNode = new Node();
            newNode.val = temperatures[i];
            newNode.idx = i;

            // If stack isn't empty and top of stack's temperature is less than ith day's weather, 
            //  pop stack and update return array at head's index
            while (!tmpStack.empty() && newNode.val > tmpStack.peek().val) {
                Node head = tmpStack.pop();
                res[head.idx] = i - head.idx;
            }

            tmpStack.push(newNode);
        }

        return res;
    }
}
