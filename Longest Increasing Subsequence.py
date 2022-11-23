# https://leetcode.com/problems/longest-increasing-subsequence/

class Solution:
    
    def slowSolution(self, nums: List[int]) -> int:
        
        """
        OBJECTIVE: Given an integer array nums, return the length of the longest strictly increasing subsequence.
        
        Time Complexity: O(n^2) where n = length of nums. A nested for-loop is used to iterate nums in both directions.
            
        Space Complexity: O(n) where n = length of nums. A new list called cache is created with the same exact size as nums
        """
        
        # Create a cache list where each value representings that longest increasing subsequence from each point
        cache = [1] * len(nums)
        
        # Iterate nums in reverse
        # NOTE: Remember that range() is non-inclusive, or [)
        for i in range(len(nums) - 1, -1, -1):
            
            # Iterate nums from the neighboring element moving forward
            for j in range(i + 1, len(nums)):
                
                # If ith number is less than jth, update cache
                if nums[i] < nums[j]:
                    
                    # Only keep length of maximum subsequence
                    cache[i] = max(cache[i], 1 + cache[j])
                    
        return max(cache)
    
    def fasterSolution(self, nums: List[int]) -> int:
        
        """
        OBJECTIVE: Given an integer array nums, return the length of the longest strictly increasing subsequence.
        
        Time Complexity: O(n log n) where n = length of nums. Inside the for-loop, binary search is being used to properly insert elements from nums to tails. 
        
                        I didn't nums' iteration because the largest time complexity is kept as the final answer. E.g., O(n) < O(n log n), so O(n + n log n) isn't really different from O(n log n). Most of the time spent is coming from O(n log n).
                        
        Space Complexity: O(n) where n = length of tails. An additional list was created to solve the problem.
        """
        
        # Get size of nums
        n = len(nums)
        
        # Create list of tails
        tails = [0] * n
        
        # Create a return variable
        res = 0
        
        # Iterate nums
        for num in nums:
            
            # Create indices
            leftPtr = 0
            rightPtr = res
            
            # Use binary search to find an element from tails that needs to be updated
            while leftPtr != rightPtr:
                
                # Calculate midpoint
                midPtr = (leftPtr + rightPtr) // 2
                
                # If num is greater than element at midpoint, update left pointer
                if num > tails[midPtr]:
                    leftPtr = midPtr + 1
                    
                # If num is less than or equal to element at midpoint, update right pointer
                else:
                    rightPtr = midPtr
                    
            """ 
            Mini Objective: Update element in tails
            If num is greater than all the elements in tail, add it to tails. I.e., replace 0 for num
            If num can be inserted in tails, replace old element for nums. E.g., tails[leftPtr - 1] < num <= tails[leftPtr]
            """
            tails[leftPtr] = num
            
            # Update return output
            res = max(leftPtr + 1, res)
            
        return res
