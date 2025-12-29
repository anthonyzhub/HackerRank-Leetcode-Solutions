// https://leetcode.com/problems/sliding-window-maximum/
// https://youtu.be/DfljaUwZsOk?si=B8gqsudQB5pC9kdA
/*
Time Complexity: O(n) where n = length of nums.

Space Complexity: O(n) where n = length of deque
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        // Create a queue
        // NOTE: This queue will act as a monotonic decreasing queue (e.g., 10, 9, etc.)
        Deque<Integer> indexDeque = new ArrayDeque<>();
        int leftPtr = 0, rightPtr = 0;

        while (rightPtr < nums.length) {

            // Pop small values from deque until condition isn't met, then add new value
            while (!indexDeque.isEmpty() && nums[indexDeque.getLast()] < nums[rightPtr]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(rightPtr); // Add index of larger element to deque

            // If leftPtr is out of bounds, pop left-most element from deque
            if (leftPtr > indexDeque.getFirst()) {
                indexDeque.removeFirst();
            }

            // If current sliding window is too big, get the left-most element from window and put it in result.
            // Also, move leftPtr
            if (rightPtr + 1 >= k) {
                int maxNum = nums[indexDeque.getFirst()];
                result.add(maxNum);

                leftPtr++;
            }

            rightPtr++;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
