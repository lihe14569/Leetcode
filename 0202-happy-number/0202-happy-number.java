class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n) && n > 0) {
            set.add(n);
            int sum = 0;
            while(sum >= 0 && n > 0) {
                sum += (n % 10)*(n % 10);
                n /= 10;
            }
            System.out.println("sum:" + sum);
            n = sum;
            if(n == 1) break;
        }
        return n == 1;
    }
}