import numpy

# Get input
# request = 3 lists with 3 rows with 3 elements
request = tuple(map(int, input().split()))

# Print 0's and 1's integer arrays
print(numpy.zeros(request, dtype=int))
print(numpy.ones(request, dtype=int))
