package dp;

class LongestSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dp[i][i]=false;
        for(int i=0;i<n;i++)
            dp[i][i]=true;
        for(int i=0;i<n-1;i++)dp[i][i+1]=s.charAt(i)==s.charAt(i+1);
        for(int i=n-2;i>=0;i--){
            for(int j=1;j<n;j++){
                if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j]=true;
                }
            }
        }
        int maxLen=1,start=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(dp[i][j] && j-i+1 > maxLen){
                    maxLen=j-i+1;
                    start=i;
                }
            }
        }
        return s.substring(start,maxLen);
    }
}
