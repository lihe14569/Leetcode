class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, 0, 0, n);
        return res;
    }
    public void dfs(List<String> res, StringBuilder sb, int left, int right, int n) {
        if(sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if(left < n && left >= right) {
            sb.append('(');
            dfs(res, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < n && right < left) {
            sb.append(')');
            dfs(res, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}