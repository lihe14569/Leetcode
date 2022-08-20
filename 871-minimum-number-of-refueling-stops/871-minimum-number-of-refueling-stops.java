class Solution {
public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int i = 0, n = stations.length, res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        while (startFuel < target) {
            while ( i < n && startFuel >= stations[i][0]){
                queue.add(stations[i++][1]);
            }
            if (queue.size() == 0) return -1;
            startFuel += queue.poll();
            res++;
        }
        return res;
    }

}