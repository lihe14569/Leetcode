class OrderedStream {
    String[] stream;
    int ptr;
    public OrderedStream(int n) {
        stream = new String[n];
        ptr = 0;
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<>();
        stream[idKey - 1] = value;
        while(ptr < stream.length && stream[ptr] != null) {
            res.add(stream[ptr++]);
        }
        return res;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */