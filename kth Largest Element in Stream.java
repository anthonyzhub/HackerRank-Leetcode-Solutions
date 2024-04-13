// https://leetcode.com/problems/kth-largest-element-in-a-stream/

class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {

        /*
         * Time Complexity: O(n * logn) where n = number of elements inside the array. In the initializer,
         *  all the array elements are being pushed to the tree. If heap size exceeds k, then the elements
         *  are popped from the heap, which also takes O(log n) times.
         * 
         * Space Complexity: O(n) where n = number of nodes inside the heap.
         */

        this.k = k;
        this.minHeap = new PriorityQueue<>();

        // Move all elements from nums to heap
        for (int i: nums) {
            minHeap.add(Integer.valueOf(i));
        }

        // Only keep k elements inside heap
        // NOTE: You don't need any excessive elements because they won't be used
        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    public int add(int val) {

        /*
         * Time Complexity: O(log n) where n = number of nodes inside heap. A heap's insertion property
         *  takes O(log n) on average. That is with all heaps.
         * 
         * Space Complexity: O(1) because you're only creating one additional node and appending it to
         *  the tree.
         */

        // Add element to heap
        minHeap.add(Integer.valueOf(val));

        // If heap size exceeds k elements, pop head
        // NOTE: There is a scenario where initializer will pass an array that has a size smaller than k
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */