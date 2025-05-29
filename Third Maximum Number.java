// https://leetcode.com/problems/third-maximum-number/
/*
Time Complexity: O(n) where n = length of nums.

Space Complexity: O(n) where n = length of uniqueNums.
*/

class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Set<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            uniqueNums.add(Integer.valueOf(nums[i]));
        }

        List<Integer> res = new ArrayList<>();
        Iterator<Integer> it = uniqueNums.iterator();

        while (it.hasNext()) {
            res.add(it.next());
        }

        Collections.sort(res);

        return res.size() >= 3 ? res.get(res.size() - 3) : res.get(res.size() - 1);
    }
}
