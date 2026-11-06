class Solution {
    public int[] countServers(int n, int[][] arr, int x, int[] queries) {
        int q = queries.length;
        int m = arr.length;
        // sort arr on the basis of the time
        Arrays.sort(arr, (a,b)-> a[1] - b[1]);

        int [][] timeIdx = new int[q][2];

        for(int i=0;i<q;i++){
            timeIdx[i][0]= queries[i];
            timeIdx[i][1] = i;
        }

        // sort timeIdx based on time 
        Arrays.sort(timeIdx , (a,b)-> a[0]-b[0]);

        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[q];

        int i =0, j=0;
        for(int[] pair : timeIdx){
            int currTime = pair[0];
            int idx = pair[1];

            int start = currTime - x;
            int end = currTime;

            // right expand :time<=end
            while(j<m && arr[j][1]<=end){
                int serverId = arr[j][0];
                map.put(serverId , map.getOrDefault(arr[j][0],0)+1);
                j++;
            }
            // left shrink : time<start
            while(i<m && arr[i][1]<start){
              int serverId = arr[i][0];
              map.put(serverId , map.get(arr[i][0])-1);
              if(map.get(serverId)==0){
                map.remove(serverId);
              }
              i++;

            }
            ans[idx] = n - map.size();
        }

        return ans;

    }
}