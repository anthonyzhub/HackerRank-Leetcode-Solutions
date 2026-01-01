// https://leetcode.com/problems/intersection-of-two-arrays-ii/
/*
Time Complexity: O(max(m, n) * max(most frequent element)) where m = length of map1 and n = length of map2. In every iteration, there
    is a inner for-loop where it inserts a key as many times it appears in both maps.

Space Complexity: O(max(m, n) * max(most frequent element)) where m = length of map1 and n = length of map2.

Thought Process:
- Create a map of both arrays
- Key: element, value: frequency
- Compare both maps
- If there is a common key, insert key to output where frequency is the minimum value between both maps
- Return output
*/

class Solution {

    private Map<Integer, Integer> createMapFromArray(int[] inputArray) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < inputArray.length; i++) {
            result.put(inputArray[i], result.getOrDefault(inputArray[i], 0) + 1);
        }

        return result;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = createMapFromArray(nums1);
        Map<Integer, Integer> map2 = createMapFromArray(nums2);

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> curEntry: map1.entrySet()) {

            Integer curKey = curEntry.getKey();
            Integer curVal = curEntry.getValue();

            if (map2.containsKey(curKey)) {

                int minOccurrence = Math.min(map2.get(curKey), curVal);

                for (int i = 0; i < minOccurrence; i++) {
                    result.add(curKey);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
