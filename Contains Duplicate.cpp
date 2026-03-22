// https://leetcode.com/problems/contains-duplicate/

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        set<int> uniqueElems;

        for (int i = 0; i < nums.size(); i++) {
            if (uniqueElems.contains(nums[i])) {
                return true;
            }

            uniqueElems.insert(nums[i]);
        }

        return false;
    }
};
