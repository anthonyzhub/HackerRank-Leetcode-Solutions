// https://leetcode.com/problems/asteroid-collision/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        /*
        
        Time Complexity: O(n) where n = length of asteroids. The list is iterated once and the stack's size won't be greater than it.
        
        Space Complexity: O(n) where n = length of stack. Worst case scenario is having all asteroids moving to the same direction.
        
        */
        
        // Create a stack
        Stack<Integer> res = new Stack<>();
        
        // Iterate asteroids array
        for (int curAsteroid: asteroids) {
            
            // If stack isn't empty, last added asteroid is going to the right, and curAsteroid is going to the left, then a collision will occur
            while (res.size() != 0 && res.peek() > 0 && curAsteroid < 0) {
                
                // Add the size of both asteroids: the last added asteroid and curAsteroid
                int diff = res.peek() + curAsteroid;
                
                // If diff is less than 0, then curAsteroid is bigger than the last added asteroid. Pop the last added asteroid
                if (diff < 0) {
                    res.pop();
                }
                
                // If diff is greater than 0, then the last added asteroid is bigger than curAsteroid
                else if (diff > 0) {
                    
                    // Set curAsteroid to 0 since input restricts astroids from having a size of 0
                    curAsteroid = 0;
                }
                
                // If diff equals to 0, then curAsteroid and the last added asteroid are the same size and exploded
                else {
                    curAsteroid = 0;
                    res.pop();
                }
            }
            
            // If curAsteroid isn't 0, then add it to stack
            if (curAsteroid != 0) {
                res.push(curAsteroid);
            }
        }
        
        // Convert stack to an array
        int[] resArr = new int[res.size()];
        for (int i=resArr.length-1; i > -1; i--) {
            resArr[i] = res.pop();
        }
        
        return resArr;
    }
}
