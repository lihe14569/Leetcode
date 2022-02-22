class Solution {
    public int titleToNumber(String columnTitle) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c = 'A'; c <= 'Z'; c++) {
            map.put(c, c- 'A' + 1);
        }
        int n = columnTitle.length();
        int res = 0;
        for(int i = n - 1; i >= 0; i--) {
            res += map.get(columnTitle.charAt(i)) * Math.pow(26, n - 1 - i);
        }
        return res;
    }
}