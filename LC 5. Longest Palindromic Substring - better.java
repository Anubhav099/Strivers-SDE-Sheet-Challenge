class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i), s2 = extend(s, i, i + 1);
            // assuming odd and even len palindromes
            if (s1.length() > max.length()) max = s1;
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }
    
    private String extend(String s, int i, int j) {
        // expand in both direction util we cross both side boundaries
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) break;
            i--; j++;
        }
        return s.substring(i + 1, j);
        // (i + 1, j) compensates for the condition where the while loop broke.
        // e.g. if it broke at (3, 6)
        // it means, (4, 5) was a palindrome
        // or if it broke at (4,4)
        // it means (5,3) is a palindrome which is an empty string
        // substring method ignores j and substring is actually created for (i+1, j-1)
    }
}