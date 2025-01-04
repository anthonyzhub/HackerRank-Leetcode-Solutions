// https://leetcode.com/problems/generate-parentheses/
// https://youtu.be/s9fokUqJ76A?si=-YtcOOfwwIihtiHK

/*
Time Complexity: O(2n) where n = input number. I added 2 because the max size of one string is 2n where there are an even number of open and closed parentheses. 
  However, coefficients are always dropped if they're a part of the first variable in a complexity, so the final answer should be O(n). When talking in an interview, say O(n) instead of O(2n).

Space Complexity: O(n) where n = size of the list holding all valid combinations.
*/

class Solution {

    private void generateValidParentheses(List<String> res, StringBuilder strBuilder, int maxSize, int numOfOpenParenthesis, int numOfClosedParenthesis) {
        
        /* RULES:
        1. The number of open and closed parentheses cannot exceed the given max size
        2. You can only add "(" if numOfOpenParenthesis < maxSize
        3. You can only add ")" if numOfClosedParenthesis < numOfOpenParenthesis
        */
        
        if (maxSize == numOfOpenParenthesis && maxSize == numOfClosedParenthesis) {
            res.add(strBuilder.toString());
            return;
        }

        if (numOfOpenParenthesis < maxSize) {
            strBuilder.append("(");
            generateValidParentheses(res, strBuilder, maxSize, numOfOpenParenthesis + 1, numOfClosedParenthesis);
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }

        if (numOfClosedParenthesis < numOfOpenParenthesis) {
            strBuilder.append(")");
            generateValidParentheses(res, strBuilder, maxSize, numOfOpenParenthesis, numOfClosedParenthesis + 1);
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        }

        List<String> res = new ArrayList<>();
        StringBuilder strBuilder = new StringBuilder();

        generateValidParentheses(res, strBuilder, n, 0, 0);

        return res;
    }
}
