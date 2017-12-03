package divide_and_conquer;

import java.util.*;
import java.io.*;
/*
 * The Boyer-Moore Majority Vote Algorithm
 * https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
 */

public class MajorityElement {
    private static int getMajorityElement(int[] array) {
    	int count = 0;
        int candidate = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                candidate = array[i]; 
                // set the count as 1
                count = 1;
                continue;
            } else if (candidate == array[i])
                count++;
            else {
                count--;
            }
        }

        if (count == 0) {
            return -1;

        } else {
            count = 0;
            for (int i = 0; i < array.length; i++) {
                if (candidate == array[i])
                    count++;
            }

            if (count > array.length / 2)
        		return candidate;
            else
                return -1;
        }

    }
    
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

