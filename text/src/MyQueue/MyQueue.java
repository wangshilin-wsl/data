package MyQueue;

@SuppressWarnings("rawtypes")
public class MyQueue<E> implements DelayedQueue {
	private static int  maxDelay;
	private int delay;
	private E[] elements;
	private int size;
	private int maxsize = 10;
	private boolean lastOperationIsDequeue;

	@SuppressWarnings("unchecked")
	public MyQueue(int maxDelay) {
		this.maxDelay = Math.max(maxDelay,0);
		this.delay = Math.max(maxDelay,0);
		this.size = 0;
		this.elements = (E[]) new Object [maxsize];
		lastOperationIsDequeue = false;
	}
	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	public void copyOf(int capacity) {
		E[] old = elements;
		elements = (E[]) new Object[capacity];
		for (int i = 0; i < maxsize; i++) {
			elements[i] = old[i];
		}
		maxsize = capacity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void enqueue(Object element) {
		if(size>= elements.length) {
			copyOf(size*2);
		}
		elements[size]=(E) element;
		size++;
		if(lastOperationIsDequeue) {
			delay = maxDelay;
			lastOperationIsDequeue = false;
		}
		delay = Math.max(delay-1, 0);
	}


	@Override
	public E dequeue() throws IllegalStateException {
		if(size==0) throw new IllegalStateException("the queue is empty.");
		if(delay>0) return null;
		lastOperationIsDequeue = true;
		E elem = elements[0];
		for (int i=0;i<size-1;i++) {
			elements[i]=elements[i+1];
		}
		size--;
		return elem;
	}

	@Override
	public Object peek() throws IllegalStateException {
		if(size==0) throw new IllegalStateException("the queue is empty.");
		E temp = (E) elements[0];
		return temp;
	}

	@Override
	public int getDelay() {
		return delay;
	}

	@Override
	public void setMaximumDelay(int d) {
		this.maxDelay = d;

	}

	@Override
	public int getMaximumDelay() {
		return maxDelay;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean clear() {
		if(delay>0) return false;
		while(size!=0){
			dequeue();
		}
		return true;
	}

	@Override
	public boolean contains(Object elem) {
		for(int i =0; i<size;i++) {
			if(elem==elements[i]||(elem!=null&&elem.equals(elements[i]))) {
				return true;
			}
		}
		return false;
	}
}
