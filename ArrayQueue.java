public class ArrayQueue<T> implements Queue<T> {

	int tail;
    int head;
    T[] arr;
    int size = 0;

	public ArrayQueue() {

		arr = (T[]) new Object[10];
		tail = 0;
		head = 0;
	}

	public boolean empty() {

		return (size == 0);
	}

	public T dequeue() {
		
		T temp = arr[head];
		head = (head + 1) % arr.length;
		size--;
		return temp;
	}

	public void enqueue(T item) {
		
		if ((head + 1) % arr.length == tail){
			grow_array();
		}
		arr[tail++] = item;
		tail = tail % arr.length;
		size++;
	}

	protected void grow_array() {

        T[] temparr = (T[]) new Object[arr.length*2];

        for(int i = head, j = 0; j < size; i++, j++) {
            temparr[j] = arr[i  %arr.length];
        }

        arr = temparr;
        head = 0;
        tail = size;
	}
}
// need to keep one slot open at all times
