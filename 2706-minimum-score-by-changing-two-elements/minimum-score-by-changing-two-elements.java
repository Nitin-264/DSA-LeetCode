class Solution {
    public int minimizeSum(int[] arr) {
        int n = arr.length;
        if(n==3) return 0;
        Arrays.sort(arr);

        return Math.min((arr[n-1] - arr[2]),Math.min((arr[n-2]-arr[1]),(arr[n-3]-arr[0])));
    }
}