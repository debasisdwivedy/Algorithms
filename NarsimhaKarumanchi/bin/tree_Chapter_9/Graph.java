package NarsimhaKarumanchi.bin.tree_Chapter_9;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	List<Node> adjecencyList;
	int[][] adjecencyMatrix;
	
	public Graph(List<Node> nodes)
	{
		this.adjecencyList=nodes;
		adjecencyMatrix=new int[nodes.size()][nodes.size()];
		for(int i=0;i<nodes.size();i++)
		{
			for(int j=0;j<nodes.size();j++)
			{
				adjecencyMatrix[i][j]=0;
			}
		}
		
		for(int i=0;i<nodes.size();i++)
		{
			Node n1=nodes.get(i);
			for(int j=0;j<nodes.size();j++)
			{
				Node n2=nodes.get(j);
				Edge e=new Edge(n1,n2,1);
				if(n1.hasEdge(e))
				{
					adjecencyMatrix[i][j]=e.weight;
					//adjecencyMatrix[j][i]=e.weight;//if undirected
					
				}
				
			}
		}
	}
	
	public Graph(int[][] adjecencyMatrix)
	{
		this.adjecencyMatrix=adjecencyMatrix;
		int size=adjecencyMatrix.length;
		adjecencyList=new ArrayList<Node>();
		for(int i=0;i<size;i++)
		{
			List<Edge> connections1=new ArrayList<Edge>();
			Node n1=new Node(new String(i+""),connections1);
			for(int j=0;j<size;j++)
			{
				Node n2=null;
				List<Edge> connections2=new ArrayList<Edge>();
				if(i<=j)
				{
					n2=new Node(new String(j+""),connections2);
				}
				else
				{
					n2=adjecencyList.get(j);
				}
				if(adjecencyMatrix[i][j]!=0)
				{
					Edge e=new Edge(n1,n2,adjecencyMatrix[i][j]);
					connections1.add(e);
				}
			}
			adjecencyList.add(n1);
		}
	}

}
