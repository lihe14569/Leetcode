class SummaryRanges {
    private TreeSet<int[]> intervalSet; 

    public SummaryRanges() {
        this.intervalSet = new TreeSet<>((a, b) -> a[0] - b[0]);
    }
    
    public void addNum(int val) {
        int[] valInterval = new int[]{val, val};
        int[] floor = intervalSet.floor(valInterval);
        if (floor != null) {
            if (floor[1] >= val) {
                return;
            } else if (floor[1] + 1 == val) {
                valInterval[0] = floor[0];
                intervalSet.remove(floor);
            }
        }
        int[] higher = intervalSet.higher(valInterval);
        if (higher != null && higher[0] == val + 1) {
            valInterval[1] = higher[1];
            intervalSet.remove(higher);
        }
        intervalSet.add(valInterval);
    }
    
    public int[][] getIntervals() {
        return this.intervalSet.toArray(new int[0][]);
    }
}