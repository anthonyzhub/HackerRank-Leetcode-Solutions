// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        // Get length of arrays
        int m = nums1.length;
        int n = nums2.length;
        
        // Create a priority queue
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        // Add all combinations of nums1[0] with all nums2' elements, then add them to priority queue
        for (int i=0; i<m && i < k; i++) {
            minHeap.add(new int[]{nums1[i], nums2[0], 0});
        }
        
        // Create a return list
        List<List<Integer>> res = new ArrayList<>();
        
        // Iterate heap and k range
        for (int i=0; i < k && !minHeap.isEmpty(); i++) {
            
            // Pop 1st element from minHeap
            int[] cur = minHeap.poll();
            
            // Add index pair to res
            res.add(List.of(cur[0], cur[1]));
            
            // Get index of nums2
            int idxB = cur[2];
            
            // If idxB + 1 doesn't go out of bounds, add potential index pair to heap
            if (idxB < n - 1) {
                minHeap.add(new int[]{cur[0], nums2[idxB + 1], idxB + 1});
            }
        }
        
        return res;
    }
}
