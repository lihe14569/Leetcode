class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++) {
            String temp = "";
            for(int j = 0; j < s.length(); j++) {
                int k = j;
                while(k < s.length() && s.charAt(j) == s.charAt(k)) k++;
                temp += String.valueOf(k - j) + s.charAt(j);
                j = k - 1; //易错点! 因为下一for loop 还要+1
            }
            s=temp;
        }
        return s;
    }
}