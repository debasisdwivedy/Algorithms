package tree_Chapter_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Problems {
	
	public static Tree createTree(int[] arr)
	{
		Tree root=new Tree(arr).root;
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1=new int[]{1,2,3,4,5,6,7};
		int[] arr2=new int[]{1,2,4,6,8};
		Tree root1=new Tree("bst",arr1).root;
		//Tree lca=LCA_BST(root1,new Tree(1),new Tree(2));
		
		Tree res=nextLargestNode(root1,4);
		System.out.println(res.data);
	}

	public static void preOrder_recursive(Tree root)
	{
		if(root==null)
		{
			return;
		}
		System.out.print(root.data+" ");
		preOrder_recursive(root.left);
		preOrder_recursive(root.right);
	}
	
	public static void preOrder_iterative(Tree root)
	{
		Stack<Tree> st=new Stack<Tree>();
		st.push(root);
		while(!st.isEmpty())
		{
			Tree temp=st.pop();
			if(temp!=null)
			{
			System.out.print(temp.data+" ");
			st.push(temp.right);
			st.push(temp.left);
			}
		}
	}
	
	public static void inOrder_recursive(Tree root)
	{
		if(root!=null)
		{
			inOrder_recursive(root.left);
			System.out.print(root.data+" ");
			inOrder_recursive(root.right);
		}
	}
	
	public static void inOrder_iterative(Tree root)
	{
		Stack<Tree> st=new Stack<Tree>();
		st.push(root);
		while(!st.isEmpty())
		{
		while(root!=null)
		{
			if(root.left!=null)
			{
			st.push(root.left);
			}
			root=root.left;
		}
		Tree node=st.pop();
		System.out.print(node.data+" ");
		if(node.right!=null)
		{
			root=node.right;
			st.push(root);
		}
		}
	}
	
	public static void postOrder_recursive(Tree root)
	{
		if(root!=null)
		{
			postOrder_recursive(root.left);
			postOrder_recursive(root.right);
			System.out.print(root.data+" ");
		}
	}
	
	public static void postOrder_iterative(Tree root)//LRD
	{
		Stack<Tree> st=new Stack<Tree>();
		Stack<Tree> new_st=new Stack<Tree>();
		st.push(root);
		while(!st.isEmpty())
		{
			while(root!=null)
			{
				if(root.left!=null)
				{
					st.push(root.left);
				}
				root=root.left;
			}
			
			if(st.peek().right==null)
			{
				root=st.pop();
				System.out.print(root.data);
			}
			else
			{
				root=root.right;
				st.push(root);
			}
			
			
		}
		
	}
	
	public static void levelOrderTraversal(Tree root)
	{
		Queue<Tree> q=new LinkedList<Tree>();
		q.add(root);
		while(!q.isEmpty())
		{
			Tree node=q.poll();
			System.out.print(node.data+" ");
			if(node.left!=null)
				q.add(node.left);
			if(node.right!=null)
				q.add(node.right);
		}
	}
	
	public static Tree getMaxNode_recursive(Tree root)
	{
		if (root==null)
		{
			return null;
		}
		Tree node1=null;
		Tree node2=null;
		Tree maxNode=null;
		
			if(root.left!=null)
				node1=getMaxNode_recursive(root.left);
			if(root.right!=null)
				node2=getMaxNode_recursive(root.right);
			int data1=(node1!=null)?node1.data:Integer.MIN_VALUE;
			int data2=(node2!=null)?node2.data:Integer.MIN_VALUE;
			if(data1==Integer.MIN_VALUE && data2==Integer.MIN_VALUE)
			{
				maxNode=root;
			}
			else
			{
				maxNode=(data1>data2)?node1:node2;
				maxNode=(root.data>maxNode.data)?root:maxNode;
			}
		
		return maxNode;
	}
	
	public static Tree getMaxNode_iterative(Tree root)
	{
		if(root==null)
		{
			return null;
		}
		Tree maxNode=null;
		Stack<Tree> st=new Stack<Tree>();
		st.push(root);
		while(!st.isEmpty())
		{
			Tree temp=st.pop();
			if(maxNode==null || maxNode.data<temp.data)
			{
				maxNode=temp;
			}
			if(temp.right!=null)
				st.push(temp.right);
			if(temp.left!=null)
				st.push(temp.left);
		}
		return maxNode;
	}
	
	public static Tree searchBinaryTree_recursive(Tree root,int data)
	{
		Tree node=null;
		if(root!=null)
		{
			if(root.data==data)
			{
				node=root;
			}
			else
			{
				node=(searchBinaryTree_recursive(root.left,data)!=null)?
						searchBinaryTree_recursive(root.left,data):searchBinaryTree_recursive(root.right,data);
			}
		}
		return node;
	}
	
	public static Tree searchBinaryTree_iterative(Tree root,int data)
	{
		if(root==null)
		{
			return null;
		}
		Tree node=null;
		Stack<Tree> st=new Stack<Tree>();
		st.push(root);
		
		while(!st.isEmpty())
		{
			Tree temp=st.pop();
			if(temp.data==data)
			{
				node=temp;
			}
			else
			{
				if(temp.left!=null)
					st.push(temp.left);
				if(temp.right!=null)
					st.push(temp.right);
			}
		}
		return node;
	}
	
	public static void insertNodeBinaryTree(Tree root,Tree node)
	{
		if(root==null)
		{
			return;
		}
		
		Queue<Tree> q=new LinkedList<Tree>();
		q.add(root);
		while(q!=null && !q.isEmpty())
		{
			Tree temp=q.poll();
			if(temp.left==null)
			{
				temp.left=node;
				q=null;
			}
			else if(temp.right==null)
			{
				temp.right=node;
				q=null;
			}
			else
			{
				q.add(temp.left);
				q.add(temp.right);
			}
			
		}
	}
	
	public static int calculateSize_recursive(Tree root)
	{
		//Count the number of nodes in a binary tree
		if(root==null)
		{
			return 0;
		}
		return 1+calculateSize_recursive(root.left)+calculateSize_recursive(root.right);
	}
	
	public static int calculateSize_iterative(Tree root)
	{
		int result=0;
		if(root==null)
		{
			return result;
		}
		Stack<Tree> st=new Stack<Tree>();
		st.push(root);
		while(!st.isEmpty())
		{
			Tree node=st.pop();
			result++;
			if(node.left!=null)
				st.push(node.left);
			if(node.right!=null)
				st.push(node.right);
		}
		return result;
	}
	
	public static void printReverseLevelOrderSearch(Tree root)
	{
		int level=0;
		HashMap<Integer,ArrayList<Tree>> hm=new HashMap<Integer,ArrayList<Tree>>();
		reverseLevelOrderSearch(root,level,hm);
		int size=hm.size();
		for(int i=size-1;i>=0;i--)
		{
			ArrayList<Tree> levelTree=hm.get(i);
			for(int j=0;j<levelTree.size();j++)
			{
				System.out.print(levelTree.get(j).data+" ");
			}
		}
		
	}
	public static void reverseLevelOrderSearch(Tree root,int level,HashMap<Integer,ArrayList<Tree>> hm)
	{
		if(root==null)
		{
			return;
		}
		ArrayList<Tree> temp=hm.get(level);
		if(temp==null)
		{
			temp=new ArrayList<Tree>();
		}
		temp.add(root);
		hm.put(level,temp);
		reverseLevelOrderSearch(root.left,level+1,hm);
		reverseLevelOrderSearch(root.right,level+1,hm);
	}
	
	public static int depthBinaryTree_recursive(Tree root)
	{
		if(root==null)
		{
			return 0;
		}
		int depth_left=1+depthBinaryTree_recursive(root.left);
		int depth_right=1+depthBinaryTree_recursive(root.right);
		if(depth_left>depth_right)
			return depth_left;
		else
			return depth_right;
		
	}
	
	public static int depthBinaryTree_iterative(Tree root)
	{
		if(root==null)
			return 0;
		
		Queue<Tree> q=new LinkedList<Tree>();
		q.add(root);
		q.add(null);
		int height=0;
		while(!q.isEmpty())
		{
			Tree node=q.poll();
			if(node==null)
			{
				height++;
				if(!q.isEmpty())
					q.add(null);
			}
			else
			{
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
			}
		}
		return height;
	}
	
	public static boolean compareBinaryTree(Tree root1,Tree root2)
	{
		if(root1==null && root2==null)
		{
			return true;
		}
		else
		{
			if(root1==null ||root2==null)
			{
				return false;
			}
			if(root1.data!=root2.data)
			{
				return false;
			}
			else
			{
				return compareBinaryTree(root1.left,root2.left) && compareBinaryTree(root1.right,root2.right);
			}
			}
	}
	
	public static int binaryTreeDiameter(Tree root,int max)
	{
		if(root==null)
		{
			return 0;
		}
		
		int left_depth=1+binaryTreeDiameter(root.left,max);
		int right_depth=1+binaryTreeDiameter(root.right,max);
		
		if(left_depth+right_depth-1>max)
		{
			max=left_depth+right_depth-1;
		}
		return max;
	}
	
	public static int getMaxLevelSum(Tree root)
	{
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		sumBinaryTree(root,0,hm);
		int max=Integer.MIN_VALUE;
		int level=-1;
		for(int i=0;i<hm.size();i++)
		{
			if(max<hm.get(i))
			{
				max=hm.get(i);
				level=i;
			}
		}
		return level;
	}
	
	public static void sumBinaryTree(Tree root,int level,HashMap<Integer,Integer> hm)
	{
		if(root==null)
		{
			return;
		}
		Integer sum=hm.get(level);
		if(sum==null)
		{
			sum=new Integer(0);
		}
		sum=sum+root.data;
		hm.put(level, sum);
		sumBinaryTree(root.left,level+1,hm);
		sumBinaryTree(root.right,level+1,hm);
		
	}
	
	public static void printAll_Root_Leaf_Path(Tree root,ArrayList<Tree> path,ArrayList<ArrayList<Tree>> paths)
	{
		/*
		 *    1
		 *   2 3
		 * 4 5 6 7
		 */
		
		if(root==null)
		{
			return;
		}
		
		path.add(root);
		if(root.left==null && root.right==null)
		{
			ArrayList<Tree> temp=new ArrayList<Tree>();
			for(int i=0;i<path.size();i++)
			{
				temp.add(path.get(i));
			}
			paths.add(temp);
		}
		if(root.left!=null)
		{
			printAll_Root_Leaf_Path(root.left,path,paths);
			path.remove(root.left);
		}
		if(root.right!=null)
		{
			printAll_Root_Leaf_Path(root.right,path,paths);
			path.remove(root.right);
		}	
	}
	
	public static boolean pathWithSum(Tree root,int sum,int node_sum)
	{
		boolean result=false;
		if(root==null)
		{
			return false;
		}
		
		if(node_sum+root.data==sum)
		{
			return true;
		}
		if(root.left!=null)
		{
			result=result||pathWithSum(root.left,sum,node_sum+root.data);
		}
		if(root.right!=null && !result)
		{
			result=result||pathWithSum(root.right,sum,node_sum+root.data);
		}
		
		return result;
	}
	
	public static Tree mirrorBinaryTree(Tree tree1)
	{
		if(tree1==null)
		{
			return null;
		}
		Tree tree2=new Tree(tree1.data);
		tree2.right=mirrorBinaryTree(tree1.left);
		tree2.left=mirrorBinaryTree(tree1.right);
		return tree2;
	}
	
	public static boolean checkMirror(Tree tree1,Tree tree2)
	{
		if(tree1==null && tree2==null)
		{
			return true;
		}
		else if((tree1==null && tree2!=null) || (tree1!=null && tree2==null))
		{
			return false;
		}
		else
		{
			if(tree1.data==tree2.data)
			{
				return checkMirror(tree1.left,tree2.right) && checkMirror(tree1.right,tree2.left);
			}
			else
			{
				return false;
			}
		}
	}
	
	public static Tree LCA(Tree root,int node1,int node2)
	{
		if(root==null)
		{
			return null;
		}
		Tree left_node=null;
		Tree right_node=null;
		
		if(root.left!=null)
		{
			left_node=LCA(root.left,node1,node2);
		}
		if(root.right!=null)
		{
			right_node=LCA(root.right,node1,node2);
		}
		if(root.data==node1 || root.data==node2)
		{
			return root;
		}
		else if(left_node!=null && right_node!=null)
		{
			return root;
		}
		else if(left_node!=null && right_node==null)
		{
			return left_node;
		}
		else if(left_node==null && right_node!=null)
		{
			return right_node;
		}
		else
		{
			return null;
		}
		
	}
	
	public static Tree binaryTree_From_InOdr_PosOrd(String inorder,String postorder)
	{
		/*
		 * Inorder = L D R = [4 2 5 1 6 3 7]
		 * Postorder= L R D = [4 5 2 6 7 3 1]
		 * 
		 */
		if(inorder.length()==0 || postorder.length()==0)
		{
			return null;
		}
		Tree root=null;
		char node=postorder.charAt(postorder.length()-1);
		int index=inorder.indexOf(node);
		root=new Tree(Integer.parseInt(node+""));
		String left=inorder.substring(0, index);
		String right=inorder.substring(index+1);
		if(left.length()>0)
		{
			root.left=binaryTree_From_InOdr_PosOrd(left,postorder.substring(0,left.length()));
		}
		if(right.length()>0)
		{
			root.right=binaryTree_From_InOdr_PosOrd(right,postorder.substring(right.length(),postorder.length()-1));
		}
		return root;
	}
	
	public static Tree binaryTree_From_InOdr_PreOrd(String inorder,String preorder)
	{
		/*
		 * Inorder = L D R = [4 2 5 1 6 3 7]
		 * Preorder= D L R = [1 2 4 5 3 6 7]
		 * 
		 */
		if(inorder.length()==0 || preorder.length()==0)
		{
			return null;
		}
		
		char node=preorder.charAt(0);
		int index=inorder.indexOf(node);
		Tree root=new Tree(Integer.parseInt(node+""));
		String left=inorder.substring(0,index);
		String right=inorder.substring(index+1);
		if(left.length()>0)
		{
			root.left=binaryTree_From_InOdr_PreOrd(left,preorder.substring(1,left.length()+1));
		}
		if(right.length()>0)
		{
			root.right=binaryTree_From_InOdr_PreOrd(right,preorder.substring(left.length()+1));
		}
		return root;
	}
	
	public static void binaryTree_From_InOdr_levlOrd(String inorder,String levelorder)
	{
		/*
		 * Inorder = L D R = [4 2 5 1 6 3 7]
		 * Levelorder= D L R = [1 2 3 4 5 6 7]
		 * 
		 */
		
		if(inorder.length()==0 || levelorder.length()==0)
		{
			return;
		}
		
	}
	
	public static Tree printAllAncestors(Tree root,int node)
	{
		if(root==null)
		{
			return null;
		}
		Tree left_node=null;
		Tree right_node=null;
		left_node=printAllAncestors(root.left,node);
		right_node=printAllAncestors(root.right,node);
		if(root.data==node || left_node!=null || right_node!=null)
		{
			System.out.println(root.data);
			return root;
		}
		else
		{
			return null;
		}
	}
	
	public static void zigzag_Traversal(Tree root)
	{
		if(root==null)
		{
			return;
		}
	}
	
	public static Tree LCA_BST(Tree root,Tree node1,Tree node2)
	{
		Tree lowernode=(node1.data<node2.data)?node1:node2;
		Tree highernode=(node1.data>node2.data)?node1:node2;
		
		Tree node=root;
		Tree LCA=null;
		while(node!=null)
		{
			if(node.data>=lowernode.data && node.data<=highernode.data)
			{
				LCA=node;
				break;
			}
			else if(node.data>lowernode.data && node.data>highernode.data)
			{
				node=node.left;
			}
			else
			{
				node=node.right;
			}
		}
		return LCA;
	}
	
	public static boolean isBST(Tree root)
	{
		if(root==null)
		{
			return false;
		}
		
		if(root.left!=null && root.right!=null)
		{
		if((root.left.data>=root.data) || (root.right.data<=root.data))
		{
			return false;
		}
		else
		{
				return (isBST(root.left)) && (isBST(root.right));
		}
		}
		else
		{
			if(root.left==null && root.right==null)
				return true;
			else if(root.left==null)
				return isBST(root.right);
			else
				return isBST(root.left);
		}
	}
	
	public static boolean isBST_inorder(Tree root,int prev)
	{
		if(root==null)
		{
			return true;
		}
		if(!isBST_inorder(root.left,prev)){
			return false;
		}
		if(root.data<prev)
		{
			return false;
		}
		prev=root.data;
		return isBST_inorder(root.right,prev);
	}
	/*
	 * 
	 * Needs modifications
	 */
	public static Tree bstTOdll(Tree root,TreeDLL td,TreeDLL res)
	{
		if(root==null)
		{
			return null;
		}
		Tree left=null;
		Tree right=null;
		td=new TreeDLL(root.data);
		res=td;
		if(root.left!=null)
		{
			left=bstTOdll(root.left,td,res);
			td.left=left;
		}
		if(root.right!=null)
		{
			right=bstTOdll(root.right,td,res);
			td.right=right;
		}
		return root;
	}
	
	public static Tree arrayToBST(int[] arr,int start,int end)
	{
		if(end-start<0)
		{
			return null;
		}
		
		Tree left=arrayToBST(arr,start,((start+end)/2)-1);
		Tree right=arrayToBST(arr,((start+end)/2)+1,end);
		Tree root=new Tree(arr[(start+end)/2]);
		if(left!=null)
			root.left=left;
		if(right!=null)
			root.right=right;
		
		return root;
	}
	
	public static Tree sllToBST(LinkedList<Integer> lst,int start,int end)
	{
		int size=end-start;
		if(size<=0)
		{
			return null;
		}
		
		Tree left=sllToBST(lst,start,end/2);
		Tree root=new Tree(lst.get((start+end)/2));
		Tree right=sllToBST(lst,((start+end)/2)+1,end);
		root.left=left;
		root.right=right;
		
		return root;
	}
	
	public static int kSmallestBST(Tree root,int k,int index)
	{
		if(root==null)
		{
			return 0;
		}
		
		if(root.left==null && root.right==null)
		{
			if(index+1==k)
			{
				System.out.println(root.data);
			}
			return index+1;
		}
		if(root.left!=null)
			index=kSmallestBST(root.left,k,index);
		
		if(index+1==k)
		{
			System.out.println(root.data);
		}
		
		if(root.right!=null)
			index=kSmallestBST(root.right,k,index+1);
		
		
		return index;
		
	}
	
	public static Tree nextSmallestNode(Tree root,int node)
	{
		if(root==null)
		{
			return null;
		}
		Tree res=null;
		if(root.left!=null)
			res=nextSmallestNode(root.left,node);
		if(root.data==node)
		{
			System.out.println(res.data);
			return res;
		}
		
		if(root.right!=null)
			res=nextSmallestNode(root.right,node);
		if(res==null)
			return root;
		else
			return res;
	}
	
	public static Tree nextLargestNode(Tree root,int node)
	{
		if(root==null)
		{
			return null;
		}
		Tree res=null;
		
		
		if(root.right!=null)
			res=nextLargestNode(root.right,node);
		
		if(root.data==node)
		{
			return res;
		}
		
		if(root.left!=null)
			res=nextLargestNode(root.left,node);
		
		
		
		if(res!=null)
			return res;
		else
			return root;
		
	}
	
	public static void elementsInRangeBST(Tree root, int k, int m)
	{
		
	}
}
