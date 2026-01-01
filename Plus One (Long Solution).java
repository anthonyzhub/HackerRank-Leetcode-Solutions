// https://leetcode.com/problems/plus-one/
/*
Time Complexity: O(n) to O(2n) where n = length of digits. A 2nd iteration might be needed if carryOverDigit isn't equal to 0

Space Complexity: O(n) where n = length of output array. It could either be digits[] or result[]

Thought Process:
- If digits is [0], immediately return 1
- Iterate digits in reverse order
- add 1 and see if another digit needs to be carried over
- Apply carry over digit and continue until (a) no more digit is carried
    or (b) you reached the beginning of the array
- If you reached the beginning and there exist a carried over digit, create a new array of digits.length + 1
- Insert carried digit at beginning of new array
- Return new array
- If you reached the beginning and no carried over digit exist, return existing array
*/

class Solution {
    public int[] plusOne(int[] digits) {

        // If digits only has 1 digit that is less than 9, simply increment value and return it
        if (digits.length == 1 && digits[0] < 9) {
            digits[0]++;
            return digits;
        }

        // Create a variable to carry over a digit throughout iteration
        int carryOverDigit = 0;

        // Iterate array in reverse order
        for (int i = digits.length - 1; i >= 0; i--) {
            
            // E.g., 1,234 + 1 = 1,235
            if (carryOverDigit == 0 && digits[i] + 1 <= 9) {
                digits[i]++;
                return digits;
            } else if (carryOverDigit == 0) { // E.g., 9 + 1 = 10.
                digits[i] = 0;
                carryOverDigit = 1;
            } else {

                // IMPORTANT: The problem statement says to increment the whole number as 1.
                //  That means, if the loop is continuing it's because carryOverDigit isn't 0.
                //  Also, carryOverDigit will only hold 0-1.
                int newNumber = digits[i] + carryOverDigit;

                if (newNumber <= 9) {
                    digits[i] = newNumber;
                    return digits;
                } else {

                    // IMPORTANT: Without x - '0', the ascii value will be returned.
                    //  E.g., '1' - '0' = 1 as int BUT '1' = 49 as int
                    String newNumAsStr = String.valueOf(newNumber);
                    digits[i] = (int) newNumAsStr.charAt(1) - '0';
                    carryOverDigit = (int) newNumAsStr.charAt(0) - '0';
                }
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
