# Link: https://www.hackerrank.com/challenges/py-set-add/problem?h_r=next-challenge&h_v=zen

# Create a set
a = set()

# Get number of cases
test = int(input())

# Add elements to set
for _ in range(test):
    a.add(input())

# Get length of set
print(len(a))
