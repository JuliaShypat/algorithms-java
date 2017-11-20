import java.util.*;

public class FibonacciLastDigit {
    private static long calc_fib_last_digit(int n) {
        if(n<=1)
            return n;
        int[] data = new int[n+1];
        data[0] = 0;
        data[1] = 1;
        for (int i = 2; i <= n; ++i) {
            data[i] = (data[i-1]% 10) + (data[i-2] % 10);
        }
        return data[n] % 10;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(calc_fib_last_digit(n));
    }
}

