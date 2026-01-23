// https://leetcode.com/problems/koko-eating-bananas/
// https://youtu.be/U2SozAs9RzA?si=tgbHAiCeX131lXB_
/*
Time Complexity: O(log(m) * m) where m = maximum element inside given array. The goal is for Koko to eat all the piles of bananas.
    It's assumed that there is a valid answer per case. Therefore, it's possible that the highest value is also the rate Koko must
    follow to eat all the bananas. 

    However, Koko wants to savor the bananas, so we need to find out how slow she can eat while eating all the bananas. That is why
    we perform a binary search from 1 bananas to m bananas. We adjust the bananas-per-hour (bph) in every binary search iteration.

Space Complexity: O(1)
*/
class Solution {

    private int getMaximumValue(int[] inputArray) {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > result) {
                result = inputArray[i];
            }
        }

        return result;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        // Pointers will be used to define k (bananas per hour)
        int leftPtr = 1;
        int rightPtr = getMaximumValue(piles);

        // Create a return variable for later use
        // NOTE: We know for a fact that h >= len(piles) && Koko is able to eat an entire pile in 1 hour
        int result = rightPtr;

        // Perform binary search on k
        while (leftPtr <= rightPtr) {

            // Define a potential k value
            int k = leftPtr + ((rightPtr - leftPtr) / 2);
            int hours = 0;

            // Iterate pile and figure out how many hours it will take to finish everything
            for (int i = 0; i < piles.length; i++) {

                // NOTE: When 2 integers divide, the output is already being rounded. Here, we always want to round up.
                hours += Math.ceil((double) piles[i] / k);
            }

            // If quota was met, check if Koko can eat even slower (i.e. savor the flavor)
            // If not, she has to eat faster
            if (hours <= h) {
                result = Math.min(result, k);
                rightPtr = k - 1;
            } else {
                leftPtr = k + 1;
            }
        }

        return result;
    }
}
