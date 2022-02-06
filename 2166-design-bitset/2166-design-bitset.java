class Bitset {
    Set<Integer> one;
    Set<Integer> zero;
    int size;
    public Bitset(int size) {
        this.size = size;
        one = new HashSet<>();
        zero = new HashSet<>();
        for(int i = 0; i < size; i++) zero.add(i);
    }
    
    public void fix(int idx) {
        one.add(idx);
        zero.remove(idx);
    }
    
    public void unfix(int idx) {
        zero.add(idx);
        one.remove(idx);
    }
    
    public void flip() {
        Set<Integer> set = one;
        one = zero;
        zero = set;
    }
    
    public boolean all() {
        return one.size() == size;
    }
    
    public boolean one() {
        return one.size() >= 1;
    }
    
    public int count() {
        return one.size();
    }
    
    public String toString() {
        char[] arr = new char[size];
        Arrays.fill(arr, '0');
        for(int i : one) {
            arr[i] = '1';
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            if(one.contains(i)) sb.append('1');
            else sb.append('0');
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */