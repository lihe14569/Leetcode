class Solution {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int res = 0, left = 0;
        //all uppercase letter, not array is enough
        int[] map = new int[26];
        for(int i = 0; i < N; i++) {
            //put in
            char c1 = s.charAt(i);
            map[c1 - 'A']++;
            //take out if condition not satisfied
            //if the maxfreq character 
            //******hard to understand
            while(i - left + 1 - findMax(map) > k) {
                char c2 = s.charAt(left);
                map[c2 - 'A']--;
                left++;
            }
            //calculate
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
    public int findMax(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }
}