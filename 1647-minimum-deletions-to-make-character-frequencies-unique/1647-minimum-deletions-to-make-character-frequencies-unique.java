class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int cnt = 0;
        int maxAllowedFreq = s.length();
        for(int i = 25; i >= 0 && freq[i] > 0; i--) {
            if(freq[i] > maxAllowedFreq) {
                cnt += freq[i] - maxAllowedFreq;
                freq[i] = maxAllowedFreq;
            }
            maxAllowedFreq = Math.max(0, freq[i] - 1);
        }
        return cnt;
    }
}