import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static Node[] tree;
	
	static class Node{
		char name;
		Node left;
		Node right;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		tree = new Node[N];
		
		for(int i = 0; i < N; i++) {
			tree[i] = new Node();
		}
		
		Node cur;
		char name;
		int leftIndex, rightIndex;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken().charAt(0);
			leftIndex = st.nextToken().charAt(0) - 'A';
			rightIndex = st.nextToken().charAt(0) - 'A';
			
			cur = tree[name - 'A'];
			cur.name = name;
			if(leftIndex >= 0) cur.left = tree[leftIndex];
			if(rightIndex >= 0) cur.right = tree[rightIndex];
		}
		
		preorder(tree[0]);
		output.append("\n");
		
		inorder(tree[0]);
		output.append("\n");
		
		postorder(tree[0]);
		output.append("\n");
		
		System.out.println(output);
	}
	
	public static void preorder(Node cur) {
		output.append(cur.name);
		if(cur.left != null) preorder(cur.left);
		if(cur.right != null) preorder(cur.right);
	}
	
	public static void inorder(Node cur) {
		if(cur.left != null) inorder(cur.left);
		output.append(cur.name);
		if(cur.right != null) inorder(cur.right);
	}
	
	public static void postorder(Node cur) {
		if(cur.left != null) postorder(cur.left);
		if(cur.right != null) postorder(cur.right);
		output.append(cur.name);
	}

}