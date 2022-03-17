class Solution {
    public int maxDepth(String s) {
        int res = 0, balance = 0;
        for(char c :s.toCharArray()) {
            if(c == '(') {
                balance++;
            } else {
                res = Math.max(res, balance);
                if(c == ')')
                    balance--;
            }
        }
        return res;
    }
}