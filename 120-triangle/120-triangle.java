class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prev = triangle.get(0);
        List<Integer> curr = new ArrayList<>();
        
        int n = triangle.size();
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> currLevel = triangle.get(i);
            curr = new ArrayList<>();
            for(int j = 0; j < currLevel.size(); j++) {
                if(j == 0) 
                    curr.add(prev.get(0) + currLevel.get(0));
                else if(j == currLevel.size() - 1)
                    curr.add(prev.get(prev.size() - 1) + currLevel.get(currLevel.size() - 1));
                else {
                    curr.add(Math.min(prev.get(j - 1), prev.get(j)) + currLevel.get(j));
                }
            }
            prev = curr;
        }
        int res = Integer.MAX_VALUE;
        for(int val : prev) {
            res = Math.min(res, val);
        }
        return res;
    }
}