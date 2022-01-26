class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int l = 0, minStart = 0, minLen = Integer.MAX_VALUE, cnt = t.length();
        for(int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            if(map.containsKey(c1)) {
                if(map.get(c1) > 0) cnt--;
                map.put(c1, map.get(c1) - 1);
            }
            
            while(cnt== 0) {
                if(i - l + 1 < minLen) {
                    minLen = i - l + 1;
                    minStart = l;
                }
                char c2 = s.charAt(l);
                if(map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if(map.get(c2) > 0) cnt++;
                }
                l++;
            }
        }
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart + minLen);
    }
}