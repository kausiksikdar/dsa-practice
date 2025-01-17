import java.util.Stack;

public class reverse_stack {
    static void reverse(Stack<Integer> St)
    {
        if(St.size() == 1){
            return;
        }
        
        int top = St.pop();
        
        reverse(St);
        
        pushEnd(St, top);
    }
    static void pushEnd(Stack<Integer> stack, int element)
    {
        if(stack.empty()){
            stack.push(element);
            return;
        }
        
        int topElement = stack.pop();
        
        pushEnd(stack, element);
        
        stack.push(topElement);
    }
    public static void main(String[] args) {
        Stack<Integer> St = new Stack<>();
        St.push(1);
        St.push(2);
        St.push(3);
        St.push(4);
        St.push(5);
        St.push(6);
        St.push(7);
        St.push(8);
        St.push(9);
        St.push(10);
        System.out.println("Original Stack: " + St);
        
        reverse(St);
        
        System.out.println("Reversed Stack: " + St);
    }
}
