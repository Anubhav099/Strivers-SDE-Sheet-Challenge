class Solution {
    public boolean isAnagram(String s, String t) {
        int freq[] = new int[26];

        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)
            if(--freq[t.charAt(i) - 'a'] < 0)
		return false;

        return s.length() == t.length();
    }
}