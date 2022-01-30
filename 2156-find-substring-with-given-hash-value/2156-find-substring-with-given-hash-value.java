class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int len = s.length();
        long weight = 1;
        for(int i = 0; i < k -1 ; i++) {
            weight = (weight * power) % modulo;
        }
        int r = len - 1;
        long hash = 0;
        String res = "";
        for(int i = len - 1; i >= 0; i--) {
            int val = s.charAt(i) - 'a' + 1;
            hash = (hash * power % modulo + val) % modulo;
            if(r - i + 1 == k) {
                if(hash == hashValue) {
                    res = s.substring(i, r + 1);
                }
                //remove head
                hash = (hash + modulo - (s.charAt(r--) - 'a' + 1) * weight % modulo) % modulo;
            }
        }
        return res;
    }
}