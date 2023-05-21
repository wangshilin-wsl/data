package MyStack;


@SuppressWarnings("rawtypes")
public class MyStack<E> implements DelayedStack {
    private int maxDelay;
    private int delay;
    private E[] elements;
    private int size;
    private int maxsize = 10;
    private boolean lastOperationIsPop;


    @SuppressWarnings("unchecked")
    public MyStack(int maxDelay) {
        this.maxDelay = Math.max(maxDelay,0);
        this.delay = Math.max(maxDelay,0);
        this.size = 0;
        this.elements = (E[]) new Object [maxsize];
        lastOperationIsPop = false;
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
    public void push(Object element) {
        if(size>= elements.length) {
            copyOf(size*2);
        }
        elements[size++]=(E) element;
        if(lastOperationIsPop) {
            delay = maxDelay;
            lastOperationIsPop = false;
        }
        delay = Math.max(delay-1, 0);
    }

    @Override
    public E pop() throws IllegalStateException {
        if(size==0) throw new IllegalStateException("The stack is empty.");
        if(delay>0) return null;
        lastOperationIsPop = true;
        return elements[--size];
    }

    @Override
    public E peek() throws IllegalStateException {
        if(size==0) throw new IllegalStateException("The stack is empty.");
        E temp = (E) elements[size-1];
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
            pop();
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

    public static void main(String[] args) {
        DelayedStack<String> s = new MyStack<String>(0);
        s.push("hello");
        System.out.println(s.pop());
        s.setMaximumDelay(2);
        System.out.println(s.getMaximumDelay());
        try {
            s.pop(); //IllegalStateException is thrown, the stack is empty
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(s.size()+"===");
        }

        s.push("X");
        s.push("a");
        s.push("b");
        s.push("c");
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.setMaximumDelay(4);
        System.out.println(s.getDelay());
        System.out.println(s.pop());
        s.push("Y"); s.push("Z");
        s.setMaximumDelay(-1);
        System.out.println(s.getDelay());
        s.push("An");
        System.out.println(s.getDelay());
        System.out.println(s.pop());
        s.push("AX");
        System.out.println(s.getDelay());
        System.out.println(s.pop());
    }
}

