class Solution {
    public int longestSubstring(String s, int k) {
        //set unique number of characters
        int res = 0;
        for(int i = 1; i <= 26; i++) {
            Map<Character, Integer> map = new HashMap<>();
            int N = s.length();
            int left = 0, cnt = 0;
            for(int j = 0; j < s.length(); j++) {
                //进
                char c1 = s.charAt(j);
                map.put(c1, map.getOrDefault(c1, 0) + 1);
                if(map.get(c1) == k) cnt++;
                //出
                while(map.size() > i) {
                    char c2 = s.charAt(left);
                    if(map.getOrDefault(c2, 0) == k) cnt--;
                    map.put(c2, map.getOrDefault(c2, 0) - 1);
                    if(map.getOrDefault(c2, 0) <= 0) map.remove(c2);
                    left++;
                }
                //算
                int size = map.size();
                if(size == i && size == cnt)
                    res = Math.max(res, j - left + 1);
            }
        }
        return res;
    }
}