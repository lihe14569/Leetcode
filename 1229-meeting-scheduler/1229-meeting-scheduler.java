class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        List<Integer> res = new ArrayList<>();
        int p1 = 0, p2 = 0;
        int m = slots1.length, n = slots2.length;
        while(p1 < m && p2 < n) {
            int start = Math.max(slots1[p1][0], slots2[p2][0]);
            int end = Math.min(slots1[p1][1], slots2[p2][1]);
            if(end - start >= duration) {
                return List.of(start, start  + duration);
            } else if(slots1[p1][1] < slots2[p2][1]) {
                p1++;
            } else {
                p2++;
            }
        }
        return new ArrayList<Integer>();
    }
}