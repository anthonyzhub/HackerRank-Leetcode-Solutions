/*
https://leetcode.com/problems/time-based-key-value-store/
https://youtu.be/fu2cD_6E8Hw?si=OouShAvWazy8j6iX
*/

class CustomObject {
    private String value;
    private int timestamp;

    public CustomObject(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getValue() {return value;}

    public int getTimestamp() {return timestamp;}
}

class TimeMap {

    private HashMap<String, List<CustomObject>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            List<CustomObject> entries = map.get(key);
            
            CustomObject newEntry = new CustomObject(value, timestamp);
            entries.add(newEntry);
            map.put(key, entries);
        } else {
            List<CustomObject> newList = new ArrayList<>();
            CustomObject newEntry = new CustomObject(value, timestamp);
            
            newList.add(newEntry);
            map.put(key, newList);
        }
    }

    private CustomObject findClosestEntry(List<CustomObject> entries, int timestamp) {
        int leftPtr = 0;
        int rightPtr = entries.size() - 1;

        CustomObject res = null;

        while (leftPtr <= rightPtr) {
            int midPtr = leftPtr + ((rightPtr - leftPtr) / 2);
            CustomObject midEntry = entries.get(midPtr);

            // NOTE: <= is combined because if an entry doesn't exist, then return the closest entry.
            if (midEntry.getTimestamp() <= timestamp) {
                res = midEntry;
                leftPtr = midPtr + 1;
            } else {
                rightPtr = midPtr - 1;
            }
        }

        return res;
    }
    
    public String get(String key, int timestamp) {
        if (map == null || !map.containsKey(key)) {
            return "";
        }

        List<CustomObject> entries = map.get(key);
        CustomObject closestEntry = findClosestEntry(entries, timestamp);
        return closestEntry == null ? "" : closestEntry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
