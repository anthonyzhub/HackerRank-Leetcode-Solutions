// https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/
// https://youtu.be/DMBWjfh33wY?si=U51X1UUFE_S7M-No

class Solution {
    public long[] sumOfThree(long num) {

        /*
        Because question is asking for 3 consecutive numbers, the input number should be divisible by 3.
        */
        if (num % 3 != 0) {
            return new long[]{};
        }

        long midPtr = num / 3;
        return new long[]{midPtr - 1, midPtr, midPtr + 1};
    }
}
