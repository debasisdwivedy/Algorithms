package Chapter_7;

class MinHeap
{
    int[] arr;
    int count;
    public MinHeap()
    {
        this.arr=new int[2];
        count=0;
    }

    private void resize(int[] arr)
    {
        int size=this.arr.length*2;
        int[] newArr=new int[size];
        for(int i=0;i<size;i++)
        {
            newArr[i]=arr[i];
        }
        this.arr=newArr;
    }

    public void add(int num)
    {
        if(this.arr.length==count)
        {
            resize(this.arr);
        }
        this.arr[count]=num;
        percolateUp(count);
        this.count++;
    }

    private void percolateUp(int count)
    {
        while(count>0 && this.arr[(count-1)/2]>this.arr[count])
        {
            swap((count-1)/2,count);
            count=(count-1)/2;
        }
    }

    private void percolateDown(int count)
    {
        int left_child=this.arr[(count*2)+1];
        int right_child=this.arr[(count*2)+2];
        while(count<=this.count && (this.arr[count]>left_child || this.arr[count]>right_child))
        {
            if(this.arr[count]>left_child)
            {
                swap((count*2)+1,count);
                count=(count*2)+1;
            }
            else{
                swap((count*2)+2,count);
                count=(count*2)+2;
            }
            if((count*2)+1<=this.count)
                left_child=this.arr[(count*2)+1];
            if((count*2)+2<=(count*2)+2)
                right_child=this.arr[(count*2)+2];
            
        }
    }

    private void swap(int i,int j)
    {
        int temp=this.arr[i];
        this.arr[i]=this.arr[j];
        this.arr[j]=temp;
    }

    public int getMin()
    {
        int num=this.arr[0];
        swap(0,this.count);
        percolateDown(0);
        this.count--;
        return num;
    }

    public int top()
    {
        if(!this.isEmpty())
            return this.arr[0];

        return -1;
    }

    public boolean isEmpty()
    {
        return this.count<=0?true:false;
    }
}
public class Solutions {
    public static void main(String[] args)
    {

    }
}