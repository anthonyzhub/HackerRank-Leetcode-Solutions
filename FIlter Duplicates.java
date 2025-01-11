/*
Time Complexity: O(n) where n = length of data.
Space Complexity: O(n) where n = number of unique elements inside data[].

OBJECTIVE: Given an array of integers, return an array of integers without any duplicates in the same order it was given.
E.g., [1, 1, 1] => [1],
  [1, 4, 23, 56, 12] => [1, 4, 23, 56, 12],
  [9, 9, 7, 24, 18, 2] => [9, 7, 24, 18, 2]
*/

class Solution {
    
    private int[] convertToArray(List<Integer> ans) {
        int[] res = new int[ans.size()];
        
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        
        return res;
    }

    public int[] filterDuplicates(int[] data) {
        
        if (data == null) {
            return new int[]{};
        }
        
        if (data.length == 1) {
            return data;
        }
        
        Set<Integer> uniqueElems = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < data.length; i++) {
            int newElem = data[i];
            
            if (!uniqueElems.contains(newElem)) {
                uniqueElems.add(newElem);
                res.add(newElem);
            }
        }
        
        return convertToArray(res);
    }
}
