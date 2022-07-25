// https://leetcode.com/problems/majority-element-ii/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        // Create a HashMap
        HashMap<Integer, Integer> counter = new HashMap<>();
        
        // Populate HashMap with elements from nums
        for (int elem: nums) {
            
            // Convert int to Integer
            Integer tmp = Integer.valueOf(elem);
            
            // Add Integer to HashMap
            counter.putIfAbsent(tmp, 0);
            counter.put(tmp, counter.get(tmp) + 1);
        }
        
        // Iterate HashMap
        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> set: counter.entrySet()) {
            
            if (set.getValue() > nums.length / 3) {
                res.add(set.getKey());
            }
        }
        return res;
    }
}
