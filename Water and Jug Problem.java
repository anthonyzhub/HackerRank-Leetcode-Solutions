// https://leetcode.com/problems/water-and-jug-problem/

class Solution {
    
    public int gcd(int num1, int num2) {
        
        if (num2 == 0) {return num1;};
        
        return gcd(num2, num1 % num2);
    }
    
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        
        // Check if both jugs hold the same capacity
        if (jug1Capacity == jug2Capacity) {
            
            // If target shares the same capacity as either jugs, then return true
            if (targetCapacity == jug1Capacity) {
                return true;
            }
            else {
                return false;
            }
        }
        
        // If both jugs can't hold target capacity, return false
        if (targetCapacity > jug1Capacity + jug2Capacity) {
            return false;
        }
        
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;        
    }
}
