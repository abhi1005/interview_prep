package dp;

public class LongestSubstring1 {
    public static void main(String[] args) {
        System.err.println(longestPalindrome("ccbbcc"));
    }
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int n = s.length();
        int maxLen=1,start=0;
        for(int i=0;i<n;i++){
            for(int l=i-1,r=i+1;l>=0 && r<n && s.charAt(l) == s.charAt(r); l--,r++){
                if(r-l+1 > maxLen){
                    maxLen = r-l+1;
                    start = l;
                }
            }
            for(int l=i-1,r=i; l>=0 && r<n && s.charAt(l) == s.charAt(r); l--,r++){
                if(r-l+1 > maxLen){
                    maxLen = r-l+1;
                    start = l;
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
}
