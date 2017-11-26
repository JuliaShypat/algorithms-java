package greedy;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
Example:
Input:
3 50
60 20
100 50
120 30
Output:
180.0000
Explanation:
To achieve the value 180, we take the first item and the third item into the bag
 */

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights, double[][] weightPerValue) {
        double value = 0;
        double temp = 0;
        int index = 0;
        for (int i = 0; i < values.length; i++) {
        	if(capacity == 0) {
        		return roundDecimal(value);
        	}
        	index = (int)weightPerValue[i][1]; 
        	double capcityUsed = Math.min(weights[index], capacity);
        	double valueAdded = (double) (weightPerValue[i][0] * capcityUsed);
        	value += valueAdded;
        	capacity -= capcityUsed;
        }
        return roundDecimal(value);
    }
    
    private static double roundDecimal(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.####");
        return Double.valueOf(twoDForm.format(d));
    }
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        double[][] weightPerValue = new double[n][2];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        	weightPerValue[i][0] = (double)values[i] / (double)weights[i];
        	weightPerValue[i][1] = i;
        }
        Arrays.sort(weightPerValue, new Comparator<double[]>() {
            @Override
            public int compare(final double[] entry1, final double[] entry2) {
                final Double value1 = entry1[0];
                final Double value2 = entry2[0];
                return value2.compareTo(value1);
            }
        });

        System.out.println(getOptimalValue(capacity, values, weights, weightPerValue));
    }
} 
