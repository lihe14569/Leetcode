class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r= 1000000000;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(canEat(piles, m, h)) {
                r = m;
            } else 
                l = m + 1;
        }
        return l;
    }
    
    public boolean canEat(int[] piles, int m, int h) {
        int res = 0;
        for(int p : piles) {
            res += (p + m  -1) / m;
        }
        return res <= h;
    }
}