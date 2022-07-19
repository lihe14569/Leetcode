class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        for(int i = 1; i <= numRows; i++) {
            List<Integer> lst = new ArrayList<>();
            if(i == 1) {
                res.add(new ArrayList<>(prev));
                continue;
            }
            for(int j = 0; j < i; j++) {
                if(j == 0 || j == i - 1) {
                    lst.add(1);
                } else {
                    lst.add(prev.get(j- 1) + prev.get(j));
                }
            }
            res.add(lst);
            prev = lst;
        }
        return res;
    }
}