class Solution {
    public int divide(int x, int y) {
        List<Long> bin = new ArrayList<>();
        boolean neg = false;
        if((x > 0 && y < 0) || (x < 0 && y > 0)) neg = true;
        long a = Math.abs((long)x), b = Math.abs((long)y); 
        for(long i = b; i <= (long)a; i = i+ i) bin.add(i);
        long res = 0;
        
        for(int i = bin.size() - 1; i >=0; i--) {
            if(a >= bin.get(i)) {
                a -= bin.get(i);
                res += 1L << i;
            }
        } 
        if(neg) res = -res; 
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int)res;
    }
}