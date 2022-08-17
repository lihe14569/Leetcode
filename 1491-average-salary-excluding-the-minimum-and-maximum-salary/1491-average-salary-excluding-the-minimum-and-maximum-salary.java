class Solution {
    public double average(int[] salary) {
        int sum = 0;
        Arrays.sort(salary);
        for(int i = 1; i < salary.length - 1; i++) sum += salary[i];
        return (double)sum / (double)(salary.length - 2);
    }
}