class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Pair>[] buckets = new ArrayList[26];
        // Arrays.fill(buckets, new ArrayList<Pair>());
        
        for(int i= 0; i < 26; i++) buckets[i] = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            buckets[words[i].charAt(0) - 'a'].add(new Pair(words[i], 0));
        }
        
        int res = 0;
        for(char c : s.toCharArray()) {
            List<Pair> lst = buckets[c - 'a'];
            List<Pair> buff = new ArrayList<>();
            for(Pair p : lst) {
                if(p.i + 1 == p.w.length()) res++;
                else {
                    buff.add(new Pair(p.w, p.i + 1));
                }
            }
            lst.clear();
            for(Pair p : buff) {
                buckets[p.w.charAt(p.i) - 'a'].add(p);
            }
        }
        return res;
        
    }
    class Pair {
        String w;
        int i;
        public Pair(String w, int i) {
            this.w = w;
            this.i = i;
        }
    }
}