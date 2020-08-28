#! /usr/bin/python3

# Link: https://www.hackerrank.com/challenges/validating-the-phone-number/problem

import re # <= Import library for regular experession (re)

# Accept num of test cases
N = int(input())

# Request N number of cases
for _ in range(N):

    # Accept input as list
    num = input()

    # Look for 7, 8, or 9 in string as starting digit
    """
    [789] - String must start with either digit
    \d{9} - Expect 9 digits
    $     - End of string
    """
    if re.match(r'[789]\d{9}$', num):
        print("YES")
    else:
        print("NO")
