package chessplayerproject;
/**
 * @author rebecca pasto
 * Array based data structure selected from Stack
 */
public class MyStack {
    private final ChessPlayer[] data;
    private int top;
    
    public MyStack(){
        data = new ChessPlayer[100];
        top = -1;
    }
    public void push(ChessPlayer value){
        data[++top] = value;
    }
    public ChessPlayer pop(){
        if(top == -1){
            System.out.println("Stack is empty");
            return null;
        }
        return data[top--];
    }
    public ChessPlayer peek(){
        if(top == -1){
            System.out.println("Stack is empty");
            return null;
        }
        return data[top];
    }
    public boolean isEmpty(){
        return top == -1;
    }
}
