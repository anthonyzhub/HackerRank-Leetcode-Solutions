# Link: https://www.hackerrank.com/challenges/symmetric-difference/problem

# Skip size output
input()

# Get integers and put them in a list
a = set(map(int, input().split()))

# Skip size output
input()

# Get integers and put them in a list
b = set(map(int, input().split()))

# Get elements from a not in b
ans = []
for i in a.difference(b):
    ans.append(i)

# Get elements from b not in a
for i in b.difference(a):
    ans.append(i)

# Sort list
ans.sort()

# Print list
print('\n'.join(str(i) for i in ans))
