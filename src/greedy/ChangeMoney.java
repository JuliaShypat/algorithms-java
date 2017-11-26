package greedy;

import java.util.Scanner;

public class ChangeMoney {
	private static int getChange(int m) {
		int[] anArray = {10, 5, 1};
		int index = 0;
		int numberOfCoins = 0;
        while(m > 0) {
        	if(m >= anArray[index]) {
        		int numb = Math.floorDiv(m, anArray[index]);
        		numberOfCoins += numb;
        		m -= numb * anArray[index];
        		index++;
        	}
        	else {
        		index++;
        	}
        }
        return numberOfCoins;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
	}

}
