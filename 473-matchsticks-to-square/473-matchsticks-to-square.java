class Solution {
    int[] ms;
    int n;
    boolean[] seen;
    public boolean makesquare(int[] matchsticks) {
        n = matchsticks.length;
        ms = matchsticks;
        Arrays.sort(ms);
        for(int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = ms[i];
            ms[i] = ms[j];
            ms[j] = temp;
        }
        int sum = 0;
        for(int num : ms) sum += num;
        if(sum % 4 != 0) return false;
        sum /= 4;
        seen = new boolean[n];
        return dfs(0, 0, sum, 0);
    }
    public boolean dfs(int start, int currLen, int length, int count) {
        if(count == 3) return true;
        if(currLen == length) return dfs(0, 0, length, count + 1);
        for(int i = 0; i < n; i++) {
            if(seen[i]) continue;
            if(currLen + ms[i] <= length) {
                seen[i] = true;
                if(dfs(start + 1, currLen + ms[i], length, count)) return true;
                seen[i] = false;
            }
            if(currLen == 0 || currLen + ms[i] == length) return false;
            while(i + 1 < n && ms[i + 1] == ms[i]) i++;
        }
        return false;
    }
}