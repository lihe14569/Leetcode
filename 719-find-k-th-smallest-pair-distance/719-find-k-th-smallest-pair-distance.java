class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        //sort
        Arrays.sort(nums);
        int N = nums[nums.length - 1];
        
        int n = nums.length;
        int[] buckets = new int[N + 1];
        
        //put all pairs and its distance into buckets
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                buckets[nums[j] - nums[i]]++;
            }
        }
        for(int i = 0; i <= N; i++) {
            k -= buckets[i];
            if(k <= 0) return i;
        }
        return 0;
    }
}