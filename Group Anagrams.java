// https://leetcode.com/problems/group-anagrams/
// https://youtu.be/vzdNOK2oB2E?si=bCCaHSlchW1NzM4b

/*
Time Complexity: O(m * n) where m = length of input array and n = average length of each element inside the input array.
Space Complexity: O(m * n) with same reasoning as the time complexity
*/

class Solution {

    private List<Integer> generateListWithDefaultValues(int defaultValue, int listSize) {
        // Simply create a list with set size and where each element starts with the same value
        List<Integer> newList = new ArrayList<>();

        // NOTE: Added +1 because, for this problem, I specifically need 26 slots and computer starts counting at 0.
        for (int i = 0; i < listSize + 1; i++) {
            newList.add(Integer.valueOf(defaultValue));
        }

        return newList;
    }

    private List<Integer> generateLetterFrequenyList(String elem) {

        // Generate a list of 26 0's
        // IMPORTANT: 26 because that's how many letters there are in the alphabet
        List<Integer> lettersFrequency = generateListWithDefaultValues(0, 26);

        // I need to create this variable as reference for future use
        int aAsciiValue = (int) 'a';
        for (char letter: elem.toCharArray()) {

            // Compute ascii value and target index
            int asciiValue = (int) letter;
            int targetIdx = asciiValue - aAsciiValue;

            Integer oldValue = lettersFrequency.get(targetIdx);
            lettersFrequency.set(targetIdx, oldValue + 1);
        }

        return lettersFrequency;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        // Create a map that will hold 2 lists - 1 for frequency of each letter and 1 for strings
        Map<List<Integer>, List<String>> tracker = new HashMap<>();

        for (String elem: strs) {

            // Generate a list of frequencies of each letter in the alphabet
            List<Integer> newKey = generateLetterFrequenyList(elem);

            if (tracker.containsKey(newKey)) {
                tracker.get(newKey).add(elem);
                continue;
            }

            // IMPORTANT: By adding that value, instead of just List.of(), I'm creating a muttable list and not immutable one
            tracker.put(newKey, new ArrayList<>(List.of(elem)));
        }

        return new ArrayList(tracker.values());
    }
}
