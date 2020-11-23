package queuestack;

public class MyQueue<E> implements Push<E> {
    MyList<E> list;
    public MyQueue(MyList<E> list) {
        this.list = list;
    }
    public MyQueue() {
    }

    @Override
    public void push(E value) {
        list.push_back(value);
    }
    @Override
    public void setList(MyList<E> list) {
        this.list = list;
    }
}