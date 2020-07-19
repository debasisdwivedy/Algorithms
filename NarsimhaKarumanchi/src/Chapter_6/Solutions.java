package Chapter_6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.lang.model.util.ElementScanner6;

class Tree
{
	int data;
	Tree left;
	Tree right;
	public Tree(int data, Tree left, Tree right)
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public void createTreeFromArray()
	{

	}
}

public class Solutions {

	int max=0;
	
	public static void main(String[] args)
	{

	}

	public static int getMaxElementRecurse(Tree root)
	{
		if(root==null)
		{
			return Integer.MIN_VALUE;
		}
		int left = getMaxElementRecurse(root.left);
		int right = getMaxElementRecurse(root.right);
		int child_max = left>right? left:right;
		return root.data>child_max?root.data:child_max;
	}

	public static int getMaxElementIter(Tree root)
	{
		int max = Integer.MIN_VALUE;
		Stack<Tree> stk = new Stack<>();
		stk.push(root);
		while(!stk.isEmpty())
		{
			Tree node = stk.pop();
			if(node.data>max)
			{
				max = node.data;
			}
			if(node.left!=null)
				stk.push(node.left);
			if(node.right!=null)
				stk.push(node.right);

		}
		return max;
	}

	public static boolean searchElementRecurse(Tree root, int elem)
	{
		if(root==null)
		{
			return false;
		}
		if(root.data == elem)
		{
			return true;
		}
		else
		{
			return searchElementRecurse(root.left,elem) || searchElementRecurse(root.right,elem);
		}
	}

	public static boolean searchElementIter(Tree root, int elem)
	{
		boolean searchStatus=false;
		Stack<Tree> stk = new Stack<>();
		stk.push(root);
		while(!stk.isEmpty())
		{
			Tree node = stk.pop();
			if(node.data == elem)
			{
				searchStatus=true;
				break;
			}
			if(node.left!=null)
			{
				stk.push(node.left);
			}
			if(node.right!=null)
			{
				stk.push(node.right);
			}
		}
		return searchStatus;
	}

	public static int getSize(Tree root)
	{
		if(root==null)
		{
			return 0;
		}
		return 1+getSize(root.left)+getSize(root.right);
	}

	public static void lfs_reverse(Tree root)
	{
		if(root==null)
		{
			return;
		}
		Queue<Tree> q = new LinkedList<>();
		Stack<Tree> stk = new Stack<>();
		q.add(root);
		while(!q.isEmpty())
		{
			Tree node = q.poll();
			q.add(node.right);
			q.add(node.left);
			stk.push(node);
		}
		while(!stk.isEmpty())
		{
			System.out.println(stk.pop().data);
		}
	}

	public static int depth1(Tree root)
	{
		if(root==null)
		{
			return 0;
		}
		int depth=0;
		Queue<Tree> q = new LinkedList<>();
		Tree marker = new Tree(-1,null,null);
		q.add(root);
		q.add(marker);

		while(!q.isEmpty())
		{
			Tree node=q.poll();
			if(node!=marker)
			{
				q.add(node.left);
				q.add(node.left);
			}
			else{
				depth++;
				if(!q.isEmpty())
				{
					q.add(marker);
				}
			}
		}
		return depth;
	}

	public  void depth2(Tree root,int depth)
	{
		if(root==null)
		{
			return;
		}
		if(max<depth)
		{
			max=depth;
		}
		if(root.left!=null)
			depth2(root.left,1+depth);
		if(root.right!=null)
			depth2(root.left,1+depth);

		
	}

	public boolean isIdentical(Tree root1,Tree root2)
	{
		if(root1==null && root2==null)
		{
			return true;
		}
		if(root1==null || root2==null)
		{
			return false;
		}
		else{
			return root1.data==root2.data && isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
		}
		
	}

	public void allRootToLeafPath(Tree root,String path)
	{
		if(root==null)
		{
			return;
		}
		if(root.left==null && root.right==null)
		{
			System.out.println(path);
		}
		else{
			allRootToLeafPath(root.left,path+","+root.data);
			allRootToLeafPath(root.right,path+","+root.data);
		}
	}

	public boolean isSumExsist(Tree root,int sum)
	{
		if(root==null || sum<0)
		{
			return false;
		}
		if(sum==0)
		{
			return true;
		}
		return isSumExsist(root.left,sum-root.data) || isSumExsist(root.right,sum-root.data);

	}

	public Tree createMirror(Tree root)
	{
		if(root==null)
		{
			return null;
		}
		root.right=createMirror(root.left);
		root.left=createMirror(root.right);
		return root;
	}

	public boolean isMirror(Tree root1,Tree root2)
	{
		if(root1==null && root2==null)
		{
			return true;
		}
		if(root1 !=null && root2!=null && root1.data==root2.data)
		{
			return isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
		}
		else
		{
			return false;
		}
	}

	public Tree lca(Tree root,Tree elem1,Tree elem2)
	{
		if(root==null)
		{
			return null;
		}

		if(root==elem1 || root==elem2)
		{
			return root;
		}
		Tree node1 = lca(root.left,elem1,elem2);
		Tree node2 = lca(root.right,elem1,elem2);

		if(node1!=null && node2!=null)
		{
			return root;
		}
		else if(node1==null && node2!=null)
		{
			return node2;
		}
		else if(node1!=null && node2==null)
		{
			return node1;
		}
		else
		{
			return null;
		}


	}

	public void widthBinaryTree(Tree root)
	{

	}
}
