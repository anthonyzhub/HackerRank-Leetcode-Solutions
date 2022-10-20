// https://leetcode.com/problems/insert-delete-getrandom-o1/

import java.util.*;

class RandomizedSet {
    
    // Create a hash set
    HashSet<Integer> curSet;

    public RandomizedSet() {
        
        // Allocate memory for hash set
        curSet = new HashSet<Integer>();
    }
    
    public boolean insert(int val) {
        
        // OBJECTIVE: Insert val to hash set in O(1) time
        
        // If val exist, return false
        if (curSet.contains(val)) {return false;}
        
        // Add val to hash set and return true
        curSet.add(val);
        return true;
        
    }
    
    public boolean remove(int val) {
        
        // OBJECTIVE: Remove val from hash set in O(1) time
        
        // If val exist, remove it and return true
        if (curSet.contains(val)) {
            curSet.remove(val);
            return true;
        }
        
        // If val doesn't exist, return false
        return false;
    }
    
    public int getRandom() {
        
        // OBJECTIVE: Return a random element from set
        
        // Get a random index
        int idx = new Random().nextInt(curSet.size());
        
        // Iterate set
        int counter = 0;
        for (int elem: curSet) {
            if (counter == idx) {return elem;}
            counter++;
        }
        
        return 0;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
