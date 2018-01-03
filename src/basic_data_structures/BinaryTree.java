package basic_data_structures;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;


class Node{
    int data;
    Node left, right;
 
    public Node(int item)    {
        data = item;
        left = right = null;
    }
}
 
public class BinaryTree {
    Node root;
    
    int size()
    {
        return size(root);
    }
 
    int size(Node node)
    {
        if (node == null)
            return 0;
        else
            return(size(node.left) + 1 + size(node.right));
    }
    
	
	public static void main(String[] args) throws IOException {
		int n;
		int parent[];
		
        BinaryTree tree = new BinaryTree();
        FastScanner in = new FastScanner();
		n = in.nextInt();
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = in.nextInt();
			System.out.println(parent[i]);
		}        
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("The size of binary tree is : "
                            + tree.size());

	}
}

class FastScanner {
	StringTokenizer tok = new StringTokenizer("");
	BufferedReader in;

	FastScanner() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() throws IOException {
		while (!tok.hasMoreElements())
			tok = new StringTokenizer(in.readLine());
		return tok.nextToken();
	}
	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
}
