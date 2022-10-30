class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] chrs = new int[26];
        for(char c : sentence.toCharArray()) {
            chrs[c - 'a']++;
        }
        for(int num : chrs) {
            if(num == 0) return false;
        }
        return true;
    }
}