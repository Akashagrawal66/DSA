package hashing;

import java.util.*;

/*
Given an array A of length N. You have to answer Q queries.
Each query will contain four integers l1, r1, l2, and r2. If sorted segment from [l1, r1] is the same as the sorted segment from [l2 r2],
then the answer is 1 else 0.
NOTE The queries are 0-indexed.

Input 1:
 A = [1, 7, 11, 8, 11, 7, 1]
 B = [
       [0, 2, 4, 6]
     ]
Input 2:
 A = [1, 3, 2]
 B = [
       [0, 1, 1, 2]
     ]
Output 1:
 [1]
Output 2:
 [0]
*/
public class CompareSortedSubArrays {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Long> hashSet = new HashSet<>();
        List<Long> prefixHash = new ArrayList<>();
        Map<Integer, Long> hm = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < A.size(); i++) {
            long hash;
            int num = A.get(i);
            if (!hm.containsKey(num)) {
                hash = random.nextInt();
                while (hashSet.contains(hash)) {
                    hash = random.nextInt();
                }
                hashSet.add(hash);
                hm.put(num, hash);
            } else {
                hash = hm.get(num);
            }
            if (i == 0) {
                prefixHash.add(hash);
            } else {
                prefixHash.add((prefixHash.get(i - 1) + hash));
            }
        }
        for (ArrayList<Integer> integers : B) {
            int l1 = integers.get(0);
            int r1 = integers.get(1);
            int l2 = integers.get(2);
            int r2 = integers.get(3);
            long hash1 = l1 == 0 ? prefixHash.get(r1) : prefixHash.get(r1) - prefixHash.get(l1 - 1);
            long hash2 = l2 == 0 ? prefixHash.get(r2) : prefixHash.get(r2) - prefixHash.get(l2 - 1);
            if (hash1 == hash2) {
                result.add(1);
            } else {
                result.add(0);
            }
        }
        return result;
    }

    public int[] solve(int[] A, int[][] B) {
        int n = B.length;
        int[] result = new int[n];
        for(int i = 0;i<n;i++){
            int l1 = B[i][0];
            int r1 = B[i][1];
            int l2 = B[i][2];
            int r2 = B[i][3];
            if((r1-l1 == r2-l2) && (Math.min(A[l1], A[r1]) == Math.min(A[l2], A[r2])) && (Math.max(A[l1], A[r1]) == Math.max(A[l2], A[r2]))){
                boolean flag = true;
                if(A[l1] == A[l2]){
                    for(int k=l1, j=l2;k<=r1;k++,j++){
                        if(A[k] != A[j]){
                            flag = false;
                            break;
                        }
                    }
                }else{
                    for(int k=l1, j=r2;k<=r1;k++,j--){
                        if(A[k] != A[j]){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag){
                    result[i] = 1;
                }else{
                    result[i] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CompareSortedSubArrays solution = new CompareSortedSubArrays();
        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(1, 7, 11, 8, 7, 11, 1));
        ArrayList<ArrayList<Integer>> B1 = new ArrayList<>();
        B1.add(new ArrayList<>(Arrays.asList(0, 2, 4, 6)));
        System.out.println(solution.solve(A1, B1)); // Output: [1]

        ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList(1, 3, 2));
        ArrayList<ArrayList<Integer>> B2 = new ArrayList<>();
        B2.add(new ArrayList<>(Arrays.asList(0, 1, 1, 2)));
        System.out.println(solution.solve(A2, B2)); // Output: [0]

        int[] arr = {1, 7, 11, 8, 7, 11, 1};
        int[][] arr2 = {{0, 2, 4, 6}};

        System.out.println(Arrays.toString(solution.solve(arr, arr2)));
    }
}
