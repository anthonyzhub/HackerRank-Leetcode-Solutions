/*
https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/
https://youtu.be/HGXKpk1dYWM?si=u72s8_d7Hl_asqj1

Time Complexity: O(h^2 * v^2) where h = size of hFences and v = size of vFences. We're iterating through all possible pairs in hFences and then vFences.

Space Complexity: O(h^2 * v^2) where h = size of hFences and v = size of vFences. We're storing all the valid pairs inside a set.
*/

class Solution {

    private Set<Integer> getEdges(int[] fences, int border) {

        // Create an array that holds all the fences
        int[] points = Arrays.copyOf(fences, fences.length + 2);

        // Manually add border points (hence fences.length + 2 from earlier)
        points[fences.length] = 1;
        points[fences.length + 1] = border;

        // Sorting will help with calculating the gaps between the edges
        // I.e., makes sure we're subtracting from left to right or top to bottom
        Arrays.sort(points);

        // Create a set that will hold the gaps between the edges
        Set<Integer> edges = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(points[j] - points[i]);
            }
        }

        return edges;
    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long res = -1;
        int mod = 1_000_000_007;

        // Get edges from horizontal and vertical fences
        Set<Integer> horizontalEdges = getEdges(hFences, m);
        Set<Integer> verticalEdges = getEdges(vFences, n);

        // Iterate both edges
        for (int curHor: horizontalEdges) {
            if (verticalEdges.contains(curHor)) {
                res = Math.max(res, (long) curHor * curHor);
            }
        }

        return res == -1 ? -1 : (int) (res % mod);
    }
}
