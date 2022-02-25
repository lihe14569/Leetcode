class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        Arrays.sort(boxTypes, (a, b) -> (b[1] - a[1]));
        for(int i = 0; i < boxTypes.length; i++) {
            int size = Math.min(truckSize, boxTypes[i][0]);
            res += size * boxTypes[i][1];
            truckSize -= size;
            if(truckSize == 0) break;
        }
        return res;
    }
}