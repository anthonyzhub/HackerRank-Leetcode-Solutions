// https://leetcode.com/problems/rectangle-area/

class Rectangle {
    
    int bottomLeftX, bottomLeftY, topRightX, topRightY, width, length, area;

    Rectangle(int ax1, int ay1, int ax2, int ay2) {

        // Bottom left corner
        this.bottomLeftX = ax1;
        this.bottomLeftY = ay1;

        // Top right corner
        this.topRightX = ax2;
        this.topRightY = ay2;

        // Calculate dimensions
        this.width = topRightY - bottomLeftY;
        this.length = topRightX - bottomLeftX;

        // Calculate area
        this.area = width * length;
    }
}

class Solution {
    
    public int findIntersection(Rectangle rectA, Rectangle rectB) {
        
        // OBJECTIVE: Return area of intersecting rectangle (if it exist)
        
        // Distinguish X & Y values for max and min number
        // NOTE: When looking at the graph, the minimum value will be the highest point for the intersecting rectangle. For X & Y values.
        int maxX = Math.min(rectA.topRightX, rectB.topRightX);
        int minX = Math.max(rectA.bottomLeftX, rectB.bottomLeftX);
        
        int maxY = Math.min(rectA.topRightY, rectB.topRightY);
        int minY = Math.max(rectA.bottomLeftY, rectB.bottomLeftY);
        
        // If both rectangles intersect, calculate area
        int area = 0;
        if (maxX >= minX && maxY >= minY) {
            
            // Calculate dimensions
            int length = maxX - minX;
            int width = maxY - minY;
            
            // Calculate area
            area = length * width;
        }
        return area;
    }
    
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        /*
        * OBJECTIVE: Return the summation of the area of each rectangle minus the overlapping area
        *
        * Time Complexity: O(1) because loops aren't used in any function
        *
        *
        * Space Complexity: O(1) because only 2 new classes were initialized and they use constant space. 
        */
        
        // Initialize rectangle class
        Rectangle rectA = new Rectangle(ax1, ay1, ax2, ay2);
        Rectangle rectB = new Rectangle(bx1, by1, bx2, by2);
        
        // Calculate area of intersecting rectangle (if it does exist)
        int intersectArea = findIntersection(rectA, rectB);
        
        // Add area of rectangle A and B, then subtract area of intersection
        return (rectA.area + rectB.area) - intersectArea;
    }
}
