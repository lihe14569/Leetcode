class Solution {
    public int longestSubstring(String s, int k) {
        //1.window is number of unique character
        //2. variable cnt to record repeating characters
        int n = s.length(), res = 0;

        for(int i = 1; i <= 26; i++) {
            Map<Character, Integer> map = new HashMap<>();
            int cnt = 0;
            int l = 0;
            for(int j = 0; j < n; j++) {
                char c1 = s.charAt(j);
                map.put(c1, map.getOrDefault(c1, 0) + 1);
                if(map.get(c1) == k) cnt++;
                while(map.size() > i) {
                    char c2 = s.charAt(l);
                    if(map.get(c2) == k) cnt--;
                    map.put(c2, map.get(c2) - 1);
                    if(map.get(c2) == 0) map.remove(c2);
                    l++;
                }
    //注意：最后出窗口的时候，可能window size 小于i,所以要比较map size和cnt
                if(map.size() == cnt) 
                    res = Math.max(res, j - l + 1);
            }
        }
        return res;
    }
}