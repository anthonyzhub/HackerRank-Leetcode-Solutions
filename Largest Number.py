# https://leetcode.com/problems/largest-number/

class CustomSort(str):
    
    # OBJECTIVE: Create a class that inherits from String and override comparison function
    
    def __lt__(strA, strB):
        return strA+strB > strB+strA

class Solution:
    
    def largestNumber(self, nums: List[int]) -> str:
      
        """
        * OBJECTIVE: Return largest possible number as a string
        *
        * Time Complexity: O(n + nlogn) where n = length of nums. The map() will iterate the list and convert every element to a string. Although a
        *                   custom sorting algorithm is being used, the time complexity will still be O(n log n).
        *
        * Space Complexity: O(n) where n = length of return string. map() is overriding the input list, so it will still take the same amount of space. However,
        *                   a new string, with the same size as nums, is created and is the function's return value.
        """
        
        # Convert integers to strings
        nums = list(map(str, nums))
        
        # Sort key with custom sorting method
        largestNum = "".join(sorted(nums, key=CustomSort))
        
        # If first digit is a 0, return 0
        # E.g., Input is [0, 0], then output should be "0"
        if largestNum[0] == "0":
            return "0"
        
        return largestNum
