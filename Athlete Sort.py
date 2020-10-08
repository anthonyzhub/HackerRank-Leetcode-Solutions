# Link: https://www.hackerrank.com/challenges/python-sort-sort/problem
#!/bin/python3

if __name__ == '__main__':

    # Get number of entries
    nm = input().split()
    n = int(nm[0])
    m = int(nm[1])

	# Create a list
    arr = []

    # Append N inputs to arr
    for _ in range(n):
        arr.append(list(map(int, input().rstrip().split())))

    # Get attribute to inspect
    k = int(input())

    # Create a dictionary
    attributeDict = dict()

    # Iterate list
    for row, elem in enumerate(arr):

        # {Row: list}
		# Accept index and kth number inside the list
        attributeDict[row] = elem[k]

    # Sort dictionary by values, instead of key
    for key, value in sorted(attributeDict.items(), key=lambda x:x[1]):
        print(' '.join(str(i) for i in arr[key]))