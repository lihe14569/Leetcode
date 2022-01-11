class Solution {
    public List<List<String>> partition(String s) {
        //dfs
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s, 0, res, list);
        return res;
    }
    
    public void dfs(String s, int start, List<List<String>> res, List<String> list) {
        //base case
        if(start == s.length()) {
            res.add(new ArrayList<>(list));
            
            return;
        }
        
        for(int i = start; i < s.length(); i++) {
            String subStr = s.substring(start, i + 1);
            if(isPanlindrome(subStr)) {
                list.add(subStr);
                dfs(s, i + 1, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPanlindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r ) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}