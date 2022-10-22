class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : t.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        int l = 0;
        int cnt = t.length(), minStart = 0, minLen = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if(freq.containsKey(c1)) {
                if(freq.get(c1) > 0) cnt--;
                freq.put(c1, freq.get(c1) - 1);
            }
            while(cnt == 0) {
                if(i - l + 1 < minLen) {
                    minLen = i - l + 1;
                    minStart = l;
                }
                char c2 = s.charAt(l);
                if(freq.containsKey(c2)) {
                    freq.put(c2, freq.get(c2) + 1);
                    if(freq.get(c2) > 0) cnt++;
                }
                l++;
            }
            
        }
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart + minLen);
    }
}