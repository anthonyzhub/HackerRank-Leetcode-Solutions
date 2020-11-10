# Link: https://leetcode.com/problems/dot-product-of-two-sparse-vectors/submissions/

class SparseVector:
    def __init__(self, nums: List[int]):
        
        # Convert list to dictionary. Set index as key and value as element
        self.numsDict = {i: nums[i] for i in range(len(nums))}
        self.size = len(nums)

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec: 'SparseVector') -> int:
        
        # NOTE: Constraint mentions how both vectors are equal in length
        
        total = 0
        for i in range(self.size):
            
            total += (self.numsDict[i] * vec.numsDict[i])
            
        return total

# Your SparseVector object will be instantiated and called as such:
# v1 = SparseVector(nums1)
# v2 = SparseVector(nums2)
# ans = v1.dotProduct(v2)
