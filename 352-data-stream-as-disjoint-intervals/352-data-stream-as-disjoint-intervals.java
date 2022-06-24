class SummaryRanges {
    TreeMap<Integer, Integer> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(map.isEmpty()) {
            map.put(val, val);
            return;
        }
        Map.Entry<Integer, Integer> pre = map.floorEntry(val);
        Map.Entry<Integer, Integer> post = map.ceilingEntry(val);
        int left = val, right = val;
        if(pre != null && pre.getKey() <= left &&pre.getValue() >= right) {
            return;
        }
        if(pre != null && pre.getValue() + 1 == val) {
            left  = pre.getKey();
            map.remove(pre.getKey());
        }
        if(post != null && val + 1 == post.getKey()) {
            right = post.getValue();
            map.remove(post.getKey());
        }
        map.put(left, right);
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[i][0] = entry.getKey();
            res[i][1] = entry.getValue();
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