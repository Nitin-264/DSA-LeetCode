class Solution {
    public int longestMonotonicSubarray(int[] arr) {
        int n = arr.length;
        int ans =0;
        int incMax =0;
        for(int i =1;i<n;i++){
           if(arr[i]>arr[i-1]){
            incMax++;
            continue;
           }
           else{
            ans = Math.max(ans,incMax);
            incMax =0;
           }
        }
        ans = Math.max(ans,incMax);
        int incDec =0;
        for(int i =1;i<n;i++){
           if(arr[i]<arr[i-1]){
            incDec++;
            continue;
           }
           else{
            ans = Math.max(ans,incDec);
            incDec = 0;
           }
        }
        ans = Math.max(ans,incDec);

        return ans+1;
    }
}