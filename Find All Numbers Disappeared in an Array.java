// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
/*
Time Complexity: O(n) where n = length of nums.

Space Complexity: O(n) where n = length of nums + 1. 
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] actualArr = new int[nums.length + 1];

        // E.g., Move "12" to 12th index.
        for (int num: nums) {
            actualArr[num] = num;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < actualArr.length; i++) {

            // NOTE: Default value of int[] is 0.
            if (actualArr[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }
}
