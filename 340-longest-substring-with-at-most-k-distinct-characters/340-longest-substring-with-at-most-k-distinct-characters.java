class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int n = s.length();
        int res = 0;
        for(int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            while(map.size() > k) {
                char c2 = s.charAt(l);
                map.put(c2, map.get(c2) - 1);
                if(map.get(c2) == 0) map.remove(c2);
                l++;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}