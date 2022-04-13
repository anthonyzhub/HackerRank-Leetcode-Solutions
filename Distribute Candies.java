// https://leetcode.com/problems/distribute-candies/

class Solution {
    
    public void arrayToHashMap(int[] curArray, HashMap<Integer, Integer> counter) {
        
        for (int curElem: curArray) {
            
            // If key already exist, update its value
            if (counter.containsKey(curElem)) {
                counter.put(curElem, counter.get(curElem) + 1);
            }
            
            // If key doesn't exist, add it to hashmap
            else {
                counter.put(curElem, 1);
            }
        }
    }
    
    public int distributeCandies(int[] candyType) {
        
        // If candyType is empty, return 0
        if (candyType.length == 0) {return 0;}
        
        // Create a hash map
        HashMap<Integer, Integer> counter = new HashMap();
        
        // Save unique candy types in HashMap
        arrayToHashMap(candyType, counter);
        
        // Count how many unique candies there are
        int uniqueCandies = 0;
        for (int curElem: counter.keySet()) {
            uniqueCandies++;
        }
        
        // If uniqueCandies is less than or equal to half of candyType's size, then Alice can eat every candy type
        if (uniqueCandies <= candyType.length / 2) {
            return uniqueCandies;
        }
        else {
            return candyType.length / 2;
        }
    }
}
