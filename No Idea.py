# Link: https://www.hackerrank.com/challenges/no-idea/problem

# Skip size because it isn't needed
input()

# Get elements for list
l = list(map(int, input().split()))

# Get elements for both sets
a = set(map(int, input().split()))
b = set(map(int, input().split()))

# Calculate happiness
# (i in a) => This is a True/False statement.
# If it's true, then output will be 1
# If it's false, then output will be 0
print(sum( (i in a) - (i in b) for i in l))
