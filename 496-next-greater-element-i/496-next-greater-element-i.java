class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = nums2.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums2[i] >= nums2[stack.peek()]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : nums2[stack.peek()]);
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}