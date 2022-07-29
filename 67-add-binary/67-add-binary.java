class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int left = 0;
        while(left < words.length) {
            int right = findRight(words, left, maxWidth);
            String line = justify(words, left, right, maxWidth);
            res.add(line);
            left = right + 1;
        }
        return res;
    }
     public int findRight(String[] words, int left, int maxWidth) {
         int right = left;
         int sum = words[right++].length();
         while(right < words.length && sum + words[right].length() + 1 < maxWidth) {
             sum += words[right++].length();
         }
         return right - 1;
     }
     public String justify(String[] words, int left, int right, int maxWidth) {
        //corner case: single word
        if(left == right) return padWords(words[left], maxWidth);
        int numSpaces = right - left;
        int totalSpaces = maxWidth - wordLength(words, left, right);
        
        boolean isLastLine = right == words.length - 1;
        int avgSpaces = isLastLine ? 1 : totalSpaces / numSpaces;
        int mod = isLastLine ? 0 : totalSpaces % numSpaces;
        
        StringBuilder line = new StringBuilder();
        for(int i = left; i <= right; i++) {
            line.append(words[i])
                .append(blank(avgSpaces))
                .append(mod-- > 0 ? " " : "");
        }
        
        return padWords(line.toString().trim(), maxWidth);
    }
    public int wordLength(String[] words, int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++) {
            sum += words[i].length();
        }
        return sum;
    }
    public String padWords(String word, int maxWidth) {
        return word + blank(maxWidth - word.length());
    }
    public String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }
}