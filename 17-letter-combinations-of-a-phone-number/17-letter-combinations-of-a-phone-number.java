class Solution {
    String[] phone = new String[]{"", "", "abc", "def",
                                 "ghi", "jkl", "mno",
                                 "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        String path = "";
        dfs(digits, 0, res, path);
        return res;
    }
    public void dfs(String digits, int idx, List<String> res, String path) {
        if(idx == digits.length()) {
            res.add(path);
            return;
        }
        for(char c : phone[digits.charAt(idx) - '0'].toCharArray()) {
            dfs(digits, idx + 1, res, path + c);
        }
    }
}