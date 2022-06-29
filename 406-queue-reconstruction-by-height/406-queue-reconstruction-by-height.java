class Solution {
    public int[][] reconstructQueue(int[][] p) {
        Arrays.sort(p, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> q = new ArrayList<>();
        for(int i = 0; i < p.length; i++) {
            q.add(p[i][1], p[i]);
        }
        return q.toArray(new int[q.size()][2]);
    }
}