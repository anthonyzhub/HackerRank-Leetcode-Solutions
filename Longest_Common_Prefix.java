import java.util.Arrays;

class Longest_Common_Prefix {
    public String solution(String[] strs) {
        
        // If list is only has 1 element, return element
        if (strs.length == 1) {return strs[0];}

        // Sort array lexicographically
        Arrays.sort(strs);

        // Get the 1st and nth element
        String first = strs[0];
        String last = strs[strs.length - 1];

        // Iterate first and last string
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {

            if (first.charAt(i) == last.charAt(i)) {
                ans.append(first.charAt(i));
            }
            else {
                break;
            }
        }

        return ans.toString();
    }
}