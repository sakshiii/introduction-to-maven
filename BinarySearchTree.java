
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	//BASIC NODE
	class Node{
		int key;
		Node left,right;
		
		Node(int key){
			this.key=key;
		}
	}
	
	//DATA MEMBER OF BST CLASS
	Node root;
	
	public BinarySearchTree() {
		root=null;
	}
	
	//INSERTION INTO BST
	public void insert(int key){
		root=insertRec(root,key);
	}
	
	
	private Node insertRec(Node root, int key) {
		if(root==null){
			root= new Node(key);
			return root;
		}
		//now check the value at root and compare it
		if(key<root.key)
			root.left=insertRec(root.left, key);
		else
			root.right=insertRec(root.right, key);
		
		return root;
		
	}
	
	//DFS 1.INORDER Traversal
	void inorder(){
		inorderRec(root);
	}

	private void inorderRec(Node root) {
		if(root!=null){
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}
	//DFS 2.PREORDER traversal
	public void preorder(){
		preorderRec(root);
	}
	
	private void preorderRec(Node root) {
		if(root!=null){
		System.out.println(root.key);
		preorderRec(root.left);
		preorderRec(root.right);
		}
	}
	//DFS 3.POSTORDER
	public void postorder(){
		postorderRec(root);
	}
	private void postorderRec(Node root) {
		
		if(root!=null){
		postorderRec(root.left);
		postorderRec(root.right);
		System.out.println(root.key);
		}
	}
	//SEARCH AN ELEMENT IN BST
	public  boolean search(int val){
		return searchRec(root,val);
	}
	private boolean searchRec(Node root,int key){
		
			if(root==null )
				return false;
			if(root.key==key)
				return true;
			else if(root.key>key)
				return searchRec(root.left,key);
			else
				return searchRec(root.right,key);
			
	}
	
	//get height
	public int getHeight(){
		return getHeightRec(root);
	}

	private int getHeightRec(Node root) {
		if(root==null)
			return -1;
		int leftHeight=1+getHeightRec(root.left);
		int rightHeight=1+getHeightRec(root.right);
		return (Math.max(leftHeight, rightHeight)+1);
	}
	
	//LEVEL ORDER TRAVERSAL OR BFS -->> PRINT THE TREE LEVEL WISE
	public void bfs(){
		bfsInner(root);
	}
	

	private void bfsInner(Node root) {
		Queue<Node> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node temp=queue.poll();
			System.out.print(temp.key+" ");
			if(temp.left!=null){
				queue.add(temp.left);	
			}
			if(temp.right!=null){
				queue.add(temp.right);	
			}
					
		}
		
		
	}

	public static void main(String[] args) {
	
		  /* 
		   * Let us create following BST 
			       50 
			     /     \ 
			    30      70 
			   /  \    /  \ 
			 20   40  60   80 
		*/
		BinarySearchTree tree=new BinarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		tree.inorder();
		boolean n=tree.search(10);
		System.out.println("\nIs element 10 present in the tree? "+n);
		System.out.println("\nheight:"+tree.getHeight());
		System.out.println("\nBFS for the tree:");
		tree.bfs();
	}

}
