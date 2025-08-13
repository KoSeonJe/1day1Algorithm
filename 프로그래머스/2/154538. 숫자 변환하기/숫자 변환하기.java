class Solution {
    public int solution(int x, int y, int n) {
        if (x >= y) return x == y ? 0 : -1;
        
        int[] dp = new int[y + 1];
        for (int i = 0; i <= y; i++) dp[i] = -1;
        dp[x] = 0;
        
        for (int i = x; i <= y; i++) {
            if (dp[i] == -1) continue;
            
            if (i + n <= y && (dp[i + n] == -1 || dp[i + n] > dp[i] + 1)) 
                dp[i + n] = dp[i] + 1;
            if (i * 2 <= y && (dp[i * 2] == -1 || dp[i * 2] > dp[i] + 1)) 
                dp[i * 2] = dp[i] + 1;
            if (i * 3 <= y && (dp[i * 3] == -1 || dp[i * 3] > dp[i] + 1)) 
                dp[i * 3] = dp[i] + 1;
        }
        
        return dp[y];
    }

}