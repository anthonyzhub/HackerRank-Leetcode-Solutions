// https://leetcode.com/problems/valid-anagram/

class Solution {

    private void strToMap(String s, Map<Character, Integer> sMap) {

        for (char c: s.toCharArray()) {

            Character ch = Character.valueOf(c);

            if (sMap.containsKey(ch)) {
                sMap.put(c, sMap.get(ch) + 1);
            }
            else {
                sMap.put(ch, 1);
            }
        }
    }

    public boolean isAnagram(String s, String t) {

        /*
         * Time Complexity: O(n) where n = max(s.length, t.length). strToMap() will iterate both strings
         *  and will take more time on the longest string.
         * 
         * Space Complexity: O(n + a) where n = max(s.length, t.length) and a = the size of the largest hash map.
         *  E.g., if S is 26 characters long and has unique letters, then the charArray() and Map will hold 26 elements.
         *  If S is 26 characters long and has 1 unique letter, then the char array will hold 26 letters while the map
         *  has 1 element.
         */
        
        if ((s.isEmpty() && !t.isEmpty()) || (!s.isEmpty() && t.isEmpty())) {
            return false;
        }

        // Create 2 maps
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        // Store string in map
        strToMap(s, sMap);
        strToMap(t, tMap);

        return sMap.equals(tMap);
    }
}