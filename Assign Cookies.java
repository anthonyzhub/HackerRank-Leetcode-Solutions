// https://leetcode.com/problems/assign-cookies/

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        // If there aren't any cookies, return 0
        if (s.length == 0) {return 0;}
        
        // Sort both arrays
        Arrays.sort(g);
        Arrays.sort(s);
        
        // Create a variable to hold number of satisfied eaters
        int satisfied = 0;
        
        // Iterate cookie array
        for (int cookieSize: s) {
            
            // If number of satisfiers exceed cookie eater size, exit loop
            if (satisfied >= g.length) {break;}
            
            // If cookie can satisfy eater, increment counter
            if (cookieSize >= g[satisfied]) {satisfied++;}
        }
        
        // Return the number of satisfied cookie eaters
        // NOTE: "satisfied" doesn't have to reach end of array. It just means that the other kids couldn't get to eat a cookie
        return satisfied;
    }
}
