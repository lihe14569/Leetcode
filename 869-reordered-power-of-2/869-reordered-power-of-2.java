class Solution {
    public boolean reorderedPowerOf2(int n) {
        int cnt = 0;
        int start = 1;
        String s1 = String.valueOf(n);
        int[] map = new int[10];
        for(char c : s1.toCharArray()) map[c - '0']++;
        int len = s1.length();
        int upbound = 1000000001;
        while(start <= upbound) {
            String s2 = String.valueOf(start);
            if(s2.length() > len) break;
            if(s2.length() < len) {
                start *= 2;
                continue;
            }
            int[] nMap = new int[10];
            for(char c : s2.toCharArray()) nMap[c - '0']++;
            boolean match = true;
            for(int i = 0; i < 10; i++) {
                if(nMap[i] != map[i]) {
                    match = false;
                    break;
                }
            }
            if(match) return true;
            start *= 2;
        }
        return false;
    }
}