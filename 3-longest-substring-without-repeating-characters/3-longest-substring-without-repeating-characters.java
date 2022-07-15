class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, res = 0;
        for(int i = 0;i < s.length(); i++) {
            char c1 = s.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            while(map.get(c1) > 1) {
                char c2 = s.charAt(l);
                map.put(c2, map.get(c2) - 1);
                l++;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}