class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //COUNTING SORT
        int[] arr = new int[1001];
        for(int[] box : boxTypes) {
            arr[box[1]] += box[0];
        }
        int res = 0;
        for(int i = 1000; i >= 1; i--) {
            if(arr[i] == 0) continue;
            int min = Math.min(arr[i], truckSize);
            res += min * i;
            truckSize -= min;
            if(truckSize == 0) break;
        }
        return res;
    }
}