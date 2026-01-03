// https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/
// https://youtu.be/W-WvItFiWX8?si=-Cb0nNmzFllsVY5c
/*
Time Complexity: O(n) where n = the input integer.

Space Complexity: O(1)
*/

class Solution {
    public int numOfWays(int n) {
        long mod = 1000000007;

        // Base case if n = 1
        long aba = 6L;
        long abc = 6L;

        // Iterate from 2 to n
        for (long i = 2; i <= n; i++) {
            long nextABA = (3 * aba + 2 * abc) % mod;
            long nextABC = (2 * aba + 2 * abc) % mod;

            aba = nextABA;
            abc = nextABC;
        }

        return (int) ((aba + abc) % mod);
    }
}
