# https://leetcode.com/problems/asteroid-collision/

class Solution:
    
    def slightlyfasterasteroidCollision(self, asteroids: List[int]) -> List[int]:
        
        """
        Time Complexity: O(n) where n = length of asteroids. The list is iterated once and the stack's size won't be greater than it.
        
        Space Complexity: O(n) where n = length of stack. Worst case scenario is having all asteroids moving to the same direction.
        """
        
        # Create a stack
        stack = list()
        
        # Iterate asteroids list
        for curAsteroid in asteroids:
            
            # If stack isn't empty, last added asteroid is going to the right, and curAsteroid is going to the left, then a collision will occur
            while stack and stack[-1] > 0 and curAsteroid < 0:
                
                # Add the size of both asteroids: the last added asteroid and curAsteroid
                diff = stack[-1] + curAsteroid
                
                # If diff is less than 0, then curAsteroid is bigger than the last added asteroid. Pop the last added asteroid
                if diff < 0:
                    stack.pop(-1)
                    
                # If diff is greater than 0, then the last added asteroid is bigger than curAsteroid
                elif diff > 0:
                    
                    # Set curAsteroid to 0 since input restricts astroids from having a size of 0
                    curAsteroid = 0
                    
                # If diff equals to 0, then curAsteroid and the last added asteroid are the same size and exploded
                else:
                    curAsteroid = 0
                    stack.pop(-1)
                    
            # If curAsteroid isn't 0, then add it to stack
            if curAsteroid != 0:
                stack.append(curAsteroid)
                
        return stack
    
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        
        """
        OBJECTIVE: We are given an array asteroids of integers representing asteroids in a row. This is also my solution.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

        Time Complexity: O(nr) where n = length of asteroids and r = length of res. The asteroids list is iterated and compared against any recently added asteroids from res. If res' asteroid is going to the right and current asteroid is going to the left, then a collission will happen. The inner for-loop handles the condition by iterating res and popping asteroids from it.
        
        Space Complexity: O(n) where n = length of asteroids because the worst case is having all the asteroids heading towards the same direction. Those asteroids will be added to res.
        """
        
        # If list's length is less than 2, exit function
        if len(asteroids) < 2:
            return
        
        # Create a return list
        res = list()
        
        # Iterate asteroids list
        for curAsteroid in asteroids:
            
            # If length of res is 0, add curAsteroid to res and skip to next loop
            if len(res) == 0:
                res.append(curAsteroid)
                continue
            
            # If the last asteroid from res is going the same direction as curAsteroid, add curAsteroid to res
            # I.e., If both asteroids are going to the left or to the right, add curAsteroid to res
            if (res[-1] < 0 and curAsteroid < 0) or (res[-1] > 0 and curAsteroid > 0):
                res.append(curAsteroid)
                continue
            
            # If the last asterpod from res is going left and curAsteroid going to the right, both won't collide. So, add curAsteroid to res
            if res[-1] < 0 and curAsteroid > 0:
                res.append(curAsteroid)
                continue
            
            # Check if last element from res and i are heading towards each other
            if res[-1] > 0 and curAsteroid < 0:
                
                # Iterate res in reverse
                addNewAsteroid = False
                for lastAsteroid in res[::-1]:
                    
                    # print(lastAsteroid)
                    
                    # Check if lastAsteroid and curAsteroid are headed towards each other
                    # I.e., Is lastAsteroid going to the right and curAsteroid going to the left
                    if (lastAsteroid > 0 and curAsteroid < 0):
                        
                        # If curAsteroid is bigger than lastAsteroid, remove lastAsteroid
                        if abs(curAsteroid) > abs(lastAsteroid):
                            addNewAsteroid = True
                            res.pop(-1)
                        
                        # If curAsteroid is the same size as lastAsteroid, remove lastAsteroid and don't add curAsteroid to res
                        elif abs(lastAsteroid) == abs(curAsteroid):
                            addNewAsteroid = False
                            res.pop(-1)
                            break
                        
                        # If curAsteroid is smaller than lastAsteroid, exit for-loop
                        else:
                            addNewAsteroid = False
                            break
                            
                # If boolean variable is true, add curAsteroid to res
                if addNewAsteroid:
                    res.append(curAsteroid)
                    
        return res
