class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> list= new ArrayList<>();
        if(finalSum % 2 == 0) {
            long curr = 2;
            while(curr <= finalSum) {
                list.add(curr);
                finalSum -= curr;
                curr+=2;
            }
            if(finalSum > 0) {
                int end = list.size() - 1;
                list.set(end, list.get(end) +finalSum);
            }
        }
        return list;
    }
}