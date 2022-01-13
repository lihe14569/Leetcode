class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int l = 0;
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            while(!set.add(c1)) {
                char c2 = s.charAt(l);
                set.remove(c2);
                l++;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}