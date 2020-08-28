#!/bin/python3

import math
import os
import random
import re
import sys
from datetime import datetime # <= Import library

# Link: https://www.hackerrank.com/challenges/python-time-delta/problem

# Complete the time_delta function below.
def time_delta(t1, t2):

    # Create a time format
    """
    %a - Name of day
    %d - Day's number in the month
    %b - Name of month
    %Y - Year
    %H:%M:%S - hour, minute, second
    &z - Time zone
    """
    time_format = "%a %d %b %Y %H:%M:%S %z"

    # Strip strings to datetime type based on time_format
    t1 = datetime.strptime(t1, time_format)
    t2 = datetime.strptime(t2, time_format)

    # Get time difference as int
    ans = int(abs(t1 - t2).total_seconds())

    # Return answer as string because of main()
    return str(ans)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        t1 = input()

        t2 = input()

        delta = time_delta(t1, t2)

        fptr.write(delta + '\n')

    fptr.close()
