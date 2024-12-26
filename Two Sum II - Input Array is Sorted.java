// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

/*
Time Complexity: O(n) where n = length of input array
Space Complexity: O(n) n = length of unique numbers in input array
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // IMPORTANT: Problem states that each input is guaranteed a solution,
        //  so this was hardcoded
        if (numbers.length == 2) {
            return new int[]{1, 2};
        }

        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            Integer number = Integer.valueOf(numbers[i]);

            if (complementMap.containsKey(number)) {
                return new int[]{i + 1, complementMap.get(number).intValue() + 1};
            }

            // IMPORTANT: For this to work, order of subtraction was important.
            // E.g., It works if target - number, not number - target because
            //  a key's original value can be overriden.
            Integer complement = Integer.valueOf(target) - number;
            complementMap.put(complement, Integer.valueOf(i));
        }

        return null;
    }
}
