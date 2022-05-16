# https://leetcode.com/problems/find-the-town-judge/

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        
        # If list is empty, return -1
        if len(trust) == 0:
            return -1
        
        # If list only has one element, return 2nd element inside of only pair
        elif len(trust) == 1:
            return trust[0][1]
        
        # Create a list that holds a person and the people they trust
        ans = list()
        
        # Traverse list and add each person to ans
        for pair in trust:
            ans.append(pair[0])
        
        # Traverse ans list
        judge = 0
        ans.sort()
        for idx in range(len(ans)):
            
            # If current person isn't the same as the one before, then update judge
            if ans[idx] - 1 != ans[idx - 1] and idx == 0:
                judge = idx
                
            # If everyone trust each other, then there's no judge so return -1
            elif ans[idx] - 1 != ans[idx - 1] and idx:
                return -1
            
        return judge
