class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> map;
    int max;
    public FreqStack() {
        freq = new HashMap<>();
        map = new HashMap<>();
        max = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        max = Math.max(max, f);
        map.computeIfAbsent(f, s -> new Stack<>()).push(val);
        
    }
    
    public int pop() {
        int num = map.get(max).pop();
        freq.put(num, max - 1);
        if(map.get(max).isEmpty())
            max--;
        return num;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */