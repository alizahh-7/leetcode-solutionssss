class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = Integer.MIN_VALUE / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int prod = nums1[i] * nums2[j];
                dp[i + 1][j + 1] = Math.max(
                        Math.max(dp[i][j] + prod, prod),
                        Math.max(dp[i][j + 1], dp[i + 1][j])
                );
            }
        }
        return dp[n][m];
    }
}
