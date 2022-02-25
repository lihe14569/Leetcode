class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.min(v1.length, v2.length);
        for(int i = 0; i < n; i++) {
            int s1 = Integer.parseInt(v1[i]);
            int s2 = Integer.parseInt(v2[i]);
            if(s1 < s2 ) return -1;
            else if(s1 > s2) return 1;
        }
        while(v1.length > n) {
            if(Integer.parseInt(v1[n++]) != 0)
                return 1;
        }
        while(v2.length > n) {
           if(Integer.parseInt(v2[n++]) != 0) 
                return -1;
        }
        return 0;
    }
}