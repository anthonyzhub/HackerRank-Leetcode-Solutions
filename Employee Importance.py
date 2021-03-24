# Link: https://leetcode.com/problems/employee-importance/submissions/

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        # Return 0, if list is empty
        if employees == None or len(employees) <= 0:
            return 0
        
        # Turn list into dictionary
        # Dictionary: {employee id: employee}
        employeesDict = {employee.id: employee for employee in employees}
        
        # Get 1st employee and get its importance value
        firstEmployee = employeesDict[id]
        total = firstEmployee.importance
        
        # Get employee's subordinates and iterate through list
        for subordinate_id in firstEmployee.subordinates:
            
            # Add subordinates' importance value to total
            total += self.getImportance(employees, subordinate_id)
            
        return total
        
        
