# https://leetcode.com/problems/can-place-flowers/

class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        
        # Create a counter of how many new plants were planted
        counter = 0
        
        # Get length of flowerbed
        bedSize = len(flowerbed)
        
        # Iterate list
        for i in range(bedSize):
            
            # Check if element at index is empty
            if flowerbed[i] == 0:
                
                # Inspect neighboring elements
                # NOTE: 1st conditions were added to check if i is at the beginning or the end of the list
                isLeftEmpty = (i == 0) or (flowerbed[i - 1] == 0)
                isRightEmpty = (i == bedSize - 1) or (flowerbed[i + 1] == 0)
                
                # If both plots are empty, update counter and element
                if isLeftEmpty and isRightEmpty:
                    
                    # Update counter and element
                    counter += 1
                    flowerbed[i] = 1
                    
                    # If counter equals or exceeds n, then return true
                    if counter >= n:
                        return True
        
        # NOTE: I don't know why we need this. Some tests will fail without this
        return counter >= n
