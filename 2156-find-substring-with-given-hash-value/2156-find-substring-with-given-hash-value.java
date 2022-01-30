class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        long weight = 1;
        for(int i = 0; i < k - 1; i++) weight = (weight * power) % modulo;
        String res = "";
        int r = n - 1;
        long hash = 0;
        
        for(int i = n -1; i>=0; i--) {
            int val = s.charAt(i) - 'a' + 1;
            hash = (hash * power % modulo + val) % modulo;
            if(r - i + 1 == k) {
                if(hash == hashValue)
                    res = s.substring(i, r + 1);
                //remove higher order element
                hash = (hash + modulo - (s.charAt(r--) - 'a' + 1) * weight % modulo) % modulo;
            }
        }
        return res;
    }
}