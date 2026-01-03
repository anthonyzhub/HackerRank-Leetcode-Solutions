// https://leetcode.com/problems/ransom-note/
/*
Time Complexity: O(max(m, n)) where m = length of ransomNote and n = length of magazine

Space Complexity: O(max(m, n)) where m = size of ransomMap and n = size of magazineMap

Thought Process:
- Magazine needs to have all the letters that is in ransomNote
- Iterate ransomMap
- Check that each letter exist in magazine and it appears as many times in ransomNote
- If condition above isn't triggered, return false. If not, return true
*/

class Solution {

    private Map<Character, Integer> createMapFromStr(String inputStr) {
        Map<Character, Integer> result = new HashMap<>();

        for (char letter: inputStr.toCharArray()) {
            result.put(letter, result.getOrDefault(letter, 0) + 1);
        }

        return result;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = createMapFromStr(ransomNote);
        Map<Character, Integer> magazineMap = createMapFromStr(magazine);

        for (Map.Entry<Character, Integer> entry: ransomMap.entrySet()) {
            Character letter = entry.getKey();
            Integer freq = entry.getValue();

            if (!magazineMap.containsKey(letter) || freq > magazineMap.get(letter)) {
                return false;
            }
        }

        return true;
    }
}
