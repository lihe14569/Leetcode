class Solution {
    public boolean reorderedPowerOf2(int N) {
        
        int[] arr = counter(N);
        for (int i = 0; i < 32; i++)
            if (Arrays.equals(arr, counter(1 << i))) return true;
        return false;
    }
    public int[] counter(int N) {
        int[] arr = new int[10];
        while(N > 0) {
            arr[N % 10]++;
            N /= 10;
        }
        return arr;
    }
}