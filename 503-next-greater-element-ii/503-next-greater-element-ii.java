class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] arr = new int[nums.length * 2];
        int n = nums.length;
        for(int i = 0; i < arr.length; i++) arr[i] = nums[i % n];
        
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i ++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[stack.pop() % n] = arr[i];
            }
            stack.push(i);
        }
        return res;
    }
}