// https://leetcode.com/problems/knight-dialer/

class Solution {
    
    public int traverseMatrix(HashMap<Integer, ArrayList<Integers>> validJumps,
                              HashMap<ArrayList<Integers>, Integers> memo,
                              int jumpsLeft,
                              int numericCell) {
        
        // If jumpsLeft is 0, return 1
        if (jumpsLeft == 0) {return 1;}
        
        // If cell was visited before, return its value
        ArrayList<Integer> tmpList = {jumpsLeft, numericCell};
        if (memo.get(tmpList)) {return memo.get(tmpList);}
        
        // Cycle through hash map of validJumps
        int ans = 0;
        for (int newCell: validJumps.keySet()) {
            ans += self.traverseMatrix(validJumps, memo, jumpsLeft - 1, newCell);
        }
        
        // Save path to memo
        memo.put(tmpList) = ans;
        
        return ans;
    }
    
    public int knightDialer(int n) {
        
        // Create a hash map
        HashMap<Integer, ArrayList<Integers>> validJumps = new HashMap();
        
        // Populate hash map key as numeric cell and value as list of cells that are allowed to visit
        validJumps.put(0, {4, 6});
        validJumps.put(1, ArrayList<Integer> tmpList = {8, 6});
        validJumps.put(2, ArrayList<Integer> tmpList = {7, 9});
        validJumps.put(3, ArrayList<Integer> tmpList = {4, 8});
        validJumps.put(4, ArrayList<Integer> tmpList = {0, 3, 9});
        validJumps.put(5, ArrayList<Integer> tmpList = {});
        validJumps.put(6, ArrayList<Integer> tmpList = {0, 1, 7});
        validJumps.put(7, ArrayList<Integer> tmpList = {2, 6});
        validJumps.put(8, ArrayList<Integer> tmpList = {1, 3});
        validJumps.put(9, ArrayList<Integer> tmpList = {2, 4});
        
        // Create a hash map for memoization
        HashMap<ArrayList<Integers>, Integers> memo = new HashMap();
        
        // Create a for-loop to try a new starting point
        int ans = 0;
        for (int i=0; i<10; i++) {
            ans += traverseMatrix(validJumps, memo, n - 1, i)
        }
        
        return ans % 1000000007;
    }
}
