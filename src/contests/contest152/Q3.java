package contests.contest152;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{3,3,0},{1,2,0},{0,3,1}};
        List<Boolean> list = canMakePaliQueries("abcda", arr);
        for(Boolean b : list) {
            System.out.println(b);
        }
        //int[] arr = new int[]{1,1,2,3};
        //List<Integer> list = findDuplicates(arr);
        //List<Integer> list = new ArrayList<>();

    }

    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = queries.length;
        List<Boolean> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int k = queries[i][2];

            String s2 = s.substring(start, end + 1);
            int len = end - start + 1;

            int count = 0;

            for(int j = start; j < (start + end)/2; j++) {
                if(s.charAt(j) != s.charAt(end - j + 1)) {
                    count += 1;
                }
            }

            if(k >= count) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}
