// https://leetcode.com/problems/plus-one/
/*
Time Complexity: O(n) to O(2n) where n = length of digits. A 2nd iteration might be needed if carryOverDigit isn't equal to 0

Space Complexity: O(n) where n = length of output array. It could either be digits[] or result[]
*/

class Solution {
    public int[] plusOne(int[] digits) {

        // Iterate array in reverse order
        int carryOverDigit = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            
            // If digit is a 9, simply set ith index to 0 and update carryOverDigit
            // If not, update ith index and exit function
            if (digits[i] == 9) {
                digits[i] = 0;
                carryOverDigit = 1;
            } else {
                digits[i]++;
                return digits;
            }
        }

        // There is a possibility the loop ended without the carryOverDigit being applied.
        if (carryOverDigit != 0) {

            // Create a bigger array and insert carryOverDigit as the 1st value
            int[] result = new int[digits.length + 1];
            result[0] = carryOverDigit;

            // Copy rest of digits to new array
            for (int i = 0, j = 1; i < digits.length; i++) {
                result[j] = digits[i];
                j++;
            }

            return result;
        }

        return digits;
    }
}
