class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs) {
            char[] chrs = s.toCharArray();
            Arrays.sort(chrs);
            String str = String.valueOf(chrs);
            System.out.println(str);
            if(!map.containsKey(str)) map.put(str, new ArrayList<>());
            map.get(str).add(s);
        }
        for(List<String> lst : map.values()) {
            res.add(lst);
        }
        return res;
    }
}