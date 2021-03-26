# Link: https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        # Exit function if nums is empty
        if len(nums) == 0 or nums == None:
            return -1
        
        # Exit function if target is not inside nums
        if target not in nums:
            return -1
        
        return nums.index(target)
