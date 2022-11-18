// https://leetcode.com/problems/climbing-stairs/

class Solution {
    public int climbStairs(int n) {
        
        /*
        OBJECTIVE: You are climbing a staircase. It takes n steps to reach the top. Each time you can either
                    climb 1 or 2 steps. In how many distinct ways can you climb to the top?
        
        Time Complexity: O(n) where n = the input n. The for-loop is iterating from n - 2 times. The " - 2" is
                        dropped because it is a constant.
        
        Space Complexity: O(n) where n = the size of stairs' list. The list will hold n elements.
        */
        
        // Create an array
        List<Integer> stairs = new ArrayList<>();
        
        // Add hard-written values for step 1 and 2
        stairs.add(1);
        stairs.add(2);
        
        // Iterate range
        // NOTE: I started at 2 because the first 2 were already calculated by me
        for (int i = 2; i < n; i++) {
            stairs.add(stairs.get(i - 2) + stairs.get(i - 1));
        }
        
        return stairs.get(n - 1);
    }
}
