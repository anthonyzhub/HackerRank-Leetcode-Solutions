/*
https://leetcode.com/problems/merge-intervals/

Thought Process:
- If matrix only has 1 subarray, return matrix
- Sort matrix by 1st element of each subarray
- Create an ArrayList that will hold all non-overlapping intervals and add first element of intervals
- Iterate intervals
- FOr every iteration
    - check if 1st digit falls in range between last entry in arraylist. I.e., start <= cur element <= end
    - if 1st digit falls within range, merge both intervals and update arraylist
    - if 1st digit doesn't fall within range, add new entry to array list
    - repeat above steps throughout entire matrix
- return arraylist as an array
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        // Sort matrix by 1st element of each subarray
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Create a list to hold all merged intervals
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(new int[]{intervals[0][0], intervals[0][1]});

        // Iterate intervals matrix
        for (int i = 1; i < intervals.length; i++) {

            // Get last merged interval and current subarray
            int[] lastMergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            int[] curSubArray = intervals[i];

            // Update lastMergedInterval if 1st element from curSubArray falls within range. If not, add subarray to list
            if (lastMergedInterval[0] <= curSubArray[0] && curSubArray[0] <= lastMergedInterval[1]) {
                lastMergedInterval[0] = Math.min(lastMergedInterval[0], curSubArray[0]);
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], curSubArray[1]);
            } else {
                mergedIntervals.add(new int[]{curSubArray[0], curSubArray[1]});
            }
        }

        // Turn list into a int[][]
        int[][] res = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            int[] lastEntry = mergedIntervals.get(i);
            res[i] = lastEntry;
        }
        
        return res;
    }
}
