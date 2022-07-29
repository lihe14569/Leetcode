class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(String s : words) {
            if(match(s, pattern)) res.add(s);
        }
        return res;
    }
    public boolean match(String s, String pattern) {
        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = pattern.charAt(i);
            
            if(!m1.containsKey(c1)) m1.put(c1, c2);
            if(!m2.containsKey(c2)) m2.put(c2, c1);
            if(m1.get(c1) != c2 || m2.get(c2) != c1) return false;
        }
        return true;
    }
}