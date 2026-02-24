/*
https://leetcode.com/problems/accounts-merge/
https://youtu.be/6st4IxEF-90?si=vQMSn9xuQULpphkm

Time Complexity: O(m * n) where m & n is the size of the input matrix. The function is iterating through all entries of the given matrix.

Space Complexity: O(n) where n = length of parent in UnionFind
*/

class UnionFind {
    // IMPORTANT: List will hold a node representative. A node represents the "parent" email per account.
    // I.e., a person could have many email accounts, but only 1 will be used as representative/parent
    int[] parent;

    public UnionFind(int size) {
        this.parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int target) {
        if (parent[target] != target) {
            return findParent(parent[target]);
        }

        return target;
    }

    public void union(int nodeA, int nodeB) {
        int parentA = findParent(nodeA);
        int parentB = findParent(nodeB);
        if (parentA != parentB) {
            parent[parentA] = parentB;
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind unionFind = new UnionFind(accounts.size());
        
        // Create an emailToIndex Map where key = email, value = index of sublist in accounts matrix
        Map<String, Integer> emailToIndex = new HashMap<>();

        // Iterate accounts matrix
        for (int i = 0; i < accounts.size(); i++) {
            List<String> emails = accounts.get(i);

            // Only iterate emails
            // NOTE: The 1st entry of every sublist is the account name. We only care about the account's emails
            for (int j = 1; j < emails.size(); j++) {
                String curEmail = emails.get(j);

                // If curEmail doesn't exist in map, insert curEmail and index of parentList into map
                // If curEmail does exist (i.e., curEmail is associated with 2 accounts), then merge both nodes
                if (!emailToIndex.containsKey(curEmail)) {
                    emailToIndex.put(curEmail, i); // Key = email, Value = index of sublist
                } else {
                    Integer emailIdx = emailToIndex.get(curEmail); // Get index of sublist
                    unionFind.union(i, emailIdx); // Merge both nodes in UnionFind class
                }
            }
        }

        // Group emails by parent where key = parent email, value = set of children emails
        Map<Integer, Set<String>> merged = new HashMap<>();

        // Iterate emailToIndex map
        for (String curEmail: emailToIndex.keySet()) {
            // Get parent email of current email
            int emailIdx = emailToIndex.get(curEmail);
            int parentEmail = unionFind.findParent(emailIdx);

            // If map has parentEmail key, then add curEmail to it. If not, add new key and value before adding curEmail.
            merged.computeIfAbsent(parentEmail, curKey -> new TreeSet<>()).add(curEmail);
        }

        // Create return list
        List<List<String>> res = new ArrayList<>();

        for (int root: merged.keySet()) {
            List<String> subList = new ArrayList<>();

            // First, add account name from accounts to subList as per requirements
            subList.add(accounts.get(root).get(0));

            // Second, add all associated emails to subList
            subList.addAll(merged.get(root));

            // Third, add subList to return list
            res.add(subList);
        }

        return res;
    }
}
