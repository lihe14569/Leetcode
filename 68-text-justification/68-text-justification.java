class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            int j = i + 1;
            int len = words[i].length();
            while(j < words.length && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j].length();
                j++;
            }
            StringBuilder sb = new StringBuilder();
            if(j == words.length || j == i + 1) {
                sb.append(words[i]);
                for(int k = i + 1; k < j; k++) {
                    sb.append(" " + words[k]);
                }
                while(sb.length() < maxWidth) sb.append(" ");
            } else {
                sb.append(words[i]);
                int cnt = j - i - 1, rest = maxWidth - len + cnt;
                int k = 0;
                while(k < rest % cnt) {
                    sb.append(String.join("", Collections.nCopies(rest / cnt + 1, " ")));
                    sb.append(words[i + k + 1]);
                    k++;
                }
                while(k < cnt) {
                    sb.append(String.join("", Collections.nCopies(rest / cnt, " ")));
                    sb.append(words[i + k + 1]);
                    k++;
                }
            }
            res.add(sb.toString());
            //update i 
            i = j - 1;
        }
        return res; 
    }
}