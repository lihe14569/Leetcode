class Solution {
    public long distinctNames(String[] ideas) {
        
        Set<String>[] cnt = new Set[26];
        for(int i = 0; i <26; i++) cnt[i] = new HashSet<>();
        for(String s :ideas) {
            int c = s.charAt(0) - 'a';
            cnt[c].add(s.substring(1));
        }
        long res= 0;
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                Set<String> temp = new HashSet<>(cnt[i]);
                temp.retainAll(cnt[j]);
                int len = temp.size();
                res += (cnt[i].size() - len) * (cnt[j].size() - len);
            }
        }
        return res;
    }
}