class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : cpdomains) {
            String[] sArr = s.split(" ");
            String domain = sArr[1];
            int start = 0;
            int val = Integer.parseInt(sArr[0]);
            while(start < domain.length()) {
                String sub = domain.substring(start);
                map.put(sub, map.getOrDefault(sub, 0) + val);
                
                while(start < domain.length() && domain.charAt(start) != '.') start++;
                start++;
            }
        }
        List<String> res = new ArrayList<>();
        for(String s : map.keySet()) {
            res.add(map.get(s) + " " + s);
        }
        return res;
    }
}