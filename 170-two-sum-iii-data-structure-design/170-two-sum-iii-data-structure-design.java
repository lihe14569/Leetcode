class TwoSum {
    Map<Integer, Integer> map;
    public TwoSum() {
        map = new HashMap<>();
    }
    
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        if(map.size() == 0) return false;
        for(int k : map.keySet()) {
            int j = value - k;
            if(map.containsKey(j)){
                if(j == k && map.get(k) > 1) return true;
                else if(j != k) return true;
            } 
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */