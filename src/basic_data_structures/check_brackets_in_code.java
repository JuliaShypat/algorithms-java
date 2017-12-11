package basic_data_structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

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

class check_brackets_in_code {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        int wrongIndex = 0;
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);
            if (next == '(' || next == '[' || next == '{') {
            	opening_brackets_stack.push(new Bracket(next, position));
            	if(position + 1 == text.length()) {
            		wrongIndex = position+1;
            	}
            }

            if (next == ')' || next == ']' || next == '}') {
            	if (opening_brackets_stack.empty()) {
            		wrongIndex = position+1;
            		break;
            	}
            	Bracket top = opening_brackets_stack.pop();
            	if (!top.Match(next)) {
            		wrongIndex = position + 1;
            		break;
            	} 
            }
        }
        
        if (wrongIndex > 0 || !opening_brackets_stack.empty()) {
        	System.out.println(wrongIndex);
        } else {
        	System.out.println("Success");
        }
    }
    
    public boolean IsBalanced(String text){
    	return false;
    }
}