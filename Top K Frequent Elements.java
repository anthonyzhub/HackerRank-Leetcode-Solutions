// https://leetcode.com/problems/top-k-frequent-elements/
// https://youtu.be/YPTqKIgVk-k?si=AQSryFjg28hRYprw

class Solution {

    private Map<Integer, Integer> generateNumberFrequencyMap(int[] nums) {
        Map<Integer, Integer> numberFrequencyMap = new HashMap<>();

        for (int number: nums) {

            if (numberFrequencyMap.containsKey(number)) {
                Integer oldValue = numberFrequencyMap.get(number);
                numberFrequencyMap.put(number, oldValue + 1);
                continue;
            }

            numberFrequencyMap.put(Integer.valueOf(number), 1);
        }

        return numberFrequencyMap;
    }

    private List<List<Integer>> generateMatrixFilledWithEmptyLists(int size) {
        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < size + 1; i++) {
            matrix.add(new ArrayList<>());
        }

        return matrix;
    }

    private void populateMatrix(Map<Integer, Integer> numberFrequencyMap, List<List<Integer>> matrix) {
        for (Map.Entry<Integer, Integer> entry: numberFrequencyMap.entrySet()) {

            Integer number = entry.getKey();
            Integer idxOfNumber = entry.getValue();

            matrix.get(idxOfNumber).add(number);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberFrequencyMap = generateNumberFrequencyMap(nums);
        List<List<Integer>> matrix = generateMatrixFilledWithEmptyLists(nums.length);
        
        populateMatrix(numberFrequencyMap, matrix);

        List<Integer> res = new ArrayList();
        boolean sizeLimitReached = false;

        // Create a list iterator from matrix and iterate matrix in reverse.
        ListIterator<List<Integer>> it = matrix.listIterator(matrix.size());
        while (it.hasPrevious()) {

            // Pop element and iterate it
            List<Integer> poppedList = it.previous();
            for (int i = 0; i < poppedList.size(); i++) {

                // If res reaches its size limit, exit function.
                // If not, continue adding elements from poppedElem to res
                sizeLimitReached = res.size() == k ? true : false;
                if (sizeLimitReached) {
                    return res.stream().mapToInt(Integer::intValue).toArray();
                }

                res.add(poppedList.get(i));
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
