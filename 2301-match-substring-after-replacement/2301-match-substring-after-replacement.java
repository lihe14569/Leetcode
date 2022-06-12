class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        int m = s.length(), n = sub.length();
        Set<Integer> es = new HashSet<>();
        for(char[] e : mappings) {
            es.add(e[0]*256 + e[1]);
        }
        for(int i = 0; i + n - 1 < m; i++) {
            boolean flag = true;
            for(int j = 0; j < n; j++) {
                if(s.charAt(i + j) != sub.charAt(j) && !es.contains(sub.charAt(j)*256 + s.charAt(i + j))) {
                    char c1 = s.charAt(i + j);
                    char c2 = sub.charAt(j);
                    flag = false;
                    break;
                }  
            }
            if(flag) return true;
        }
        return false;
    }
}