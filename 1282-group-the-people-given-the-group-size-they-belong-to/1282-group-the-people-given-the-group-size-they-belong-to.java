class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            if(map.get(groupSize) == null) map.put(groupSize, new ArrayList<>());
            map.get(groupSize).add(i);
            if(map.get(groupSize).size() == groupSize) {
                res.add(map.get(groupSize));
                map.put(groupSize, null);
            }
        }
        return res;
    }
}