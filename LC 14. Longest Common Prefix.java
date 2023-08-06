class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder(strs[0]);
        for( String s: strs ) {
            if( ans.isEmpty() ) break;
            int len = s.length();
            // if the len of the string is less then the ans then we must reduce the length of ans
            // else if its greater than we just need to compare till the len of our ans
            if( len < ans.length() ) ans.delete( len, ans.length() );
            else len = ans.length();
            for( int i = 0; i < len; i++ )
                // as soon as a ch doesn't match, cut the rest of the ans and move to next iter
                if(ans.charAt(i) != s.charAt(i)) {
                    ans.delete(i, ans.length());
                    break;
                }
        }
        return ans.toString();
    }
}
// TC: O(n * len(strs[0]) , the len(strs[0]) is for delete operation.4
// SC: O(1);