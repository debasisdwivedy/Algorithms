package Chapter_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// class Stack
// {
//     int top;
//     int size;
//     int[] arr;
//     public Stack()
//     {
//         this.top=0;
//         this.size=0;
//         arr=new int[1]; 
//     }

//     public int getTop()
//     {
//         return arr[this.top];
//     }

//     public int getSize()
//     {
//         return this.size;
//     }

//     public void push(int elem)
//     {
//         if(isFull())
//         {
//             int[] newArr=new int[this.top*2];
//             for(int i=0;i<this.top;i++)
//             {
//                 newArr[i]=arr[i];
//             }
//             this.arr=newArr;
//         }
//         arr[this.top]=elem;
//         this.top++;
//     }

//     public int pop() throws Exception
//     {
//         if(this.top-1<=0)
//         {
//             throw new Exception("Stack underflow");
//         }
//         this.top--;
//         return this.arr[this.top+1];
//     }

//     public boolean isEmpty()
//     {
//         return this.top == 0? true:false;
//     }

//     public boolean isFull()
//     {
//         return this.top==this.arr.length? true:false;
//     }
// }


public class Solutions {

    private static Map<String,Integer> priority=null;
    static{
    priority=new HashMap<>();
    priority.put("*",4);
    priority.put("/",4);
    priority.put("%",4);
    priority.put("+",3);
    priority.put("-",3);
    }

    public static boolean isBalanced(char[] chr) throws Exception
    {
        Stack st = new Stack();
        for(int i=0;i<chr.length;i++)
        {
            if(chr[i]=='(' || chr[i]=='{' || chr[i]=='[')
            {
                st.push(chr[i]);
            }
            else if(chr[i]==')' || chr[i]=='}' || chr[i]==']')
            {
                if(st.isEmpty())
                {
                    return false;
                }
                char ch = (char)st.pop();
                if(!((ch=='(' && chr[i]==')') || (ch=='{' && chr[i]=='}') || (ch=='[' && chr[i]==']')))
                {
                    return false;
                }
            }
            else
            {
                continue;
            }
        }
        if(st.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }

    public static void infixToPrefix(String str)
    {
        char[] chr=str.toCharArray(); //(A+B)+(C-D) ---> ++AB-CD
        Stack<String> operand=new Stack<>();
        Stack<String> operator=new Stack<>();

        for(int i=0;i<chr.length;i++)
        {
            String s=chr[i]+"";
            if(")".equalsIgnoreCase(s) || "]".equalsIgnoreCase(s))
            {
                
                String temp="";
                while(true)
                {
                    String oprad1=operand.pop();
                    if("(".equalsIgnoreCase(oprad1) || "[".equalsIgnoreCase(oprad1))
                        break;
                    String oprad2=operand.pop();
                    if("(".equalsIgnoreCase(oprad2) || "[".equalsIgnoreCase(oprad2))
                        break;

                    String opera=operator.pop();
                    temp=temp+opera+oprad2+oprad1;
                }
                operand.push(temp);
            }
            else if(priority.get(s)==null)
            {
                operand.push(s);
            }
            else{
                if(!operator.isEmpty())
                {
                    if(priority.get(s)<priority.get(operator.peek()))
                    {
                        preEvalOperation(operand,operator);
                        operator.push(s);
                    }
                    else
                    {
                        operator.push(s);
                    }
                }
                else
                {
                    operator.push(s);
                }
            }
        }

        while(!operator.isEmpty())
        {
            String opera=operator.pop();
            String oprad1=operand.pop();
            String oprad2=operand.pop();
            operand.push(opera+oprad2+oprad1);
        }
        System.out.println(operand.pop());
    }

    public static void infixToPostfix(String str)
    {
        char[] chr=str.toCharArray(); //(A+B)+(C-D) ---> AB+CD-+
        Stack<String> operand=new Stack<>();
        Stack<String> operator=new Stack<>();

        for(int i=0;i<chr.length;i++)
        {
            String s=chr[i]+"";
            if(")".equalsIgnoreCase(s) || "]".equalsIgnoreCase(s))
            {
                
                String temp="";
                while(true)
                {
                    String oprad1=operand.pop();
                    if("(".equalsIgnoreCase(oprad1) || "[".equalsIgnoreCase(oprad1))
                        break;
                    String oprad2=operand.pop();
                    if("(".equalsIgnoreCase(oprad2) || "[".equalsIgnoreCase(oprad2))
                        break;

                    String opera=operator.pop();
                    temp=temp+oprad2+oprad1+opera;
                }
                operand.push(temp);
            }
            else if(priority.get(s)==null)
            {
                operand.push(s);
            }
            else{
                if(!operator.isEmpty())
                {
                    if(priority.get(s)<priority.get(operator.peek()))
                    {
                        postEvalOperation(operand,operator);
                        operator.push(s);
                    }
                    else
                    {
                        operator.push(s);
                    }
                }
                else
                {
                    operator.push(s);
                }
            }
        }

        while(!operator.isEmpty())
        {
            String opera=operator.pop();
            String oprad1=operand.pop();
            String oprad2=operand.pop();
            operand.push(oprad2+oprad1+opera);
        }
        System.out.println(operand.pop());

    }

    public static void preEvalOperation(Stack<String> operand,Stack<String> operator)
    {
        while(!operator.isEmpty())
        {
            String opera=operator.pop();
            String oprad1=operand.pop();
            String oprad2=operand.pop();
            operand.push(opera+oprad2+oprad1);
        }
    }
    
    public static void postEvalOperation(Stack<String> operand,Stack<String> operator)
    {
        while(!operator.isEmpty())
        {
            String opera=operator.pop();
            String oprad1=operand.pop();
            String oprad2=operand.pop();
            operand.push(oprad2+oprad1+opera);
        }
    }

    public static Stack<Integer> reverseStack(Stack<Integer> stk)
    {
        Stack<Integer> tempstk=new Stack<>();
        while(!stk.isEmpty())
        {
            tempstk.push(stk.pop());
        }
        return tempstk;
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
        //infixToPrefix("(A+B)*C-D");//(A+B)+(C-D)
        //infixToPostfix("(A+B)+(C-D)");
        
        
    }
}