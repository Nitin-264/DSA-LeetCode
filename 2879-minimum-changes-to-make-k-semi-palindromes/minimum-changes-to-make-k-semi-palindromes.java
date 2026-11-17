class Solution {
    String s ;
    int n ;
    int[][] dp;
    int[][] costDp;

    public int cost(int start ,int end){
        int len = end-start+1;
        if(costDp[start][end]!=-1) return costDp[start][end];

        int minCost = Integer.MAX_VALUE;

        for(int d=1;d<len;d++){
            if(len%d!=0){
                continue;
            }

            int cost =0;

            for(int group = 0;group<d;group++){
                int l = start + group;
                int r = l + (len/d - 1)*d;

                while(l<r){
                    if(s.charAt(l)!=s.charAt(r)){
                       cost++;
                    }
                    l+=d;
                    r-=d;
                }
            }

            minCost = Math.min(minCost,cost);

        }

        return costDp[start][end] =  minCost;
    }

    public int helper(int i ,int k){
        if(k==0 && i==n){
            return 0;
        }

        if(k==0 && i!=n){
            return Integer.MAX_VALUE;
        }

        if(i+ 2*k>n){
            return Integer.MAX_VALUE;
        }

        if(dp[i][k]!=-1){
            return dp[i][k];
        }

        int result = Integer.MAX_VALUE;
        for(int end = i+1;end <n ;end++){

            int remaining = helper(end+1,k-1);

            if(remaining== Integer.MAX_VALUE){
                continue;
            }

            result = Math.min(result ,  cost(i,end)+remaining);

        }

        return dp[i][k] = result;

    }
    public int minimumChanges(String sb, int k) {
        s= sb;
        n = s.length();

        dp = new int[n+1][k+1];
        costDp = new int[n][n];

        for(int[]ele: costDp){
            Arrays.fill(ele,-1);
        }

        for(int[] ele : dp){
            Arrays.fill(ele,-1);
        }

        return helper(0,k);
    }
}