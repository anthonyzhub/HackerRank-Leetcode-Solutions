// https://leetcode.com/problems/permutations/
/*
Time Complexity: O(n * n!) where n = length of nums. n! comes from permutation 
    and permutation calculation is being done per element.

Space Complexity: O(n) where n = length of nums. A recursive call is being made per element.
*/
class Solution {

    private List<List<Integer>> result;

    private void swap(int[] nums, int leftPtr, int rightPtr) {
        int tmp = nums[leftPtr];
        nums[leftPtr] = nums[rightPtr];
        nums[rightPtr] = tmp;
    }

    private void permutate(int[] nums, int idx) {
        // IMPORTANT: The very 1st computed permutation will be the inputted value in permute()
        if (idx == nums.length) {
            List<Integer> tmp = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(tmp);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            permutate(nums, idx + 1);
            swap(nums, i, idx);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        permutate(nums, 0);
        return result;
    }
}
