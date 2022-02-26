class Solution {
    public String reverseWords(String s) {
        int l = 0, r=  s.length() - 1;
        while(l < r && s.charAt(l) == ' ') l++;
        while(l < r && s.charAt(r) == ' ') r--;
        List<String> list = new ArrayList<>();
        while(l <= r) {
            int i = l;
            while(i <= r && s.charAt(i) != ' ') i++;
            if(i != l) list.add(s.substring(l, i));
            l = i + 1;
        }
        Collections.reverse(list);
        return String.join(" ", list);
    }
}