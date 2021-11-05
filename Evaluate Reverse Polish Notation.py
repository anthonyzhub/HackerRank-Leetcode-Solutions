# https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution:
    
    def findOperand(self, tokens):
        
        # Define a list of operands
        operandsStr=list("+ - * / ")
        
        # Iterate tokens
        for idx, i in enumerate(tokens):
            
            if i in operandsStr:
                return idx
            
        # If there are no more operands, return -1
        return -1
    
    def calculate(self, tokens, num1, operator, num2):
        
        # Decide on operation
        if operator == "+":
            return int(num1) + int(num2)
        
        elif operator == "-":
            return int(num1) - int(num2)
        
        elif operator == "*":
            return int(num1) * int(num2)
        
        elif operator == "/":
            return int(num1) / int(num2)
    
    def evalRPN(self, tokens: List[str]) -> int:
        
        # If tokens only has a single digit, return it
        if len(tokens) == 1 and tokens[0].isnumeric():
            return int(tokens[0])
        
        # Iterate tokens until it only has 1 element
        while len(tokens) > 1:
            
            # Find first operator
            firstOperandIdx = self.findOperand(tokens)
            operator = tokens[firstOperandIdx]
            
            # Get 2 numbers before operator's index
            num1 = tokens[firstOperandIdx - 2]
            num2 = tokens[firstOperandIdx - 1]
            
            # Perform calculations
            tmpCalculation = self.calculate(tokens, num1, operator, num2)
            
            # Update value at index num1
            tokens[firstOperandIdx - 2] = tmpCalculation
            
            # Remove elements at operator's and num2's index
            tokens.pop(firstOperandIdx)
            tokens.pop(firstOperandIdx - 1)
            
        return int(tokens[0])
