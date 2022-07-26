// https://leetcode.com/problems/combination-sum/

class Solution {
    
    public void makeCombinations(List<List<Integer>> res, LinkedList<Integer> combo, int[] candidates, int target, int beginIT) {
        
        // If target is less than 0, exit function
        if (target < 0) {
            return;
        }
        
        // If target has been reached, add combo to res and exit function
        else if (target == 0) {
            res.add(new LinkedList<Integer>(combo));
            return;
        }
        
        // Iterate candidates
        for (int i=beginIT; i<candidates.length; i++) {
            
            // Add candidate to combo
            combo.add(candidates[i]);
            
            // Make a recursive call
            // NOTE: Update target by subtracting ith element from it
            makeCombinations(res, combo, candidates, target - candidates[i], i);
            
            // Remove ith candidate from combo
            combo.remove(combo.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        // If candidates only has 1 element
        if (candidates.length == 1 && candidates[0] == target) {
            
            // Create a linked list and save target in it
            List<Integer> ll = new LinkedList<>();
            ll.add(target);
            
            // Save above linked list inside another linked list
            List<List<Integer>> ans = new LinkedList<>();
            ans.add(ll);
            
            return ans;
        }
        
        // Create a list
        List<List<Integer>> res = new LinkedList<>();
        
        // Make a list of combos
        makeCombinations(res, new LinkedList<Integer>(), candidates, target, 0);
        
        return res;
    }
}
