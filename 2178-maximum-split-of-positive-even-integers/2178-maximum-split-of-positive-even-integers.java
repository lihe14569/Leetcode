class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> list = new ArrayList<>();
        if(finalSum % 2 != 0) return list;
        long curr = 0;
        for(long i = 2; i <= finalSum - curr; i+=2) {
            curr += i;
            list.add(i);
            
        }
        
        if(finalSum > curr) {
            list.set(list.size() - 1, list.get(list.size() -1) + (finalSum - curr));
        }
        return list;
    }
}