# Link: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/submissions/

class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        
        # If k is the length of cardPoints, return list
        if len(cardPoints) == k:
            return sum(cardPoints)
        
        # Create a list to add all numbers on both endpoints
        leftMost = [0]
        rightMost = [0]
        
        # Iterate list of first n elements
        for n in cardPoints:
            leftMost.append(leftMost[-1] + n) # <= Add current number to previously added number
            
        # Iterate list of the last n elements
        for n in cardPoints[::-1]:
            rightMost.append(rightMost[-1] + n)
            
        # Add all possible combinations to one list
        possibleCombinations = list()
        for i in range(k + 1):
            possibleCombinations.append(leftMost[i] + rightMost[k - i]) # <= Sliding window effect
            
        # Return maximum element
        return max(possibleCombinations)
