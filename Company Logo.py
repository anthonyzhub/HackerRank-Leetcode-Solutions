#! /bin/python3

# HackerRank's Company Logo question: https://www.hackerrank.com/challenges/most-commons/problem

from collections import Counter

if __name__ == '__main__':

    # Change string input to list
    s = list(input())

    # Create a dictionary based off s and get number of duplicates
    s_dict = Counter(s)

    # Sort dictionary by value in ascending order
    """
    NOTES:
    
        lambda x: (-x[1], x[0])
        1. Sort based on this key
        2. First, sort values in descending order
        3. Second, to change order to ascending, add "-"
        4. If values cannot be sorted, sort by key
    """
    s_dict = sorted(s_dict.items(), key= lambda x: (-x[1], x[0])) # <= sorted() returns a list

    # Iterate multi-list (like a multi-array)
    counter = 0
    for i in s_dict:

        # Print key and value from multi-list
        print("{} {}".format(i[0], i[1]))

        counter += 1

        # Only print the top 3 pairs.
        # Quit after 3
        if counter == 3:
            break
