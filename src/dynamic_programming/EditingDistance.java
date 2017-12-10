package dynamic_programming;
import java.util.*;

public class EditingDistance {
	public static int EditDistance(String s, String t) {
	    int [][] solution = new int[s.length() + 1][t.length() + 1];
	    
	    for (int i = 0; i <= t.length(); i++) {
            solution[0][i] =i;
        }

        for (int i = 0; i <= s.length(); i++) {
            solution[i][0] =i;
        }
        
        int m = s.length();
        int n = t.length();
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(s.charAt(i-1)==t.charAt(j-1))
                    solution[i][j] = solution[i-1][j-1];
                else
                    solution[i][j] = 1 + Math.min(solution[i][j-1], //Insert
                                         Math.min(solution[i-1][j], // Remove
                                         solution[i-1][j-1])); //Replace
            }
        }
        return solution[s.length()][t.length()];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

	    String s = scan.next();
	    String t = scan.next();

	    System.out.println(EditDistance(s, t));

	}

}
