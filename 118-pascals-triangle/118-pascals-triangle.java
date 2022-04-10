class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> prev = i == 0 ? null : res.get(i - 1);
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) list.add(1);
                else {
                    list.add(prev.get(j - 1) + prev.get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}