package NarsimhaKarumanchi.bin.tree_Chapter_9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[[a->b],[b->c,b->a,b->h],[c->e,c->d,c->b],[d->c],[e->c,e->f,e->g],[f->e],[g->e],[h->b,h->e]]
		int total_nodes=8;
		String str="b;c,a,h;e,d,b;c;c,f,g;e;e;b,e";
		Graph grp=createGraphFromList(str,total_nodes);
		bfs(grp);
	}
	
	public static void bfs(Graph g)
	{
		Queue<Node> q=new LinkedList<Node>();
		List<Node>ls=g.adjecencyList;
		q.add(ls.get(0));
		while(!q.isEmpty())
		{
			Node n=q.poll();
			System.out.println(n.name);
			n.visited=true;
			List<Edge> lse=n.connections;
			for(Edge e:lse)
			{
				if(!e.end.visited && !q.contains(e.end))
				{
					q.add(e.end);
				}
			}
		}
	}
	
	public static void dfs(Graph g)
	{
		Stack<Node> st=new Stack<Node>();
		List<Node>ls=g.adjecencyList;
		st.add(ls.get(0));
		while(!st.isEmpty())
		{
			Node n=st.pop();
			System.out.println(n.name);
			n.visited=true;
			List<Edge> lse=n.connections;
			for(Edge e:lse)
			{
				if(!e.end.visited && !st.contains(e.end))
				{
					st.add(e.end);
				}
			}
		}
	}
	
	
	public static void printMatrix(int[][] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for( int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	
	public static Graph createGraphFromArray(int[][] arr)
	{
		
		Graph grp=new Graph(arr);
		return grp;
	}
	
	public static Graph createGraphFromList(String str,int total_nodes)
	{
		/*
		 * [[a->b],[b->c,b->a,b->h],[c->e,c->d,c->b],[d->c],[e->c,e->f,e->g],[f->e],[g->e],[h->b,h->e]]
		 * "b;c,a,h;e,d,b;c;c,f,g;e;e;b,e"
		 */
		
		StringTokenizer st=new StringTokenizer(str,";");
		List<Node> node_list=new ArrayList<Node>();
		for(int i=0;i<total_nodes;i++)
		{
			List<Edge> connections=new ArrayList<Edge>();
			String node_letter=getNodeLetter(i);
			Node n=new Node(node_letter, connections);
			node_list.add(n);
		}
		int i=0;	
		while(st.hasMoreTokens())
		{
			Node n1=node_list.get(i);
			List<Edge> lse=n1.connections;
			StringTokenizer st2=new StringTokenizer(st.nextToken(),",");
			while(st2.hasMoreTokens())
			{	
				String s1=st2.nextToken();	
				Node n2=null;	
				for (Node n:node_list)	
				{	
					String s2=n.name;	
					if(s2.equalsIgnoreCase(s1))
					{	
						n2=n;	
						break;
					}
				}
				Edge e=new Edge(n1,n2,1);
				lse.add(e);
			}
			i++;
		}
		Graph grp=new Graph(node_list);
		return grp;
	}
	
	public static String getNodeLetter(int i)
	{
		String s="";
		switch(i)
		{
			case 0: s="a";
					break;
			case 1: s="b";
					break;
			case 2: s="c";
					break;
			case 3: s="d";
					break;
			case 4: s="e";
					break;
			case 5: s="f";
					break;
			case 6: s="g";
					break;
			case 7: s="h";
					break;
			default:s="none";
					break;
		}
		return s;
	}

}
