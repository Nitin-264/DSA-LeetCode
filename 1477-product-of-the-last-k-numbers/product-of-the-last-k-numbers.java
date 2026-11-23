
// import java.util.*;

// class ProductOfNumbers {

//     List<Integer> al;
//     List<Integer> alPre;
//     boolean flag = false;
//     int size = 0;
//     List<Integer> zeroIdx;

//     public ProductOfNumbers() {
//         al = new ArrayList<>();
//         alPre = new ArrayList<>();
//         zeroIdx = new ArrayList<>();
//     }

//     public void add(int num) {

//         al.add(num);

//         if (size == 0) {
//             if(num!=0) alPre.add(num);
//             else{
//                 flag = true;
//                 alPre.add(1);
//                 zeroIdx.add(0);
//             }
//         } else {

//             if (num != 0) {
//                 alPre.add(alPre.get(size - 1) * num);
//             } else {
//                 flag = true;
//                 alPre.add(alPre.get(size - 1));
//                 zeroIdx.add(size);
//             }
//         }

//         size++;
//     }

//     public int getProduct(int k) {

//         int start = size - k;

//         // Check whether the requested range contains zero
//         if (flag) {
//             int lastZero = zeroIdx.get(zeroIdx.size() - 1);

//             if (lastZero >= start) {
//                 return 0;
//             }
//         }

//         if (start == 0) {
//             return alPre.get(size - 1);
//         }

//         return alPre.get(size - 1) / alPre.get(start - 1);
//     }
// }

import java.util.*;

class ProductOfNumbers {

    private List<Integer> pre;

    public ProductOfNumbers() {
        pre = new ArrayList<>();
        pre.add(1);               // sentinel
    }

    public void add(int num) {
        if (num == 0) {
            pre.clear();          // everything before a zero is irrelevant
            pre.add(1);
        } else {
            pre.add(pre.get(pre.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = pre.size();
        if (k >= n) return 0;     // window reaches back past the last zero
        return pre.get(n - 1) / pre.get(n - 1 - k);
    }
}