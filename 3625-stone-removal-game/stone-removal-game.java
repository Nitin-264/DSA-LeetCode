class Solution {
    public boolean canAliceWin(int n) {
        if(n<10) return false;
        if(n==10) return  true;

        int alice = 1;
        n = n-10;
        int rem = 9;

        while(true){
          n = n-rem;
          if(n<0){
            if(alice%2==1) return true;
            else return false;
          }
          rem--;
          alice++;
        }

        
    }

}