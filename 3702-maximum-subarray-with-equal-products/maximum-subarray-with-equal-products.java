class Solution {
    public int GCD(int a ,int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }

        return Math.abs(a);
    } 
    public int LCM(int a ,int b){
        if(a==0 || b==0){
            return 0;
        }

        return Math.abs((a/GCD(a,b))*b);
    }   
    public int maxLength(int[] arr) {
        int ans = 1;
        int n = arr.length;

        for(int i =0;i<n;i++){
            int pro = 1;
            int g = 0;
            int l =1;
           for(int j =i;j<n;j++){
             pro *= arr[j];
             if(pro>25200) break;
             g = GCD(g,arr[j]);
             l = LCM(l,arr[j]);
             if(pro == g*l){
             ans = Math.max(ans, j-i+1);
             }
           }

        }


        return ans;
    }
}