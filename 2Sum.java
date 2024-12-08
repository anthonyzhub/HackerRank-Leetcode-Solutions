// https://leetcode.com/problems/two-sum/
// https://youtu.be/KLlXCFG5TnA?si=oLf1UDpoxwg9AA9w

/*
Time Complexity: O(n) where n = length of nums
Space Complexity: O(m) where m = size of hash map
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int curElem = nums[i];
            if (complements.containsKey(curElem)) {
                int first_idx = complements.get(curElem).intValue();
                return new int[]{first_idx, i};
            }

            Integer remainder = Integer.valueOf(target - curElem);
            complements.put(remainder, Integer.valueOf(i));
        }

        // IMPORTANT: Problem said that there's a guaranteed answer per input
        //  and I needed to return something because of function's declaration,
        //  so this was added to silent error.
        return null;
    }
}
