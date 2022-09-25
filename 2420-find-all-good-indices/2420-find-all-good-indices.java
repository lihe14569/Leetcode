class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] inc = new int[n], dec = new int[n];
        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);
        int prev = -1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[i - 1]) {
                inc[i] = inc[i - 1] + 1;
                dec[i] = dec[i - 1] + 1;
            }else if (nums[i] < nums[i - 1]) {
                dec[i] = dec[i - 1] + 1;
            }else {
                inc[i] = inc[i - 1] + 1;
            }
        }
        List<Integer> good = new ArrayList<>();
        for (int i = k; i < n - k; ++i) {
            if (dec[i - 1] >= k && inc[i + k] >= k) {
                good.add(i);
            }
        }
        return good;
    }
}