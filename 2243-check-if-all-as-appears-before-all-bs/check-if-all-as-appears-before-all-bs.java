class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        int aIdx = s.lastIndexOf('a');
        int bIdx = -1;
        for(int i = 0;i<n;i++){
            if(s.charAt(i)=='b'){
                bIdx = i;
                break;
            }
        }
        System.out.print(aIdx +"   "+bIdx);

        if(bIdx==-1) return true;

        return aIdx<bIdx;
    }
}