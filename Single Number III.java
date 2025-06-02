// https://leetcode.com/problems/single-number-iii
/*
Time Complexity: O(n) where n = length of nums.

Space Complexity: O(n) where n = the number of unique elements inside nums. Although the problem
    says to solve with constant memory, there will never be a case where frequency map will be
    bigger than nums.
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num: nums) {
            if (frequency.containsKey(num)) {
                frequency.put(num, frequency.get(num) + 1);
            } else {
                frequency.put(num, 1);
            }
        }

        int[] res = new int[2];
        boolean firstEntryMade = false;
        for (Map.Entry<Integer, Integer> entry: frequency.entrySet()) {
            if (entry.getValue() == 1) {
                if (!firstEntryMade) {
                    res[0] = entry.getKey();
                    firstEntryMade = true;
                } else {
                    res[1] = entry.getKey();
                    break;
                }
            }
        }

        return res;
    }
}
