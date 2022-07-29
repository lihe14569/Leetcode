class Solution {
    public int[] plusOne(int[] digits) {
        
        List<Integer> res = new ArrayList<>();
        int n = digits.length;
        int val = (digits[n - 1] + 1) % 10;
        int carry = (digits[n - 1] + 1) / 10;
        res.add(val);
        for(int i = digits.length - 2; i >= 0; i--) {
            val = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            res.add(val);
        }
            
        if(carry == 1) res.add(1);
        int[] arr = new int[res.size()];
        for(int i = res.size() - 1; i >= 0; i--) {
            arr[res.size() - i - 1] = res.get(i);
        }
        return arr;
    }
}