class Solution {
    int[][] dp;
    public int findidx(int[] arr, int val, int idx) {

        int start = idx;
        int end = arr.length;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] < val) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (start < arr.length && arr[start] == val) {
            return start;
        }

        return -1;
    }
    public int solve(int idx ,int inc ,int[] arr){
        if(dp[idx][inc]!=-1){
            return dp[idx][inc];
        }

        int len =1;
        int CurrVal = arr[idx] +inc; //inc 0/1

        //1st Option = find (currVal+1)
        int j = findidx(arr,CurrVal,idx+1);
        if(j!=-1){
            len = Math.max(len,1 + solve(j,1,arr));
        }


        //2nd Option = find (currVal) and then inc by +1
        j = findidx(arr,CurrVal+1,idx+1);
        if(j!=-1){
            len = Math.max(len, 1 + solve(j,0,arr));
        }
        
        return dp[idx][inc] = len;

    }
    public int maxSelectedElements(int[] arr) {
        
        int n = arr.length;

        Arrays.sort(arr);

        dp = new int[n+1][2];
        for(int i=0;i<n+1;i++){
            dp[i][0]=-1;
            dp[i][1] =-1;
        }

        int result =0;
        for(int i=0;i<n;i++){
            result = Math.max(result , Math.max(solve(i,0,arr),solve(i,1,arr)));
        }

        return result;
    }
}