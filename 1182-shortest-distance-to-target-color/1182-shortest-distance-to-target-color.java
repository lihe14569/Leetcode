class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < colors.length; i++) {
            map.putIfAbsent(colors[i], new ArrayList<>());
            map.get(colors[i]).add(i);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < queries.length; i++) {
            int color = queries[i][1];
            int target = queries[i][0];
            if(!map.containsKey(color)) res.add(-1);
            else {
                List<Integer> lst= map.get(color);
                int idx = Collections.binarySearch(lst,target);
                if(idx < 0) idx = -idx - 1;
                if(idx == 0) res.add(lst.get(0) - target);
                else if(idx == lst.size()) res.add(target - lst.get(lst.size() - 1));
                else {
                    int left = target - lst.get(idx - 1);
                    int right = lst.get(idx) - target;
                    res.add(Math.min(left, right));
                }
            }
        }
        return res;
    }
}