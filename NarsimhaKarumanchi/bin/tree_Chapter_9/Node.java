package NarsimhaKarumanchi.bin.tree_Chapter_9;

import java.util.List;

public class Node {
	String name;
	List<Edge> connections;
	boolean visited=false;
	
	public Node(String name,List<Edge> connections)
	{
		this.name=name;
		this.connections=connections;
	}
	
	public boolean hasEdge(Edge e)
	{
		boolean flag=false;
		if(e.start!=null && e.end!=null)
		{
		for(int i=0;i<connections.size();i++)
		{
			Edge temp=connections.get(i);
			if(temp.start!=null && temp.end!=null)
			{
			if(temp.start.name.equalsIgnoreCase(e.start.name) && temp.end.name.equalsIgnoreCase(e.end.name))
			{
				flag= true;
				break;
			}
		}
		}
		}
		return flag;
	}

}
