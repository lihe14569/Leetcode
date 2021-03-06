class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a'] += 1;
            cnt[t.charAt(i) - 'a'] -= 1;
        }
        for(int val : cnt){
            if(val != 0) return false;
        }
        return true;
    }
}