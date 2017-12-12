package basic_data_structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

/*
 * Matching closing brackets
 * 	Input:
	[]
	Output:
	Success
 * 
 * 	Input:
	foo(bar[i);
	Output:
	10
 * */

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}
class StackofBrackets{ 
    static Stack<Bracket> o_brackets_stack = new Stack<Bracket>();
    static int wrongPosition;
}

class check_brackets_in_code {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        if(IsBalanced(text)) 
        	System.out.println("Success");
        else 
        	System.out.println(StackofBrackets.wrongPosition);
    }
    
    public static boolean IsBalanced(String text){
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);
            if (next == '(' || next == '[' || next == '{') {
            	StackofBrackets.o_brackets_stack.push(new Bracket(next, position));
            	if(position + 1 == text.length()) {
            		StackofBrackets.wrongPosition = position + 1;
            	}
            }
            else if (next == ')' || next == ']' || next == '}') {
            	if (StackofBrackets.o_brackets_stack.empty()) {
            		StackofBrackets.wrongPosition = position + 1;
            		return false;
            	}
            	Bracket top = StackofBrackets.o_brackets_stack.pop();
        		StackofBrackets.wrongPosition = top.position;
            	if (!top.Match(next)) {
            		StackofBrackets.wrongPosition = position + 1;
            		return false;
            	} 
            } 
        }
       return StackofBrackets.o_brackets_stack.empty();
    }
}