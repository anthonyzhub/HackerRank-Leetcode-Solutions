# https://leetcode.com/problems/different-ways-to-add-parentheses/

class Solution:
    
    def recursionSol(self, str1):
        
        """
            OBJECTIVE: Evaluate string with recursion
            Time complexity: O(S * L * R) where S = length of string, L = length of leftHalf, and R = length of rightHalf. There is a 3-level nested for-loop and each loop is executed                             per iteration
            Space complexity: O(A * S) where A = length of ans and S = length of string. Ans is created first to hold all possible evaluations, however an evaluation is created for every number because of a recursion that creates leftHalf and rightHalf.
        """
        
        # If str1 only has 1 element and it's a digit, return it
        if str1.isdigit():
            return [int(str1)]
        
        # Create a list to hold evaluations
        ans = list()
        
        # Traverse string
        for i in range(len(str1)):
            
            # Check if str1[i] is an operator
            if str1[i] in ["+", "*", "-"]:
                
                # Split string by operator
                leftHalf = self.recursionSol(str1[:i])
                rightHalf = self.recursionSol(str1[i+1:])
                
                # Evaluate left and right half expressions
                for leftNum in leftHalf:
                    for rightNum in rightHalf:
                        
                        # Perform operation
                        if str1[i] == "+":
                            ans.append(leftNum + rightNum)
                        elif str1[i] == "*":
                            ans.append(leftNum * rightNum)
                        elif str1[i] == "-":
                            ans.append(leftNum - rightNum)
                            
        return ans
    
    def memoSol(self, str1, memo):
        
        # If str1 only has 1 element and it's a digit, return it
        if str1.isdigit():
            return [int(str1)]
        
        # If expression was already computed, return its value
        # NOTE: This will be faster with expressions, such as "3-4-3-4-3-4-3-4-3-4"
        if str1 in memo:
            return memo[str1]
        
        # Create a list to hold evaluations
        ans = list()
        
        # Traverse string
        for i in range(len(str1)):
            
            # Check if str1[i] is an operator
            if str1[i] in ["+", "*", "-"]:
                
                # Split string in half by operator
                leftHalf = self.memoSol(str1[:i], memo)
                rightHalf = self.memoSol(str1[i+1:], memo)
                
                # Evaluate left and right half expressions
                for leftNum in leftHalf:
                    for rightNum in rightHalf:
                        
                        # Perform operation
                        if str1[i] == "+":
                            ans.append(leftNum + rightNum)
                        elif str1[i] == "*":
                            ans.append(leftNum * rightNum)
                        elif str1[i] == "-":
                            ans.append(leftNum - rightNum)
                            
        # Save all possible evaluations to dictionary
        memo[str1] = ans
        return ans
    
    def diffWaysToCompute(self, expression: str) -> List[int]:
        
        # return self.recursionSol(expression) # <= Resursive solution
        return self.memoSol(expression, {}) # <= Memoization solution
