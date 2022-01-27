class Solution {
    public int findMaximumXOR(int[] nums) {
        //bitwise + hashset
        int n = nums.length;
        int max = 0;
        for(int num : nums) max = Math.max(max, num);
        //记住java method
        int len = (Integer.toBinaryString(max).length()); 
        
        int maxXor = 0, currXor = 0;
        for(int i = len - 1; i >= 0; i--) {
            maxXor <<= 1;
            Set<Integer> prefix = new HashSet<>();
            currXor = maxXor | 1;
            for(int num : nums) prefix.add(num >> i);
            for(int p : prefix) {
                if(prefix.contains(currXor^p)) {
                    maxXor = currXor;
                    break;
                }
            }
        }
        return maxXor;
    }
}