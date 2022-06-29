class SummaryRanges {
    TreeMap<Integer, Integer> intervals;
    public SummaryRanges() {
        intervals = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(intervals.isEmpty()) {
            intervals.put(val, val);
            return;
        }
        Map.Entry<Integer, Integer> pre = intervals.floorEntry(val);
        Map.Entry<Integer, Integer> post = intervals.ceilingEntry(val);
        int left = val, right = val;
        if(pre != null && pre.getKey() <= val && pre.getValue() >= val) {
            return;
        }
        if(pre != null && pre.getValue() + 1 == val) {
            left = pre.getKey();
            intervals.remove(pre.getKey());
        }
        if(post != null && val + 1 == post.getKey()) {
            right = post.getValue();
            intervals.remove(post.getKey());
        }
        intervals.put(left, right);
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[intervals.size()][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> e : intervals.entrySet()) {
            res[i][0] = e.getKey();
            res[i][1] = e.getValue();
            i++;
        } 
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */