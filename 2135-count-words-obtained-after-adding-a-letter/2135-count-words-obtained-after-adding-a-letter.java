class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> set = new HashSet<>();
        for(String s : startWords) {
            set.add(toInt(s));
        }
        int res = 0;
        for(String s : targetWords) {
            int num = toInt(s);
            for(int i = 0; i < 26; i++) {
                if((num & (1 <<(i))) > 0) {
                    int temp = num - (1 <<(i));
                    if(set.contains(temp)) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;    
    }
    //string to int, bit manipulation
    public int toInt(String s) {
        int res = 0;
        for(char c: s.toCharArray()) {
            res += 1 <<(c - 'a');
        }
        return res;
    }
}