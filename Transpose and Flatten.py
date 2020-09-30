import numpy

# Get matrix's dimension
size = list(map(int, input().split()))
row = size[0]

# Accept list's elements
arr = []
for _ in range(row):
    arr.append(input().split())

# Turn list into numpy array
arr = numpy.array(arr, int)

# Transpose and flatten array
print(numpy.transpose(arr))
print(arr.flatten())