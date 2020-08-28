#! /usr/bin/python3

# Link: https://www.hackerrank.com/challenges/ginorts/problem

import string

# Accept input
test = input()

# Create 3 different lists
upper_list = list()
lower_list = list()
even_list = list()
odd_list = list()

# Iterate test string
for i in test:

    # Get lowercase letters
    if i in string.ascii_lowercase:
        lower_list.append(i)

    # Get uppercase letters
    elif i in string.ascii_uppercase:
        upper_list.append(i)

    # Get even numbers
    elif int(i) % 2 == 0:
        even_list.append(int(i))

    # Get odd numbers
    elif int(i) % 2 == 1:
        odd_list.append(int(i))

# Sort all lists
lower_list.sort()
upper_list.sort()
even_list.sort()
odd_list.sort()

# Create a new string
ans = ""

# Add all elements inside of lists to string
ans += ''.join(i for i in lower_list)
ans += ''.join(i for i in upper_list)
ans += ''.join(str(i) for i in odd_list)
ans += ''.join(str(i) for i in even_list)

print(ans)
