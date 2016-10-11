package tree_Chapter_6;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	Tree root;
	int data;
	Tree left;
	Tree right;
	
	public Tree(int data)
	{
		this.data=data;
	}
	
	public Tree(int[] num)
	{
		Queue<Tree> q=new LinkedList<Tree>();
		int i=0;
		this.root=new Tree(num[i]);
		i=i+1;
		q.add(root);
		while(!q.isEmpty() && i<num.length)
		{
			Tree t=q.poll();
			if(i<num.length)
			{
				t.left=new Tree(num[i]);
				q.add(t.left);
			}
			if(i+1<num.length)
			{
				t.right=new Tree(num[i+1]);
				q.add(t.right);
			}
			i=i+2;
		}
	}

}

