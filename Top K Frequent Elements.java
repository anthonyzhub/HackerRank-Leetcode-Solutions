// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;
import java.util.Map.*;

class Solution {
    
    public HashMap<Integer, Integer> counter(int[] nums) {
        
        // OBJECTIVE: Store elements and number of occurrences of each element from nums in a hash map
        
        // Create a hash map
        HashMap<Integer, Integer> dic = new HashMap<>();
        
        // Iterate array
        for (int elem: nums) {
            
            // If elem exist in dic, increment its value
            if (dic.containsKey(elem)) {
                dic.put(elem, dic.get(elem) + 1);
            }
            
            // If not, add elem to dic with a value of 1
            else {
                dic.put(elem, 1);
            }
        }
        
        return dic;
    }
    
    public int[] sortByValue(HashMap<Integer, Integer> map, boolean order, int k) {
        
        // OBJECTIVE: Sory hash map by value
        
        // Convert HashMap into a list
        List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(map.entrySet());
    
        // Sort list
        Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
            
            public int compare(Entry<Integer, Integer> object1, Entry<Integer, Integer> object2) {

                // OBJECTIVE: Return integer value indicating which object goes first

                if (order) {
                    return object1.getValue().compareTo(object2.getValue());
                }
                else {
                    return object2.getValue().compareTo(object1.getValue());
                }
            }
            
        });
        
        // Create a return array
        int[] res = new int[k];
        
        // Add the first k elements from list to array
        for (Entry<Integer, Integer> entry: list) {
            
            // Add entry to array
            if (k > 0) {
                k--;
                res[res.length - k - 1] = entry.getKey();
            } 
            else {
                break;
            }
        }
        return res;
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        
        // Pass array to counter()
        HashMap<Integer, Integer> dic = counter(nums);
        
        // Sort Hash Map by values
        return sortByValue(dic, false, k);
    }
}
