// https://leetcode.com/problems/smallest-number-in-infinite-set/

class SmallestInfiniteSet {
    
    // Create a TreeSet and a variable to hold the smallest number
    // NOTE: TreeSet is a self-balancing BST - similar to a Red-Black tree
    TreeSet<Integer> set;
    int smallestNum;

    public SmallestInfiniteSet() {
        
        // Initialize class variables
        set = new TreeSet<>();
        smallestNum = 1;
    }
    
    public int popSmallest() {
        
        // OBJECTIVE: Pop smallest element from set or return smallestNum
        
        // If tree isn't empty, pop head element
        if (!set.isEmpty()) {
            return set.pollFirst();
        }
        
        // If tree is empty, return smallest number based on variable
        smallestNum++;
        return smallestNum - 1;
    }
    
    public void addBack(int num) {
        
        // OBJECTIVE: Add num to tree if it doesn't exist
        
        // If num is less than smallestNum and doesn't exist in set, add it to set
        if (num < smallestNum && !set.contains(num)) {
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
