package searching;

import sorting.UniqueElements;

import java.util.*;

/*
Given an array of integers A of size N and an integer B.
In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B such operations.
Find the number with the maximum number of occurrences and return an array C of size 2, where C[0] is the number of occurrences,
and C[1] is the number with maximum occurrence.
If there are several such numbers, your task is to find the minimum one.
Input 1:
 A = [3, 1, 2, 2, 1]
 B = 3
Input 2:
 A = [5, 5, 5]
 B = 3
Output 1:
 [4, 2]
Output 2:
 [3, 5]
*/
public class AddOrNot {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        ArrayList<Integer> result = new ArrayList<>();
        if (list.size() == 1) {
            result.add(A.size());
            result.add(A.get(0));
            return result;
        }
        int maxOccurrences = 0;
        int resultNum = list.get(list.size() - 1);
        for (int i = list.size() - 1; i > 0; i--) {
            int num = list.get(i);
            int currOccurrence = map.get(num);
            System.out.println("Trying for num: " + num);
            int temp = B;
            int count = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (temp <= 0) {
                    break;
                }
                int diff = num - list.get(j);
                int jOccurrence = map.get(list.get(j));
                int max = maxOccurrencesToBeReduced(temp, jOccurrence, diff);
                System.out.println("Num: " + list.get(j) + " with number of occurrences = " + max + " can be increased.");
                count += max;
                temp = temp - (diff * max);
            }
            System.out.println("Count for num " + num + " is: " + (count + currOccurrence));
            if (maxOccurrences < (count + currOccurrence)) {
                maxOccurrences = (count + currOccurrence);
                resultNum = num;
            } else if (maxOccurrences == (count + currOccurrence) && resultNum > num) {
                resultNum = num;
            }
        }
        if (map.get(list.get(0)) >= maxOccurrences) {
            maxOccurrences = map.get(list.get(0));
            resultNum = list.get(0);
        }
        result.add(maxOccurrences);
        result.add(resultNum);
        return result;
    }

    private int maxOccurrencesToBeReduced(int B, int jOccurrence, int diff) {
        int low = 0;
        int high = jOccurrence;
        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (B - (diff * mid) > 0) {
                result = mid;
                low = mid + 1;
            } else if (B - (diff * mid) < 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return result;
    }

    public ArrayList<Integer> solveOptimized(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        List<Long> prefix = new ArrayList<>();
        prefix.add(0L);
        for (int i=0;i<n;i++) {
            prefix.add(prefix.get(i)+A.get(i));
        }
        int maxCount = -1;
        int maxNum = -1;
        for (int i=0;i<n;i++) {
            int low = 1;
            int high = i+1;
            while (low <= high) {
                int mid = low + (high-low)/2;
                if ((long) A.get(i) * mid - (prefix.get(i+1)-prefix.get(i+1-mid)) <= B) {
                    if(mid > maxCount) {
                        maxCount = mid;
                        maxNum = A.get(i);
                    }
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        result.add(maxCount);
        result.add(maxNum);
        return result;
    }

    public static void main(String[] args) {
        AddOrNot obj = new AddOrNot();
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {5, 1, 3, 3, 1, 1, 1, 3, 1, 9};
        UniqueElements obj2 = new UniqueElements();
        obj2.addToList(list, arr);
//        System.out.println(obj.solve(list, 3));
        System.out.println(obj.solveOptimized(list, 3));
    }
}
