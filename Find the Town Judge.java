// https://leetcode.com/problems/find-the-town-judge/

class Solution {
    public int findJudge(int n, int[][] trust) {
        
        // Create 2 arrays - one for trust and other to see if ith trust somebody
        int[] trustCount = new int[n + 1];
        boolean[] trustAnother = new boolean[n + 1];
        
        // Iterate trust array
        for (int[] pair: trust) {
            
            // Break down pair
            int truster = pair[0];
            int trustee = pair[1];
            
            // Add both to appropriate array
            trustAnother[truster] = true;
            trustCount[trustee]++;
        }
        
        // Iterate trustCount and trustAnother array
        for (int i=1; i<=n; i++) {
            
            // If ith person doesn't trust anyone and everyone (n people) trust him, return i because that's the judge
            // NOTE: n - 1 is used because there are N people, including the judge. The town judge doesn't trust himself.
            if (!trustAnother[i] && trustCount[i] == n - 1) {
                return i;
            }
        }
        
        // Return -1 if no judge was found
        return -1;
    }
}
