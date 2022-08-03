class MyCalendar {
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
         map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer ceiling = map.ceilingKey(start);
        Integer floor = map.floorKey(start);
        
        if((ceiling == null || ceiling >= end) && (floor == null || map.get(floor) <= start)) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */