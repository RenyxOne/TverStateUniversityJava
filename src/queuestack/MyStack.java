package queuestack;

public class MyStack<E> implements Push<E> {
    MyList<E> list;
    public MyStack(MyList<E> list) {
        this.list = list;
    }
    public MyStack() {
    }
    @Override
    public void push(E value) {
        list.push_front(value);
    }
    @Override
    public void setList(MyList<E> list) {
        this.list = list;
    }
}