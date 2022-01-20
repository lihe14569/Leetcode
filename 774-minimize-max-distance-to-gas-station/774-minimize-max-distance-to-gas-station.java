class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double l = 0, r = 1e8;
        while(l + 1e-6 < r) {
            double m = l + (r - l) / 2.0;
            if(canPut(stations, m, k))
                r = m;
            else 
                l = m;
        }
        return l;
    }
    
    public boolean canPut(int[] stations, double m, int k) {
        int res = 0;
        for(int i = 1; i < stations.length; i++) {
            res += Math.ceil((stations[i] - stations[i - 1]) / m) - 1;
        }
        return res <= k;
    }
}