class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //bfs
        
        //corner case
        Set<String> dict = new HashSet<>();
        for(String s : wordList) dict.add(s);
        if(!dict.contains(endWord)) return 0;
        if(beginWord.equals(endWord)) return 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        int count = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String word = q.poll();
                char[] chrs = word.toCharArray();
                for(int j = 0;j < word.length(); j++) {
                    char originCh = chrs[j];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == originCh) continue;
                        chrs[j] = c;
                        String nWord = new String(chrs);
                        if(dict.contains(nWord)) {
                            if(nWord.equals(endWord)) return count + 1;
                            q.offer(nWord);
                            dict.remove(nWord);
                        }
                        chrs[j] = originCh;
                    }
                }
            }
            count++;
        }
        return 0;
    }
}