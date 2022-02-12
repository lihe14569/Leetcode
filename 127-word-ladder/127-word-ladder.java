class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 1, n = beginWord.length();
        while(!beginSet.isEmpty()) {
            Set<String> nextSet = new HashSet<>();
            for(String s : beginSet) {
                StringBuilder sb = new StringBuilder(s);
                // for(int i = 0; i < n; i++) {
                //     for(char c = 'a'; c <= 'z'; c++) {
                //         char pre = chrs[i];
                //         if(pre == c) continue;
                //         chrs[i] = c;
                //         String newS = String.valueOf(chrs);
                //         if(endSet.contains(newS)) return step + 1;
                //         if(dict.contains(newS)) {
                //             nextSet.add(newS);
                //             dict.remove(newS);
                //         }
                //         chrs[i] = pre;
                //     }
                // }
                for(int i = 0; i < s.length(); i++) {
                    char oc = s.charAt(i);
                     for(char c = 'a'; c <= 'z'; c++) {
                         if(c == oc) continue;
                         sb.setCharAt(i, c);
                         String ns = sb.toString();
                         if(endSet.contains(ns)) return step + 1;
                         if(dict.contains(ns)) {
                             nextSet.add(ns);
                             dict.remove(ns);
                         }
                         sb.setCharAt(i, oc);
                     }
                }
            }
            
            // if(endSet.size() < nextSet.size()) {
            //     beginSet = endSet;
            //     endSet = nextSet;
            // } else {
            //     beginSet = nextSet;
            // }
            if(nextSet.size() < endSet.size()) {
                beginSet = nextSet;
            } else {
                beginSet = endSet;
                endSet = nextSet;
            }
            step++;  
        }
        return 0;
    }
}