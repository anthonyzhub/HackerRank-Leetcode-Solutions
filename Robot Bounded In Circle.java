// https://leetcode.com/problems/robot-bounded-in-circle/

/*
 * Breakdown of the for-loop from Leetcode:
 * 
 * 

    Now everything is ready to iterate over the instructions.

    If the current instruction is R, i.e. to turn on the right, the next direction is idx = (idx + 1) % 4.
    Modulo here is needed to deal with the situation - facing west, idx = 3, turn to the right to face north, idx = 0.

    If the current instruction is L, i.e. to turn on the left, the next direction could written in a
    symmetric way idx = (idx - 1) % 4. That means we have to deal with negative indices. A more simple
    way is to notice that 1 turn to the left = 3 turns to the right: idx = (idx + 3) % 4.

    If the current instruction is to move, we simply update the coordinates: x += directions[idx][0],
    y += directions[idx][1].

 *
 * 
 */

class Solution {
    public boolean isRobotBounded(String instructions) {

        /*
         * Time Complexity: O(n) where n = length of instructions
         * 
         * Space Complexity: O(n) where n = length of char array, which is based on instructions' length
         * 
         * Asked by Goldman Sachs, Amazon, Bloomberg, and Airbnb
         */
        
        // Create a list of directions
        int dir[][] = {{0,1}, {-1, 0}, {0, -1}, {1,0}};
        int i = 0;

        // Define initial position
        int x = 0;
        int y = 0;

        // Iterate instructions
        for (char c: instructions.toCharArray()) {
            
            if(c == 'L'){
                i = (i + 1) % 4;
            }
            else if (c == 'R') {
                i = (i + 3) % 4;
            }
            else {
                x = x + dir[i][0];
                y = y + dir[i][1];
            }

        }

        // If either robot changed position or direction, return true. If not, return false
        return x == 0 && y == 0 || i != 0;
    }
}