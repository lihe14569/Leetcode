class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while(i < version1.length() || j < version2.length()) {
            int x = i;
            int y = j;
            while(x < version1.length() && version1.charAt(x) != '.') x++;
            while(y < version2.length() && version2.charAt(y) != '.') y++;
            int val1 = x == i ? 0 : Integer.parseInt(version1.substring(i, x));
            int val2 = y == j ? 0 : Integer.parseInt(version2.substring(j, y));
            if(val1 < val2) return -1;
            else if(val1 > val2) return 1;
            i= x + 1;
            j = y + 1;
        }
        return 0;
    }
}