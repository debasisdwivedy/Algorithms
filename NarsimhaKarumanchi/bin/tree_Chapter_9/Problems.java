package NarsimhaKarumanchi.bin.tree_Chapter_9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[[a->b],[b->c,b->a,b->h],[c->e,c->d,c->b],[d->c],[e->c,e->f,e->g,e->h],[f->e],[g->e],[h->b,h->e]]
		int total_nodes=6;
		//String str="b;c,a,h;e,d,b;c;c,f,g,h;e;e;b,e";
		String str="b,f;d;b;c;b,d;e";
		String weight="10,8;2;1;-2;-4,-1;1";
		Graph grp=createGraphFromList(str,weight,total_nodes);
		bellmanFord(grp);
	}
	
	/*
	 * 
	 * For graph with negetive edges but it should not have negetive cycles
	 */
	
	public static void bellmanFord(Graph g)
	{
		List<Node> nodes=g.adjecencyList;
		int iterations=nodes.size()-1;
		nodes.get(0).distance=0;
		while(iterations>=0)
		{
		for(int i=0;i<nodes.size();i++)
		{
			Node start=nodes.get(i);
				if(start.distance<Integer.MAX_VALUE)
				{
				List<Edge> lse=start.connections;
				for(int j=0;j<lse.size();j++)
				{
					Node n2=lse.get(j).end;
					int weight=lse.get(j).weight;
					if(n2.distance>start.distance+weight)
					{
						n2.distance=start.distance+weight;
						n2.parent=start;
					}
				}
				
			}
		}
		iterations--;
	}
		for(int i=0;i<nodes.size();i++)
		{
			Node parent=nodes.get(i).parent;
			if(parent==null)
			{
				System.out.println(nodes.get(i).name+"------>"+nodes.get(i).distance+"------>"+parent);
			}
			else
			{
			System.out.println(nodes.get(i).name+"------>"+nodes.get(i).distance+"------>"+parent.name);
			}
		}
	}
	/*
	 * 
	 * For unweighted graphs
	 */
	public static void shortestPathUnweighted(Graph g)
	{
		List<Node> ls=g.adjecencyList;
		calculateShortestPath(ls.get(0));
		for(int i=0;i<ls.size();i++)
		{
			Node parent=ls.get(i).parent;
			if(parent==null)
			{
				System.out.println(ls.get(i).name+"------>"+ls.get(i).distance+"------>"+parent);
			}
			else
			{
			System.out.println(ls.get(i).name+"------>"+ls.get(i).distance+"------>"+parent.name);
			}
		}
	}
	
	public static void shortestPathWeighted(Graph g)
	{
		List<Node> ls=g.adjecencyList;
		calculateShortestPath_dikstras(ls.get(0));
		for(int i=0;i<ls.size();i++)
		{
			Node parent=ls.get(i).parent;
			if(parent==null)
			{
				System.out.println(ls.get(i).name+"------>"+ls.get(i).distance+"------>"+parent);
			}
			else
			{
			System.out.println(ls.get(i).name+"------>"+ls.get(i).distance+"------>"+parent.name);
			}
		}
	}
	
	public static void calculateShortestPath(Node n)
	{
		Queue<Node> q=new LinkedList<Node>();
		n.distance=0;
		q.add(n);
		while(!q.isEmpty())
		{
			n=q.poll();
			List<Edge> edges=n.connections;
			for(int i=0;i<edges.size();i++)
			{
				Node n1=edges.get(i).end;
				if(n1!=null)
				{
					if(n1.distance==Integer.MAX_VALUE)
					{
						n1.distance=n.distance+1;
						n1.parent=n;
						q.add(n1);
					}
				}
			}
		}
	}
	/*
	 * For graphs with weighted positive edges
	 * 
	 */
	public static void calculateShortestPath_dikstras(Node n)
	{
		Queue<Node> q=new LinkedList<Node>();
		n.distance=0;
		q.add(n);
		while(!q.isEmpty())
		{
			n=q.poll();
			List<Edge> edges=n.connections;
			for(int i=0;i<edges.size();i++)
			{
				Node n1=edges.get(i).end;
				if(n1!=null)
				{
					if(n1.distance>n.distance+edges.get(i).weight)
					{
						n1.distance=n.distance+edges.get(i).weight;
						n1.parent=n;
						q.add(n1);
					}
				}
			}
		}
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
	
	public static void topologicalSort(Graph grp)
	{
		List<Node> ls=new ArrayList<Node>();
		List<Node> nodes=grp.adjecencyList;
		for(int i=0;i<nodes.size();i++)
		{
			Node n=nodes.get(i);
			if(!n.visited)
			{
				topologicalSort_using_stack(n,ls);
			}
			n.visited=true;
		}
		for(int i=ls.size()-1;i>=0;i--)
		{
			System.out.println(ls.get(i).name);
		}
	}
	
	public static Node topologicalSort_using_stack(Node n,List<Node> ls)
	{
		if(n!=null)
		{
		List<Edge> lse=n.connections;
		if(lse!=null)
		{
		for(int j=0;j<lse.size();j++)
		{
			topologicalSort_using_stack(lse.get(j).end,ls);
		}
		if(!ls.contains(n))
			ls.add(n);
		}
		}
		return n;
	}
	
	public static void topological_sort_using_queue(Graph g)
	{
		Queue<Node> q=new LinkedList<Node>();
		Node n=null;
		List<Node> ls=g.adjecencyList;
		List<Node> res=chechIncomingConnection(ls);
		for(int i=0;i<res.size();i++)
		{
			n=res.get(i);
			q.add(n);
		}
		while(!q.isEmpty())
		{
			n=q.poll();
			n.visited=true;
			System.out.println(n.name);
			n.connections=null;
			res=chechIncomingConnection(ls);
			for(int i=0;i<res.size();i++)
			{
				n=res.get(i);
				q.add(n);
			}
		}
	}
	
	public static List<Node> chechIncomingConnection(List<Node> ls)
	{
		Set<Node> st=new HashSet<Node>();
		List<Node> result=new ArrayList<Node>();
		for(int i=0;i<ls.size();i++)
		{
			Node n=ls.get(i);
			List<Edge> edges=n.connections;
			if(edges!=null)
			{
				for(int j=0;j<edges.size();j++)
				{
					st.add(edges.get(j).end);
				}
			}
		}
		for(int i=0;i<ls.size();i++)
		{
			Node n=ls.get(i);
			if(!st.contains(n) && !n.visited)
			{
				result.add(n);
			}
		}
		return result;
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
	
	public static Graph createGraphFromList(String str,String weight,int total_nodes)
	{
		/*
		 * [[a->b],[b->c,b->a,b->h],[c->e,c->d,c->b],[d->c],[e->c,e->f,e->g],[f->e],[g->e],[h->b,h->e]]
		 * "b;c,a,h;e,d,b;c;c,f,g;e;e;b,e"
		 */
		
		StringTokenizer st=new StringTokenizer(str,";");
		StringTokenizer weight_tokens=new StringTokenizer(weight,";");
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
			StringTokenizer weight_tokens2=new StringTokenizer(weight_tokens.nextToken(),",");
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
				Edge e=new Edge(n1,n2,Integer.parseInt(weight_tokens2.nextToken()));
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
