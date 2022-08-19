class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> sequence = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) { //sort the interval
                return (a[1] - a[0]) - (b[1] - b[0]);
            } else {
                return a[1] - b[1];
            }
        });
        for(int num : nums) {
            while(!sequence.isEmpty() && sequence.peek()[1] + 1 < num) { //break
                int[] curr = sequence.poll();
                if(curr[1] - curr[0] + 1 < 3) return false;
            }
            if(sequence.isEmpty() || sequence.peek()[1] == num) {
                sequence.offer(new int[]{num, num});
            } else  {
                int[] curr = sequence.poll();
                sequence.offer(new int[]{curr[0], num});
            }
        }
        while(!sequence.isEmpty()) {
            int[] curr = sequence.poll();
            if(curr[1] - curr[0] + 1 < 3) return false;
        }
        return true;
    }
}