// https://leetcode.com/problems/last-stone-weight/

class Solution {

    private void smashStones(PriorityQueue<Integer> maxHeap) {

        // Remember, objective is to return at most 1 stone
        if (maxHeap.size() <= 1) {
            return;
        }

        // Get the 2 heaviest stones
        // IMPORTANT: Order matters here! This is a max heap, so the head element
        //  will always be the largest of the entire tree and the description states
        //  that y element should be greater than or equal to x.
        Integer yStone = maxHeap.poll();
        Integer xStone = maxHeap.poll();

        // If both stones weigh the same, move to the remaining stones
        // If not, smash them, collect the difference, add it to heap, and move to remaining stones.
        if (xStone == yStone) {
            smashStones(maxHeap);
        }
        else {
            maxHeap.add(yStone - xStone);
            smashStones(maxHeap);
        }
    }

    public int lastStoneWeight(int[] stones) {

        /*
         * Time Complexity: O(n * logn) where n = number of nodes inside the heap. All the elements from
         *  stones list is passed to a max heap. smashStones() is called for every node until there's 1 or
         *  none left and each method call features a poll() call, which takes O(log n) time.
         * 
         * Space Complexity: O(n) where n = number of nodes inside the heap. In lastStoneWeight(), a heap
         *  is being constructed which takes O(n) space. Afterwards, the heap is being passed to smashStones()
         *  which is called for every element and also takes O(n). Therefore, the answer is O(n).
         */
        
        // Turn array to max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones) {
            maxHeap.add(stone);
        }

        smashStones(maxHeap);
        return maxHeap.size() != 0 ? maxHeap.peek(): 0;
    }
}