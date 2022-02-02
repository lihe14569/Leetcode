class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] sArr = new int[26], pArr = new int[26];
        for(char c : p.toCharArray()) pArr[c - 'a']++;
        List<Integer> res=  new ArrayList<>();
        int l = 0, len = p.length();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sArr[c - 'a']++;
            if(i - l + 1 > len) {
                char c2 = s.charAt(l);
                sArr[c2 - 'a']--;
                l++;
            }
            if(Arrays.equals(sArr, pArr)) res.add(l);
        }
        return res;
    }
}