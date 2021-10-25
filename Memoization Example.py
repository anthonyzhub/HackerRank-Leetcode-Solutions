
# Online Python - IDE, Editor, Compiler, Interpreter

def factorial(num, oldValues):
    
    # If "num" reaches 2!, return 2
    if num == 2:
        return 2
        
    # If N! has already been computed, return its value
    if num in oldValues:
        print("'{}!' already exists!".format(num))
        return oldValues[num]
    
    # Calculate new factorial number and save it to dictionary
    newVal = num * factorial(num - 1, oldValues)
    oldValues[num] = newVal
    
    # Return new value
    return newVal

oldValues = dict()    
print(factorial(3, oldValues))
print(factorial(5, oldValues))
print(factorial(7, oldValues))
