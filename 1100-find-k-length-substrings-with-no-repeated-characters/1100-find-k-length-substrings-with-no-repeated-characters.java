class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        //sliding window
        int res = 0;
        int l = 0; 
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            if(i - l + 1 > k) {
                char c2 = s.charAt(l);
                map.put(c2, map.get(c2) - 1);
                if(map.get(c2) == 0) map.remove(c2);
                l++;
            }
            if(map.size() == k && i - l + 1 == k) res++;
        }
        return res;
    }
}