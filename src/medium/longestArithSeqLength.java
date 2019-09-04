package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class longestArithSeqLength {
    public static void main(String[] args) {
        //int[] arr = new int[]{12,28,13,6,34,36,53,24,29,2,23,0,22,25,53,34,23,50,35,43,53,11,48,56,44,53,31,6,31,57,46,6,17,42,48,28,5,24,0,14,43,12,21,6,30,37,16,56,19,45,51,10,22,38,39,23,8,29,60,18};
        int[] arr = new int[]{20,1,15,3,10,5,8};
        System.out.println(longestArithSeqLength(arr));
    }
    public static int longestArithSeqLength(int[] A) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < A.length; i++) {
            List<Integer> list = map.get(A[i]);
            if(list == null) {
                list = new ArrayList<Integer>();
                map.put(A[i], list);
            }
            list.add(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < A.length - 1; i++) {
            int index = 0, diff = 0, local = 2, nextNum = 0;
            for(int j = i + 1; j < A.length; j++) {
                index = j;
                local = 2;
                diff = A[i] - A[j];
                nextNum = A[j] - diff;
                int val = findIndex(map, nextNum, index);
                if(val != -1 && val > index)
                    local += 1;
                while(val != -1 && val > index) {
                    index = val;
                    nextNum -= diff;
                    val = findIndex(map, nextNum, index);
                    if(val == -1)
                        break;
                    local += 1;
                }

                if(local > max)
                    max = local;
            }
        }

        return max;
    }

    public static int findIndex(Map<Integer, List<Integer>> map, int nextNum, int index) {
        List<Integer> list = map.get(nextNum);
        if(list == null) return -1;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) > index) {
                return list.get(i);
            }
        }

        return -1;
    }
}
