// https://leetcode.com/problems/daily-temperatures/
// https://youtu.be/cTBiBSnjO3c?si=YLo26Zb0VJNE2DZ0

/*
Time Complexity: O(n) where n = length of temperatures. The for-loop iterates the entire array.

Space Complexity: O(n) where n = length of tempStack.
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) {
            return new int[]{0};
        }

        // Pair: (Temperature, Idx of temperature)
        Stack<Pair<Integer, Integer>> tempStack = new Stack<>();
        
        // Create a return array filled with 0s
        int[] result = new int[temperatures.length];
        Arrays.fill(result, 0);

        // Iterate array
        for (int i = 0; i < temperatures.length; i++) {

            // True, if stack isn't empty & current temperature is greater than stack's peek element
            while (!tempStack.empty() && temperatures[i] > tempStack.peek().getKey()) {
                
                // Pop last entry
                // NOTE: This will help check previous entries
                Pair<Integer, Integer> preTemperature = tempStack.pop();
                int pastTempIdx = preTemperature.getValue().intValue();

                // Calculate how many days it will take from past temperature entry to today for it to be hotter.
                int lengthInDays = i - pastTempIdx;
                result[pastTempIdx] = lengthInDays; // Why pastTempIdx? "answer[i] is the number of days you have to wait after the ith day to get a warmer temperature."
            }

            Integer idxAsInteger = Integer.valueOf(i);
            Integer tempAsInteger = Integer.valueOf(temperatures[i]);
            Pair<Integer, Integer> newEntry = new Pair<>(tempAsInteger, idxAsInteger);
            tempStack.push(newEntry);
        }

        return result;
    }
}
