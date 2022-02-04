class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] rm) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int[] interval : intervals) {
           if(interval[1] < rm[0] || interval[0] > rm[1])
               res.add(Arrays.asList(interval[0], interval[1]));
            else {
                if(interval[0] < rm[0]) 
                    res.add(Arrays.asList(interval[0], rm[0]));
                if(interval[1] > rm[1]) 
                    res.add(Arrays.asList(rm[1], interval[1]));
            }
        }
        return res;
    }
}