package queuestack;

public interface Push<E> {
    void push(E value);
    void setList(MyList<E> list);
}
