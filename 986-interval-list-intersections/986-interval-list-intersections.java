class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list=  new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < firstList.length && p2 < secondList.length) {
            int start = Math.max(firstList[p1][0], secondList[p2][0]);
            int end = Math.min(firstList[p1][1], secondList[p2][1]);
            if(end >= start) {
                list.add(new int[]{start, end});
            }
            if(firstList[p1][1] < secondList[p2][1]) {
                p1++;
            } else {
                p2++;
            }
        }
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}