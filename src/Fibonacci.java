import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if(n<=1)
      return n;
    int[] data = new int[n+1];
    data[0] = 0;
    data[1] = 1;
    for (int i = 2; i <= n; ++i) {
      data[i] = data[i-1] + data[i-2];
    }
    return data[n];
  }
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(calc_fib(n));
  }
}
