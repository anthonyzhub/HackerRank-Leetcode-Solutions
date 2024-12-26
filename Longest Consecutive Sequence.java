// https://leetcode.com/problems/longest-consecutive-sequence/
// https://youtu.be/P6RZZMu_maU?si=iS0FHXzS7ax7ZA3p

/*
Time Complexity: O(n) where n = length of input array.
Space Complexity: O(n) where n = length of set.
*/

class Solution {

    private Set<Integer> generateSetFromArray(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();

        for (int number: nums) {
            uniqueNums.add(Integer.valueOf(number));
        }

        return uniqueNums;
    }

    private int calculateLongestSubsequence(Set<Integer> uniqueNums) {
        
        int longestLength = 0;

        // E.g., Assume curNumber is 10
        for (Integer curNumber: uniqueNums) {

            // Check that 9 doesn't exist inside set.
            // Why? Because we don't want to count a sequence twice. We should just go through the sequence in its entirety.
            if (!uniqueNums.contains(curNumber - 1)) {

                // From this idx, calculate longest subsequence
                // Does 10 + 1 exist? Does 10 + 2 exist? Etc.)
                int curLength = 0;
                while (uniqueNums.contains(curNumber + curLength)) {
                    curLength++;
                }

                // Update to the largest number
                longestLength = Math.max(longestLength, curLength);
            }
        }

        return longestLength;
    }

    public int longestConsecutive(int[] nums) {
        
        if (nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> uniqueNums = generateSetFromArray(nums);

        int longestLength = calculateLongestSubsequence(uniqueNums);
        return longestLength;
    }
}
