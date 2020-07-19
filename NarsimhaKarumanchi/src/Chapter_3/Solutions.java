package Chapter_3;
import java.util.*;

class SLL
{
    int data;
    SLL next;

    public SLL(int data,SLL next)
    {
        this.data=data;
        if(next!=null)
        {
            this.next = next;
        }
        
    }

    public void setNext(SLL node)
    {
        if(node != null)
        {
            this.next = node;
        }
    }

    public SLL getNext()
    {
        return this.next;
    }
}

class DLL
{
    String data;
    DLL next;
    DLL prev;

    public DLL(String data,DLL next,DLL prev)
    {
        this.data=data;
        if(next!=null)
        {
            this.next = next;
        }
        
        if(prev!=null)
        {
            this.prev = prev;
        }
        
    }

    public void setNext(DLL node)
    {
        if(node != null)
        {
            this.next = node;
        }
    }

    public DLL getNext()
    {
        return this.next;
    }

    public void setPrev(DLL node)
    {
        if(node != null)
        {
            this.prev = node;
        }
    }

    public DLL getPrev()
    {
        return this.prev;
    }
}

class Stack
{
    SLL top;
    int count;
    public Stack(SLL init)
    {
        if(init!=null)
        {
            this.top = new SLL(init.data,init.next);
            this.count++;
        }
        
    }

    public void push(SLL node)
    {
        if(node!=null)
        {
            node.next=this.top;
            this.top = node;
            this.count++;
        }
        
    }

    public SLL pop()
    {
        SLL node = this.top;
        if(this.top!=null)
        {
            this.top=this.top.next;
            this.count--;
        }
            
        return node;
    }


}

public class Solutions {
    
    public static SLL findNthNode(SLL head,int n)
    {
        int count=0;
        SLL result=head;
        while(head!=null)
        {
            if(count==n)
            {
                break;
            }
            head = head.next;
        }
        while(head!=null)
        {
            head = head.next;
            result=result.next;
        }
        return result;
    }

    public static boolean isCyclic(SLL head)
    {
        if(head==null)
        {
            return false;
        }
        SLL fast=head;
        SLL slow=head;

        while(fast!=null && fast.next!=null && slow!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                return true;
            }
        }

        return false;
    }

    public static SLL getCycle(SLL node,SLL head)
    {
        while(node!=null && head!=null)
        {
            if(head==node)
            {
                return head;
            }
            node=node.next;
            head=head.next;
        }
        return null;
    }

    public static SLL reverseList(SLL head)
    {
        if(head.next==null)
        {
            return head;
        }
        SLL node = reverseList(head.next);
        node.next = head;
        //System.out.println(node.data+"-->"+head.data);
        return head;
    }

    public SLL mergeSortedList(SLL head1, SLL head2)
    {
        SLL res = new SLL(0,null);
        SLL marker=res;
        while(head1!=null && head2!=null)
        {
            if(head1.data<head2.data)
            {
                res.next=head1;
                head1=head1.next;
                res=res.next;
            }
            else
            {
                res.next=head2;
                head2=head2.next;
                res=res.next;
            }
        }
        while(head1!=null)
        {
            res.next=head1;
            head1=head1.next;
            res=res.next;
        }

        while(head2!=null)
        {
            res.next=head2;
            head2=head2.next;
            res=res.next;
        }
        return marker.next;
    }

    public static void reverseListKBlocks(SLL head, int k)
    {

    }
    public void sortList(SLL head)
    {

    }

    // public static void func()
    // {
        
    // }

    // public static void func()
    // {
        
    // }

    // public static void func()
    // {
        
    // }

    public static void main(String[] args)
    {
        SLL head = new SLL(1,new SLL(2,new SLL(3,new SLL(4,new SLL(5,null)))));
        SLL node = reverseList(head);
    }
}