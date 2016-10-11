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
}
