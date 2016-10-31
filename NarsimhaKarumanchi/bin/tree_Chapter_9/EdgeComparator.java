package NarsimhaKarumanchi.bin.tree_Chapter_9;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge>{

	@Override
	public int compare(Edge e1, Edge e2) {
		// TODO Auto-generated method stub
		if(e1.weight>e2.weight)
		{
			return 1;
		}
		else if(e1.weight<e2.weight)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}

}
