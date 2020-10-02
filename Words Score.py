
# Link: https://www.hackerrank.com/challenges/words-score/problem

def is_vowel(letter):
    return letter in ['a', 'e', 'i', 'o', 'u', 'y']

def score_words(words):
    score = 0

    # Iterate list
    for word in words:
        num_vowels = 0

        # Iterate word
        for letter in word:

            # Send letter to function
            if is_vowel(letter):
                num_vowels += 1

        if num_vowels % 2 == 0:
            score += 2
        else:
            score += 1
            
    return score