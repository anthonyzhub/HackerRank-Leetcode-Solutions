import numpy

# Accept input as integers and turn it to an array
arr = list(map(int, input().split()))

# Turn list to numpy array
arr = numpy.array(arr)

# Print 3x3 array
print(numpy.reshape(arr, (3,3)))