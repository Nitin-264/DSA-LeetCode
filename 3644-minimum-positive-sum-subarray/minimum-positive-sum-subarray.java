class Solution {
    public int minimumSumSubarray(List<Integer> al, int l, int r) {
        int n = al.size();
        int ans = Integer.MAX_VALUE;

        // Try every valid window size k from l to r
        for (int k = l; k <= r; k++) {
            int i = 0;
            int j = 0;
            int sum = 0;

            while (j < n) {
                sum += al.get(j); // Add incoming element

                // Once the window reaches size k
                if (j - i + 1 == k) {
                    if (sum > 0) {
                        ans = Math.min(ans, sum);
                    }
                    sum -= al.get(i); // Remove outgoing element
                    i++;              // Slide left pointer
                }
                j++;                  // Slide right pointer
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}