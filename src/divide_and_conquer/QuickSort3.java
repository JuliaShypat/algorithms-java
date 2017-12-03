package divide_and_conquer;

import java.io.*;
import java.util.*;

/*
 * 	Task. To force the given implementation of the quick sort algorithm to efficiently process sequences with
	few unique elements, your goal is replace a 2-way partition with a 3-way partition. That is, your new
	partition procedure should partition the array into three parts: < 𝑥 part, = 𝑥 part, and > 𝑥 part.
 *	Input Format. The first line of t
 *	Input:
	5
	2 3 9 2 2
	Output:
	2 2 2 3 9
 */

public class QuickSort3 {
    private static Random random = new Random();
    
    private static void randomizedQuickSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int k = random.nextInt(hi - lo + 1) + lo;
        int t = a[lo];
        a[lo] = a[k];
        a[k] = t;
        int lt = lo, gt = hi;
        int pivot = a[lo];
        int i = lo;
        while (i <= gt) {
            if      (a[i] < pivot) exch(a, lt++, i++);
            else if (a[i] > pivot) exch(a, i, gt--);
            else              i++;
        }
        randomizedQuickSort(a, lo, lt - 1);
        randomizedQuickSort(a, gt + 1, hi);
    }
    
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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

