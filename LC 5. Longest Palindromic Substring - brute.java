class Solution {
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            int strLen = s.length() - 1 - i;
            for (int start = 0, end = strLen; end < s.length(); start++, end++) {
                if (checkPal(s, start, end)) {
                    return s.substring(start, end + 1);
                }
            }
        }
        return "";
    }

    boolean checkPal(String s, int start, int end) {
        while (start<=end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}