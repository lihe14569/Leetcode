class Solution {
    private static final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = 0, r = s.length() - 1;
        while(l <= r) {
            while(l <= r && !vowels.contains(sb.charAt(l))) l++;
            while(l <= r && !vowels.contains(sb.charAt(r))) r--;
            if(l >= r) break;
            swap(sb, l, r);
            l++;
            r--;
        }
        return sb.toString();
    }
    public void swap(StringBuilder sb, int l, int r) {
        char c = sb.charAt(l);
        sb.setCharAt(l, sb.charAt(r));
        sb.setCharAt(r, c);
    }
}