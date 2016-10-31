package NarsimhaKarumanchi.bin.tree_Chapter_9;
import java.util.ArrayList;
import java.util.List;

public class Node{
	String name;
	List<Edge> connections;
	boolean visited=false;//for bfs and dfs
	int distance=Integer.MAX_VALUE;//for shortest path calculation
	Node parent=null;//for shortest path calculation
	
	public Node(String name,List<Edge> connections)
	{
		this.name=name;
		this.connections=connections;
	}
	
	public List<Integer> hasEdge(Edge e)
	{
		List<Integer> result=new ArrayList<Integer>();
		result.add(-1);
		result.add(Integer.MAX_VALUE);
		if(e.start!=null && e.end!=null)
		{
		for(int i=0;i<connections.size();i++)
		{
			Edge temp=connections.get(i);
			if(temp.start!=null && temp.end!=null)
			{
			if(temp.start.name.equalsIgnoreCase(e.start.name) && temp.end.name.equalsIgnoreCase(e.end.name))
			{
				result.add(0,1);
				result.add(1,temp.weight);
				break;
			}
		}
		}
		}
		return result;
	}

}
