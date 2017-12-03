package divide_and_conquer;

import java.io.*;
import java.util.*;

/*
 * Task. The goal in this code problem is to implement the binary search algorithm.
 * Input Format. The first line of the input contains an integer 𝑛 and a sequence 𝑎0 < 𝑎1 < . . . < 𝑎𝑛−1 of
	𝑛 pairwise distinct positive integers in increasing order. The next line contains an integer 𝑘 and 𝑘
	positive integers 𝑏0, 𝑏1, . . . , 𝑏𝑘−1.
 *	Input:
	5 1 5 8 12 13
	5 8 1 23 1 11
 * 	Output:
	2 0 -1 0 -1 
 */

public class BinarySearch {

    static int binarySearch(int[] a, int low, int hight, int key) {
    	if(hight < low) {
        	return - 1;
        }
        int mid = (int)Math.floor(low + ((hight-low) / 2));
        if (key == a[mid]) {
        	return mid;
        } else if (key < a[mid]) {
        	return binarySearch(a, low, mid-1, key);
        } else {
        	return binarySearch(a, mid + 1, hight, key);
        }
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            //System.out.print(linearSearch(a, b[i]) + " ");
            System.out.print(binarySearch(a, 0, a.length-1, b[i]) + " ");
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

