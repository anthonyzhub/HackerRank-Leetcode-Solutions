# https://leetcode.com/problems/rectangle-area/

class Rectangle:
    
    def __init__(self, ax1, ay1, ax2, ay2):
        
        # Bottom left corner
        self.bottomLeftX = ax1
        self.bottomLeftY = ay1
        
        # Top right corner
        self.topRightX = ax2
        self.topRightY = ay2
        
        # Calculate width and length
        self.width = self.topRightY - self.bottomLeftY
        self.length = self.topRightX - self.bottomLeftX
        
        # Calculate area
        self.area = self.width * self.length

class Solution:
    
    def findIntersection(self, rectA, rectB):
        
        # OBJECTIVE: Return area of intersecting rectangle (if it does exist)
            
        # Distinguish X & Y values for max and min number
        # NOTE: When looking at the graph, the minimum value will be the highest point for the intersecting rectangle. For X & Y values.
        maxX = min(rectA.topRightX, rectB.topRightX)
        minX = max(rectA.bottomLeftX, rectB.bottomLeftX)

        maxY = min(rectA.topRightY, rectB.topRightY)
        minY = max(rectA.bottomLeftY, rectB.bottomLeftY)

        # If both rectangles do overlap, calculate area
        if maxX >= minX and maxY >= minY:

            length = maxX - minX
            width = maxY - minY

            area = length * width

        # If both rectangles don't intersect, set area to 0
        else:
            area = 0

        return area
    
    def computeArea(self, ax1: int, ay1: int, ax2: int, ay2: int, bx1: int, by1: int, bx2: int, by2: int) -> int:
        
        """
        * OBJECTIVE: Return the summation of the area of each rectangle minus the overlapping area
        *
        * Time Complexity: O(1) because loops aren't used in any function
        *
        *
        * Space Complexity: O(1) because only 2 new classes were initialized and they use constant space. 
        """
        
        # Save coordinates to appropriate rectangles
        rectA = Rectangle(ax1, ay1, ax2, ay2)
        rectB = Rectangle(bx1, by1, bx2, by2)
        
        # Calculate area of intersecting rectangle (if it does exist)
        intersectArea = self.findIntersection(rectA, rectB)
        
        # Add area of rectangle A and B, then subtract area of intersection
        return (rectA.area + rectB.area) - intersectArea
