class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // int a = need1 ;
        // int b = need2;
        // long ans=0;
        
        // if(costBoth<=cost1+cost2){
        //     long min = Math.min(need1,need2);
        //     ans = ans+ min*costBoth;
        //     need1-=min;
        //     need2-=min;

        //     ans += need1*cost1;
        //     ans+= need2*cost2;

        //     long x = (long)Math.max(a, b) * costBoth;
        //     ans = Math.min(x,ans);

        //     ans = Math.min(ans , (long)a*costBoth);
        //     ans = Math.min(ans, (long)b*costBoth);
        // }
       

         long best = Long.MAX_VALUE;

        // Buy everything separately
        long separate = (long) need1 * cost1 + (long) need2 * cost2;
        best = Math.min(best, separate);

         if (costBoth <= cost1 + cost2) {

            int maxNeed = Math.max(need1, need2);

            int[] testPoints = {0, need1, need2, maxNeed};

            for (int take : testPoints) {

                long remaining1 = need1 - take;
                long remaining2 = need2 - take;

                if (remaining1 < 0) remaining1 = 0;
                if (remaining2 < 0) remaining2 = 0;

                long currentCost =
                        (long) take * costBoth +
                        remaining1 * cost1 +
                        remaining2 * cost2;

                best = Math.min(best, currentCost);
            }
        }

        return best;
    }
}