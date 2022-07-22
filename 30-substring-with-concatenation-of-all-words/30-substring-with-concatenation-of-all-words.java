class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int m = s.length(), n = words.length, w = words[0].length();
        Map<String, Integer> tot = new HashMap<>();
        for(String word : words) tot.put(word, tot.getOrDefault(word, 0) + 1);

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < w; i++) {
            Map<String, Integer> window = new HashMap<>();
            int cnt = 0;
            for(int j = i; j + w <= m; j += w) {
                //如果窗口大小大约 n*w
                if(j >= i + n * w) {
                    String left = s.substring(j - n*w, j - (n-1)*w);
                    //System.out.println("left is " + left);
                    window.put(left, window.getOrDefault(left, 0) - 1);
                    if(window.get(left) < tot.getOrDefault(left, 0)) cnt--;
                }
                String right = s.substring(j, j + w);
                //.out.println("right is " + right);
                window.put(right, window.getOrDefault(right, 0) + 1);
                if(window.get(right) <= tot.getOrDefault(right, 0)) cnt++;
                if(cnt  == n) res.add(j - (n - 1) * w);
            }
        }
        return res;
    }
}