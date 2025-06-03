// https://leetcode.com/problems/h-index-ii
/*
Time Complexity: O(log n) where n = length of citations. This solution involves using a binary search algorithm.

Space Complexity: O(1) because no additional dynamic memory was created.
*/
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int leftPtr = 0;
        int rightPtr = n - 1;

        while (leftPtr < rightPtr) {

            int midPtr = (int) (leftPtr + rightPtr) / 2;

            if (citations[midPtr] >= n - midPtr) {
                rightPtr = midPtr;
            } else {
                leftPtr = midPtr + 1;
            }
        }

        return citations[leftPtr] == 0 ? 0 : n - leftPtr;
    }
}
