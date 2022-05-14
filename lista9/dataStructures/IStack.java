package dataStructures;

public interface IStack<T> {
    boolean isEmpty();
    boolean isFull();
    void push(T element);
    T pop();
    int size();
    T top();
}
