# https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
      
        # OBJECTIVE: Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this 
        #             substring is greater than or equal to k.
        
        # If k is smaller than s, exit function
        if len(s) < k:
            return 0
        
        # Calculate frequency of each letter
        dic = Counter(s)
        
        # If each character occurs at least k times, return length of s
        # I.e., The entire string is the longest subsequence
        if min(dic.values()) >= k:
            return len(s)
        
        # Iterate dictionary
        for idx, letter in enumerate(s):
            
            # If this letter appears less than k times, then split string by half where this letter isn't part of the substring
            if dic[letter] < k:
                
                # Split string in half
                leftHalf = self.longestSubstring(s[:idx], k)
                rightHalf = self.longestSubstring(s[idx + 1:], k)
                
                # Return longest subsequence string
                return max(leftHalf, rightHalf)
            
        return len(s)
