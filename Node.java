
public class Node {
	int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
    
    static Node createBST(int[] arr,int start,int end)
    {
    	Node n=null;
    	if(end-start>=0)
    	{
    		int mid_index=(end-start)/2;
    		//System.out.println(start+"---->"+mid_index+"---->"+end);
    		n=new Node(arr[start+mid_index]);
    		if(mid_index>0)
    		{
    		n.left=createBST(arr,start,start+mid_index-1);
    		n.right=createBST(arr,start+mid_index+1,end);
    		}
    	}
    	
    		return n;
    }

}
