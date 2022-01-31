class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        int n = strings.length;
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings) {
            String key = hashKey(s);
            if(map.containsKey(key))
                map.get(key).add(s);
            else {
                map.put(key, new ArrayList<>());
                map.get(key).add(s);
            }
        }
        for(String k : map.keySet()) {
            res.add(map.get(k));
        }
        return res;
    }
    public String hashKey(String s) {
        String res = "";
        char start = s.charAt(0);
        for(char c : s.toCharArray()) {
            res += (c < start ? (26 + c - start) : c - start) + " ";
        }
        return res;
    }
}