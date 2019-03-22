public class ArrayStack<T> implements Stack<T> {
    int size = 10;
    T[] arr;
    int top;

    public ArrayStack(){
        arr = (T[]) new Object[size];
        top = -1;
    }

    public void push(T item) {
        if(top == arr.length-1){
            grow_array();
        }
        arr[++top] = item;
    }

    public T peek() { 
        return arr[top];
    }

    protected void grow_array() {
        T[] temp = (T[]) new Object[arr.length*2];
        for(int i = 0; i < arr.length;i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public T pop() { 
        return arr[top--];
    }

    public boolean empty() { 
        if(top == -1) {
            return true;
        }
        else {
            return false;
        }
    }
}