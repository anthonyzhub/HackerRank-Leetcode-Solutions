# https://leetcode.com/problems/longest-common-subsequence/

class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        
        """
        OBJECTIVE: Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
        
        Time Complexity: O(mn) where m = length of text1 and n = length of text2. This function involves
                        iterating the matrix in reverse order
        
        Space Complexity: O(mn) where m = length of text1 and n = length of text2. A matrix was created
                            for this function
        """
        
        # Create a 2D matrix with an additional row and column as a buffer
        matrix = [[0 for j in range(len(text2) + 1)] for i in range(len(text1) + 1)]
        
        # Iterate matrix in reverse order starting from the bottom-right
        for i in range(len(text1) - 1, -1, -1):
            for j in range(len(text2) - 1, -1, -1):
                
                # If letter from both strings match, move to bottom-right
                if text1[i] == text2[j]:
                    matrix[i][j] = 1 + matrix[i + 1][j + 1]
                
                # If letter from both strings don't match, retrun maximum value from bottom and right
                else:
                    matrix[i][j] = max(matrix[i][j + 1], matrix[i + 1][j])
        
        # Return the value from the top-left
        # NOTE: This cell will hold length of the longest common subsequence
        return matrix[0][0]
