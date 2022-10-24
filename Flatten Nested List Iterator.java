// https://leetcode.com/problems/flatten-nested-list-iterator/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    public ArrayList<Integer> res;
    public int idx;
    public int size;
    
    public void flatten(List<NestedInteger> nestedList) {
        
        /*
        OBJECTIVE: Add all integer elements to res. If an element is a list, make a recursive call
        
        Time Complexity: O(2^n) where n = length of nestedList. This function handles integers and lists.
                        If ith element is an integer, that integer gets added to res. If it is a list, a
                        recursive call is made.
                        
                        I.e., Each element is either a list or an integer. So, each element has 2 choices
                        and the decision tree is expanded.
                        
        Space Complexity: O(2^n). The same reasoning as time complexity. If the ith element is a list, the
                        memory stack gets bigger
        */
        
        // Iterate nestedList
        for (int i=0; i<nestedList.size(); i++) {
            
            // If ith element is a list, make a recursive call
            if (!nestedList.get(i).isInteger()) {
                flatten(nestedList.get(i).getList());
            }
            
            // If ith element is an integer, add it to res
            else {
                res.add(nestedList.get(i).getInteger());
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        
        // Allocate memory for res
        res = new ArrayList<Integer>();
        
        // Flatten nested list
        flatten(nestedList);
        
        // Create an index pointer for res and get its size
        idx = 0;
        size = res.size();
    }

    @Override
    public Integer next() {
        
        // OBJECTIVE: If idx hasn't reached the end of res, return current element
        
        // Check if there are any more elements
        if (!hasNext()) {
            for (Integer i: this.res) {System.out.printf("%d ", i);}
            return null;
        }
        
        // Update pointer and return element
        idx++;
        return res.get(idx - 1);
    }

    @Override
    public boolean hasNext() {
        
        // OBJECTIVE: Return true if there are still more elements in res. If not, return false
        
        if (idx == size) {
            return false;
        }
        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
