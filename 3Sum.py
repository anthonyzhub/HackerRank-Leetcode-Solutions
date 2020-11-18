# Link: https://leetcode.com/problems/3sum/submissions/

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        
        # Sort list
        nums.sort()
        
        # Create a new array for returnal
        ans = list()
        
        # Iterate nums with a buffer size of 3 (prevents out-of-bound error)
        for i in range(len(nums) - 2):
            
            # Skip if number is 0 AND matches previous element
            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            # Create pointers at both endpoints
            leftPointer = i + 1
            rightPointer = len(nums) - 1
            
            # Iterate sublist nums[leftPointer:rightPointer]
            while (leftPointer < rightPointer):
                
                # Compute sum of both pointers and current element
                sum = nums[i] + nums[leftPointer] + nums[rightPointer]
                
                # NOTE: Remember that the list is in sorted order!
                
                # Update leftPointer by going to the next high number
                if sum < 0:
                    leftPointer += 1
                    
                # Update rightPointer by going to the next low number
                elif sum > 0:
                    rightPointer -= 1
                    
                else:
                    
                    # If sum == 0, then add combination to ans[]
                    ans.append([nums[i], nums[leftPointer], nums[rightPointer]])
                    
                    # Update leftPointer while it hasn't reached out of bounds AND it doesn't match with last element
                    while leftPointer < len(nums) - 1 and nums[leftPointer] == nums[leftPointer + 1]:
                        leftPointer += 1
                        
                    # Update rightPointer while it hasn't reached out of bounds AND it doesn't match with last element
                    while rightPointer > 0 and nums[rightPointer] == nums[rightPointer - 1]:
                        rightPointer -= 1
                        
                    leftPointer += 1
                    rightPointer -= 1
                    
        return ans
