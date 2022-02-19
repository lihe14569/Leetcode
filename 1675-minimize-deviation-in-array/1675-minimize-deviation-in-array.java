class Solution {
    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums) {
            set.add(num % 2 == 0 ? num : num * 2);
        }
        int dev = set.last() - set.first();
        while(dev > 0 && set.last() % 2 == 0) {
            int max = set.last();
            set.remove(max);
            set.add(max/ 2);
            dev = Math.min(dev, set.last() - set.first());
        }
        return dev;
    }
}