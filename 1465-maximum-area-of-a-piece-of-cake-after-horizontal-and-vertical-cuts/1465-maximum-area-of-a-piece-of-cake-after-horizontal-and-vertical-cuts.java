class Solution {
    public int maxArea(int h, int w, int[] hc, int[] vc) {
        
        Arrays.sort(hc);
        Arrays.sort(vc);
        int maxh = hc[0], maxw = vc[0];
        for(int i = 1; i < hc.length; i++) {
            maxh = Math.max(maxh, hc[i] - hc[i - 1]);

        }
        maxh = Math.max(maxh, h - hc[hc.length  - 1]);
        for(int i = 1; i < vc.length; i++) {
            maxw = Math.max(maxw, vc[i] - vc[i - 1]);
        }
        maxw =  Math.max(maxw, w - vc[vc.length  - 1]);
        // System.out.println(maxw);
        // System.out.println(maxh);
        return (int)((long)maxh * (long)maxw % 1000000007);
    }
}