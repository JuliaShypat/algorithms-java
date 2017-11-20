import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Random;


public class MaxPairwiseProductTest {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((long) numbers[i] * numbers[j] > result) {
                    result = (long) numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    static long getMaxPairwiseProductFast(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        int max_index1 = -1;
        for (int i = 0; i < n; ++i)
            if ((max_index1 == -1) || (numbers[i] > numbers[max_index1]))
                max_index1 = i;

        int max_index2 = -1;
        for (int j = 0; j < n; ++j)
            if ((j != max_index1) && ((max_index2 == -1) || (numbers[j] > numbers[max_index2])))
                max_index2 = j;
        return ((long)(numbers[max_index1])) * numbers[max_index2];
    }

    public static void main(String[] args) {
        Random rand = new Random();
        while(true) {
            int n = rand.nextInt(1000) + 2;
            System.out.println(n);
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = rand.nextInt(100000);
                System.out.print(numbers[i] + " ");
            }
            long res1 = getMaxPairwiseProduct(numbers);
            long res2 = getMaxPairwiseProductFast(numbers);

            if(res1 != res2){
                System.out.println("Wrong Answer: "+ res1 + " "+ res2);
                break;
            }
            else {
                System.out.println("OK");
            }
        }
    }
}