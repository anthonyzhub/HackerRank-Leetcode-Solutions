# https://leetcode.com/problems/h-index/
# Explanation: https://leetcode.com/problems/h-index/discuss/1872013/O(n)-Easy-short-Python-Code-with-Explanation

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        n = len(citations) + 1
        arr = [0] * n
        for c in citations:
            if c >= n:
                arr[n-1] += 1
            else:
                arr[c] += 1
        
        total = 0
        for i in range(n-1, -1, -1):
            total +=  arr[i]
            if total >= i:
                return i
        
        return 0
