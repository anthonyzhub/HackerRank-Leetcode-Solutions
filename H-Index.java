// https://leetcode.com/problems/h-index/submissions/
// Explanation: https://leetcode.com/problems/h-index/discuss/1872013/O(n)-Easy-short-Python-Code-with-Explanation

class Solution {
    public int hIndex(int[] citations) {
        
        // Create a new array
        int n = citations.length + 1;
        int[] arr = new int[n]; // <= By default, array is filled with 0s
        
        // Traverse citations
        for (int curNum: citations) {
            
            if (curNum >= n) {
                arr[n-1] += 1;
            }
            else {
                arr[curNum] += 1;
            }
        }
        
        // Traverse arr array
        int total = 0;
        for (int i=n-1; i>-1; i--) {
            total += arr[i];
            
            if (total >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
