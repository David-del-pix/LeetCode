class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // dp[n] = 0 by default

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int next = i + brainpower + 1;

            // Option 1: Solve this question
            long solve = points + (next < n ? dp[next] : 0);
            
            // Option 2: Skip this question
            long skip = dp[i + 1];

            // Take the maximum of both options
            dp[i] = Math.max(solve, skip);
        }

        return dp[0];
    }
}
