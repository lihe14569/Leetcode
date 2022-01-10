class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int m = a.length(), n = b.length();
        int carry = 0;
        int i = m - 1, j = n - 1;
        
        while(i >= 0 || j >= 0 || carry != 0) {
            int c1 = i >= 0 ? a.charAt(i--) - '0' : 0;
            int c2 = j >= 0 ? b.charAt(j--) - '0' : 0;
            int curr = (c1 + c2 + carry)  % 2;
            sb.append(curr);
            carry = (c1 + c2 + carry) / 2;
            
        }
        return sb.reverse().toString();
    }
}