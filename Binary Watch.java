// https://leetcode.com/problems/binary-watch/

class Solution {
    
    public int countOnes(String strToInspect) {
        
        // OBJECTIVE: Count how many times "1" appears in string
        
        int counter = 0;
        for (int i=0; i<strToInspect.length(); i++) {
            
            if (strToInspect.charAt(i) == '1') {
                counter++;
            }
        }
        
        return counter;
    }
    
    public List<String> readBinaryWatch(int turnedOn) {
        
        // Create a list
        List<String> combo = new ArrayList();
        
        // Iterate range
        for (int hour=0; hour<12; hour++) {
            for (int minute=0; minute<60; minute++) {
                
                // Convert hour and minute into binary form
                String curTime = Integer.toBinaryString(hour) + Integer.toBinaryString(minute);
                
                // Count how many 1's are in curTime
                int numOfOnes = countOnes(curTime);
                if (numOfOnes == turnedOn) {
                    
                    // Add hour to string
                    String tmp = Integer.toString(hour) + ":";
                    
                    // Add padding to 0
                    if (minute < 10) {
                        tmp += "0" + Integer.toString(minute);
                    }
                    else {
                        tmp += Integer.toString(minute);
                    }
                    
                    // Add acceptable time to list
                    combo.add(tmp);
                }
            }
        }
        
        return combo;
    }
}
