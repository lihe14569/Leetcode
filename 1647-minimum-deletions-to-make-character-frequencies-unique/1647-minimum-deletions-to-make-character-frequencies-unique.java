class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int cnt = 0;
        Arrays.sort(freq);
        int maxFreq = s.length();
        for(int i = 25; i >= 0 && freq[i] > 0; i--) {
            if(freq[i] > maxFreq) {
                cnt += freq[i] - maxFreq;
                freq[i] = maxFreq;    
            }
            maxFreq = Math.max(freq[i] - 1, 0);
        }
        return cnt;
    }
}