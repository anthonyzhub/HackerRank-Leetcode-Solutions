# https://leetcode.com/problems/bulb-switcher/

class Solution:
    def bulbSwitch(self, n: int) -> int:
        
        # Square root of n bulbs will be turned on
        return int(sqrt(n))
