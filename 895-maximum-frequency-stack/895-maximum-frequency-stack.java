class FreqStack {
    Map<Integer, Integer> freq; 
    Map<Integer, Stack<Integer>> freqMap; 
    int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        freqMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        maxFreq = Math.max(maxFreq, f);
        freqMap.computeIfAbsent(f, s -> new Stack()).push(val);
    }
    
    public int pop() {
        int num = freqMap.get(maxFreq).pop();
        freq.put(num, maxFreq - 1);
        if(freqMap.get(maxFreq).size() == 0)
            maxFreq--;
        return num;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */