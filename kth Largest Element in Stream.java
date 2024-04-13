// https://leetcode.com/problems/kth-largest-element-in-a-stream/

class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        // Move all elements from nums to heap
        for (int i: nums) {
            minHeap.add(Integer.valueOf(i));
        }

        // Only keep k elements inside heap
        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.add(Integer.valueOf(val));
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