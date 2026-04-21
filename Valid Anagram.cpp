// https://leetcode.com/problems/valid-anagram/

#include <map>

class Solution {
public:

    map<char, int> generateMap(string inputStr) {
        map<char, int> res;

        for (int i = 0; i < inputStr.size(); i++) {
            char curLetter = inputStr.at(i);
            res[curLetter]++;
        }

        return res;
    }

    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }

        map<char, int> sMap = generateMap(s);
        map<char, int> tMap = generateMap(t);

        return sMap == tMap;
    }
};
