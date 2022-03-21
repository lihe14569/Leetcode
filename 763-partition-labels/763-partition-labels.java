class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] lastIdx = new int[26];
        for(int i = 0; i <s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        int prev= 0, j= 0;
        for(int i = 0; i < s.length(); i++) {
            int last = lastIdx[s.charAt(i) - 'a'];
            j = Math.max(j, last);
            if(i == j) {
                res.add(j - prev + 1);
                prev = j + 1;
            }
        }
        return res;
    }
}