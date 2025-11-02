// https://leetcode.com/problems/top-k-frequent-elements/
// https://youtu.be/YPTqKIgVk-k?si=6-frphN-ERaIo92i

class Solution {

    private Map<Integer, Integer> generateMap(int[] nums) {

        // OBJECTIVE: Create map where key is an element and value is frequency of said element

        Map<Integer, Integer> result = new HashMap<>();

        for (int number: nums) {
            Integer numAsInt = Integer.valueOf(number);

            if (result.containsKey(numAsInt)) {
                result.put(numAsInt, result.get(numAsInt) + 1);
            } else {
                result.put(numAsInt, 1);
            }
        }

        return result;
    }

    private List<List<Integer>> generateMatrix(int size) {

        // OBJECTIVE: Generate a matrix of empty lists. Remember, K must be at least the size of the input array.
        // Possible: nums = [1, 2] & k = 2
        // Impossible: nums = [1, 2] & k = 100....How can you capture the top 100 occurring elements if only 2 exist?

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < size + 1; i++) {
            matrix.add(new ArrayList<>());
        }

        return matrix;
    }

    private void populateMatrixWithMap(List<List<Integer>> matrix, Map<Integer, Integer> uniqueElems) {
        
        // OBJECTIVE: The matrix index will serve as a frequency and the actual list element will hold all the numbers that appear that many times.
        // E.g., nums: [1, 2, 2, 4, 6] & matrix: [null, [1, 4, 6], [2]]
        
        for (Map.Entry<Integer, Integer> entry: uniqueElems.entrySet()) {
            Integer number = entry.getKey();
            Integer freq = entry.getValue();
            matrix.get(freq).add(number);
        }
    }

    private void getKElementsFromMatrix(List<List<Integer>> matrix, int k) {

        // OBJECTIVE: Get the K most elements from the matrix in reverse order

        List<Integer> result = new ArrayList<>();

        // Create an iterator and iterate matrix in reverse order
        ListIterator<List<Integer>> it = matrix.listIterator(matrix.size());
        while (it.hasPrevious()) {

            // Iterate list at ith index
            List<Integer> nestedList = it.previous();
            for (int i = 0; i < nestedList.size(); i++) {

                // Only add up to k-numbers
                if (k > 0) {
                    Integer poppedNumber = nestedList.get(i);
                    result.add(poppedNumber);
                    k--;
                } else {
                    return result.stream().mapToInt(Integer::valueOf).toArray();
                }
            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1 && k == 1) {
            return nums;
        }

        Map<Integer, Integer> uniqueElems = generateMap(nums);
        List<List<Integer>> matrix = generateMatrix(nums.length);

        populateMatrixWithMap(matrix, uniqueElems);

        return getKElementsFromMatrix(matrix, k);
    }
}
