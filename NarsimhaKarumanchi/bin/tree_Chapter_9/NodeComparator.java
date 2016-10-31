package NarsimhaKarumanchi.bin.tree_Chapter_9;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node>{

	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * 
	 * Priority Queue for Minimum spanning tree
	 */

	@Override
	public int compare(Node n1, Node n2) {
		// TODO Auto-generated method stub
		if(n1.distance>n2.distance)
		{
			return 1;
		}
		else if(n1.distance<n2.distance)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}

}
