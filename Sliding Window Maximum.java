// https://leetcode.com/problems/sliding-window-maximum/
// https://youtu.be/DfljaUwZsOk?si=B8gqsudQB5pC9kdA

/*
Time Complexity: O(K * (K - N)) where K = input value and N = length of nums. The program iterates the entire input array until the K-sized sliding window goes out of bounds.

Space Complexity: O(K) where K = length of result array. There is a possibility of the size of result array and idxQueue are the same. 
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        Deque<Integer> idxQueue = new ArrayDeque<>();
        int leftPtr = 0;
        int rightPtr = 0;

        while (rightPtr < nums.length) {

            // Pop smaller elements from queue
            while (!idxQueue.isEmpty() && nums[idxQueue.getLast()] < nums[rightPtr]) {
                idxQueue.removeLast();
            }
            idxQueue.addLast(rightPtr);

            // Remove leftmost element from sliding window
            if (leftPtr > idxQueue.getFirst()) {
                idxQueue.removeFirst();
            }

            // Add elements to sliding window until its k-size
            if (rightPtr + 1 >= k) {
                result.add(nums[idxQueue.getFirst()]);
                leftPtr++;
            }
            rightPtr++;
        }

        // Transform List<Integer> to int[] and return it
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
