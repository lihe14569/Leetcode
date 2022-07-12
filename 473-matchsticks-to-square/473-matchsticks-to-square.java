class Solution {
    public boolean makesquare(int[] ms) {
        int n = ms.length;
        if(n < 4) return false;
        int sum = 0;
        for(int num : ms) sum += num;
        if(sum % 4 != 0) return false;
        Arrays.sort(ms);
        return dfs(ms, new int[4], n - 1, sum / 4);
    }
    public boolean dfs(int[] ms, int[] partition, int index, int target) {
        if(index == -1) {
            if(partition[0] == target && partition[1] == target && partition[2] == target) return true;
            return false;
        }
        for(int i = 0; i < 4; i++) {
            if(partition[i] + ms[index] > target) continue;
            partition[i] += ms[index];
            if (dfs(ms, partition, index - 1, target))
                return true;
            partition[i] -= ms[index];
        }
        return false;
    }
}