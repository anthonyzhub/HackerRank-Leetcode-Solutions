// https://leetcode.com/problems/repeated-dna-sequences/

class Solution {
    
    public String buildString(char[] letters, int startIdx, int endIdx) {
        
        // If endIdx is bigger than array's length, exit function.
        // If not, an out-of-bound error will occur
        if (endIdx > letters.length) {return null;}
        
        // Create a mutable string
        StringBuffer tmpString = new StringBuffer();
        
        // Cycle array
        for (int i=startIdx; i<endIdx; i++) {
            tmpString.append(letters[i]);
        }
        return tmpString.toString();
    }
    
    public List<String> findRepeatedDnaSequences(String s) {
        
        // If string is less than 10 characters long, return an empty list
        if (s.length() < 10) {return new ArrayList();}
        
        // Create a hashmap that holds string and occurrences as key and value, respectively.
        HashMap<String, Integer> log = new HashMap();
        
        // Cycle string
        char[] letters = s.toCharArray();
        for (int i=0; i<letters.length; i++) {
            
            // Create a temporary string
            String tmpString = buildString(letters, i, i+10);
            
            // If function returned null, then there aren't any more 10 letter sequences
            if (tmpString == null) {break;}
            
            // Update key or add new key to hash map
            if (log.containsKey(tmpString)) {
                log.put(tmpString, log.get(tmpString) + 1);
            }
            else {
                log.put(tmpString, 1);
            }
        }
        
        // Create an array list
        ArrayList<String> ans = new ArrayList();
        
        // Iterate hash map's keys
        for (String curKey: log.keySet()) {
            
            // If key's value is more than 1, add it to array list
            if (log.get(curKey) > 1) {ans.add(curKey);}
        }
        return ans;
    }
}
