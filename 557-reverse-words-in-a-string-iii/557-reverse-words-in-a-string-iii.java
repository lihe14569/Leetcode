class Solution {
    public String reverseWords(String s) {
        StringBuilder sb= new StringBuilder();
        for(String word : s.split(" ")) {
            char[] chrs = word.toCharArray();
            reverse(chrs);
            sb.append(chrs);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public void reverse(char[] chrs) {
        int i = 0, j = chrs.length - 1;
        while(i < j) {
            char c = chrs[i];
            chrs[i] = chrs[j];
            chrs[j] = c;
            i++;
            j--;
        }
    }
}