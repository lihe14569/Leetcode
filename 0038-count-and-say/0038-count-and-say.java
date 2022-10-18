class Solution {
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder();
        StringBuilder next = new StringBuilder();
        curr.append('1');
        
        while(n != 1) {
            int i = 0;
            while(i < curr.length()) {
                int j = i;
                while(j < curr.length() && curr.charAt(i) == curr.charAt(j)) j++;
                next.append(j - i);
                next.append(curr.charAt(i));
                i = j;
            }
            curr = next;
            next = new StringBuilder();
            n--;
        }
        return curr.toString();
    }
}