class Solution {
    public int minNumberOfHours(int ien, int iex, int[] en, int[] ex) {
        int n = en.length;
        int res = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += en[i];
        }
        res += sum >= ien ? sum - ien + 1 : 0;
        
        for(int e : ex) {
            if(e >= iex) {
                res += e - iex + 1;
                iex = e + 1;
            }
            iex += e;
        }
        return res;
    }
}