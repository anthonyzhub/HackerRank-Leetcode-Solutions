# https://leetcode.com/problems/find-the-town-judge/

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        
        # Create 2 new list - trustCount and trustAnother
        # NOTE: "n + 1" was added because "n" starts at 1
        trustCount = [0] * (n + 1)
        trustAnother = [False] * (n + 1)
        
        # Traverse trust list
        for pair in trust:
            
            # Breakdown pair
            truster = pair[0]
            trustee = pair[1]
            
            # Add variable to appropriate list
            # NOTE: Since there's no 0th person, person 1 will be on the 1st index
            trustAnother[truster] = True
            trustCount[trustee] += 1
            
        # Traverse trustCount and trustAnother
        # NOTE: Both lists share the same size and loop starts at 1 because there's no 0th person.
        for i in range(1, len(trustCount)):
            
            # If ith person doesn't trust anyone and everyone, except for himself, trust them, then they are the judge.
            # NOTE: n - 1 where n = population people need to trust him. The judge doesn't even trust himself.
            if trustAnother[i] == False and trustCount[i] == n - 1:
                return i
            
        # If no judge was found, return -1
        return -1
