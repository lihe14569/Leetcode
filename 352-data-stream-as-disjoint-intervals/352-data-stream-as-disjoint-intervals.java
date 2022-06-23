class SummaryRanges {

    TreeMap<Integer, Integer> intervals;
    public SummaryRanges() {
        this.intervals = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if (intervals.isEmpty()) {
            intervals.put(val, val);
            return;
        }
        
        Map.Entry<Integer, Integer> pre = intervals.floorEntry(val);
        Map.Entry<Integer, Integer> post = intervals.ceilingEntry(val);
        
        int left = val, right = val;
        
        // if entry already exists in an interval
        if (pre != null && pre.getKey() <= left && pre.getValue() >= left)
            return;
        
		// if value can be merged with a floor entry
        if (pre != null && pre.getValue() + 1 == val) {
            left = pre.getKey();
            intervals.remove(pre.getKey()); // remove old interval
        }
        
		// if the value can be merged with a ceiling entry
        if (post != null && val + 1 == post.getKey()) {
            right = post.getValue();
            intervals.remove(post.getKey()); // remove old entry
        }
        
        intervals.put(left, right); // add the new interval to sorted map
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[intervals.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            res[index][0] = entry.getKey();
            res[index][1] = entry.getValue();
            index++;
        }
        return res;
    }
}