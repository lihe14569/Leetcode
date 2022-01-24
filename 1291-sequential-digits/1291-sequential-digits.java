class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        //sliding window
        String s = "123456789";
        int n = 10;
        List<Integer> res = new ArrayList<>();
        
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for(int i = lowLen; i <= highLen; i++) {
            for(int j = 0; j  < n - i; j++) {
                int val = Integer.parseInt(s.substring(j, j + i));
                if(val >= low && val <= high) res.add(val);
            }
        }
        return res;
    }
}