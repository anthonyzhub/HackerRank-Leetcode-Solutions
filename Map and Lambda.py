# Link: https://www.hackerrank.com/challenges/map-and-lambda-expression/problem

cube = lambda x: x ** 3 # <= complete the lambda function 

def fibonacci(n):

    # Create a list
    l = list()

    # Create a list of first N numbers
    a = 0
    b = 1
    for _ in range(n):

        # Add new number to list
        l.append(a)

        # Update variables
        tmp = a + b
        a = b
        b = tmp

    return l

if __name__ == '__main__':
    n = int(input())
    print(list(map(cube, fibonacci(n))))