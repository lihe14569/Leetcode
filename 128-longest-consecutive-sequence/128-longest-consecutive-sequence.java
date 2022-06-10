class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        DSU dsu = new DSU(n);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
          if(map.containsKey(nums[i])) continue;
          map.put(nums[i], i);
          if(map.containsKey(nums[i] - 1))
              dsu.union(i, map.get(nums[i] - 1));
          if(map.containsKey(nums[i] + 1))
              dsu.union(i, map.get(nums[i] + 1));
      }
        return dsu.findMax();
    }
}

class DSU {
    int[] parent;
    int[] size;
    
    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y) {
        int rootx = find(x), rooty = find(y);
        if(rootx == rooty)
            return;
        if(size[rootx] < size[rooty]) {
            parent[rootx] = rooty;
            size[rooty] += size[rootx];
        } else {
            parent[rooty] = rootx;
            size[rootx] += size[rooty];
        }
    }
    public int findMax() {
        return Arrays.stream(size).max().getAsInt();
    }
}

