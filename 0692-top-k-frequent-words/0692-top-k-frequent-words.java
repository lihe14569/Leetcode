class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int f1 = freq.get(s1);
                int f2 = freq.get(s2);
                if(f1 == f2) {
                    return s1.compareTo(s2);
                }
                return f2 - f1;
            }
        });
        List<String> res = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for(int i = 0; i < words.length && seen.size() < k; i++) {
            if(!seen.contains(words[i])) {
                res.add(words[i]);
                seen.add(words[i]);
            }
        }
        return res;
    }
}