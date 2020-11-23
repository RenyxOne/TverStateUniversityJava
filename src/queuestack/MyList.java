package queuestack;
public class MyList<E> {

    public int getSize() {
        return size;
    }

    public E getIndex(int index) {
        Node<E> cur = head;
        for (int i = 0; cur != null && i < index; i++, cur = cur.next);
        return cur.value; 
    }
    
    protected class Node<E> {
        protected E value;
        protected Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        public Node(E value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return value + "";
        } 
    }
    
    protected Node<E> head;
    protected int size;
    protected Push<E> sQ;
    
    public MyList() {
        head = null;
        size = 0;
    }

    public void push_back(E value) {
        Node<E> nodeToAdd = new Node<E>(value);
        if (head == null) { head = nodeToAdd; }
        else {
            Node<E> cur = head;
            while(cur.next != null) cur = cur.next;
            cur.next = nodeToAdd;
        }
        size++;
    }
    
    public void push_front(E value) {
        Node<E> nodeToAdd = new Node<E>(value);
        if (head == null) { head = nodeToAdd; }
        else {
            nodeToAdd.next =head;
            head = nodeToAdd;
        }
        
        size++;
    }
    
    public E pop() {
        if (head == null) return null;
        E value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public void setSq(Push<E> sq) {
        sQ = sq;
        sQ.setList(this);
    }

    public Push<E> getSq(){
        return sQ;
    }

    public void push(E value){
        sQ.push(value);
    }

    @Override
    public String toString() {
        String out = "List";
        for (Node<E> i = this.head; i != null; i = i.next)
            out += i + " ";
        return out;
    }
}