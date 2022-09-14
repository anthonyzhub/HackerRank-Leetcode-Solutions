// https://leetcode.com/problems/combination-sum-iii/

class Solution {
    
    public void comboMaker(int maxLen, int target, int curNum, int curSum, List<Integer> curCombo, List<List<Integer>> res) {
        
        // If curSum equals to target and curCombo's length equals to maxLength, add curCombo to res
        if (curSum == target && curCombo.size() == maxLen) {
            
            // Create a temporary array list and add elements from curCombo to it
            List<Integer> tmp = new ArrayList<>();
            for(int i: curCombo) {tmp.add(i);}
            
            // Add temporary array list to res
            res.add(tmp);
            return;
        }
        
        // If curNum + 1 >= 10 or  curSum > target, exit function
        // I.e., This is a bad combination, so exit function
        if (curNum + 1 >= 10 || curSum > target) {return;}
        
        // Add a new number to curCombo
        curCombo.add(curNum + 1);
        
        // Make a recursive call
        comboMaker(maxLen, target, curNum + 1, curSum + curNum + 1, curCombo, res);
        
        // Remove recently added number from curCombo
        curCombo.remove(curCombo.size() - 1);
        
        // Make another recursive call
        comboMaker(maxLen, target, curNum + 1, curSum, curCombo, res);
        
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        // Create 2 lists - 1 for output and another for working combination
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curCombo = new ArrayList<>();
        
        // Make working combinations
        comboMaker(k, n, 0, 0, curCombo, res);
        
        // Return list of combinations
        return res;
    }
}
