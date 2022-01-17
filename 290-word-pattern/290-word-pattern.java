class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> pmap = new HashMap<>();
        Map<String, Character> smap = new HashMap<>();
        
        String[] sArr = s.split(" ");
        if(pattern.length() != sArr.length) return false;
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = sArr[i];
            if(!pmap.containsKey(c)) {
                if(smap.containsKey(str)) return false;
                else {
                    pmap.put(c, str);
                    smap.put(str, c);
                }
            } else {
                if(!smap.containsKey(str)) return false;
                else {
                    if(!pmap.get(c).equals(str) || smap.get(str) != c)
                        return false;
                }
            }
        }
        return true;
    }
}