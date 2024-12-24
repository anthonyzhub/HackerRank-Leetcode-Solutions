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

            // Check if 9 exist inside set
            if (!uniqueNums.contains(curNumber - 1)) {

                // From this idx, calculate longest subsequence
                // Does 9 + 1 exist? Does 9 + 2 exist? Etc.)
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
