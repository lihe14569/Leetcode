class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        UF uf = new UF(n);
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(valToIndex.containsKey(nums[i])) continue;
            valToIndex.put(nums[i], i);
            if(valToIndex.containsKey(nums[i] - 1))
                uf.union(i, valToIndex.get(nums[i] - 1));
            if(valToIndex.containsKey(nums[i] + 1))
                uf.union(i, valToIndex.get(nums[i] + 1));
        }
        return uf.findMax();
    }
}
class UF {
    int[] parent;
    int [] size;
    int n;
    public UF(int n) {
        this.n = n;
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i]= i;
            size[i] = 1;
        }
    }
    public int find(int x) {
        if(parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if(rootx == rooty) return;
        if(size[rootx] <= size[rooty]) {
            parent[rootx] = rooty;
            size[rooty]+= size[rootx];
        } else {
            parent[rooty] = rootx;
            size[rootx] += size[rooty];
        } 
    }
    public int findMax() {
        int res = 0;
        for(int s : size) {
            res = Math.max(res, s);
        }
        return res;
    }
}