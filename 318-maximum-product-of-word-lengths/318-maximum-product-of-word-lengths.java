class Solution {
    public int maxProduct(String[] words) {
        //store all strings as binary for in integer array
        int[] arr = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()){
                arr[i] |= 1<<(c - '0');
            }
        }
        int res = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++) {
                if((arr[i] & arr[j]) == 0)
                    res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }
}