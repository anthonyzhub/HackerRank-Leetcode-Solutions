// https://leetcode.com/problems/reverse-vowels-of-a-string/

class Solution {
    public String reverseVowels(String s) {
        
        // If string is null or only has 1 letter, return it
        if (s == null || s.length() == 1) {
            return s;
        }
        
        // Create 2 pointers
        int leftPtr = 0;
        int rightPtr = s.length() - 1;
        
        // Convert string to a list
        char[] sList = s.toCharArray();
        
        // Create a list of vowels
        List<Character> vowels = new ArrayList<Character>();
        vowels.add('A');
        vowels.add('a');
        vowels.add('E');
        vowels.add('e');
        vowels.add('I');
        vowels.add('i');
        vowels.add('O');
        vowels.add('o');
        vowels.add('U');
        vowels.add('u');
        
        // Iterate list
        while (leftPtr < rightPtr) {
            
            // If both pointers are at a vowel, swap them
            if (vowels.contains(sList[leftPtr]) && vowels.contains(sList[rightPtr])) {
                
                // Swap values
                char oldLetter = sList[leftPtr];
                sList[leftPtr] = sList[rightPtr];
                sList[rightPtr] = oldLetter;
                
                // Move pointers
                leftPtr++;
                rightPtr--;
            }
            
            // If leftPtr is at a vowel, but rightPtr isn't, move rightPtr
            else if (vowels.contains(sList[leftPtr]) && !vowels.contains(sList[rightPtr])) {
                rightPtr--;
            }
            
            // If rightPtr is at a vowel, but leftPtr isn't, move leftPtr
            else if (!vowels.contains(sList[leftPtr]) && vowels.contains(sList[rightPtr])) {
                leftPtr++;
            }
            
            // Move both pointers
            else {
                leftPtr++;
                rightPtr--;
            }
        }
        return new String(sList);  
    }
}
