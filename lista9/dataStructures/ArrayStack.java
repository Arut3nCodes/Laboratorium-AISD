package dataStructures;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class ArrayStack<T> implements IStack<T>{
    T array[];
    int topIndex;

    public ArrayStack(int initialSize){
        array = ((T[])(new Object[initialSize]));
        topIndex = 0;
    }

    @Override
    public boolean isEmpty(){
        return (topIndex == 0);
    }

    @Override
    public boolean isFull(){
        return(topIndex == array.length);
    }

    @Override
    public void push(T element){
        array[topIndex++] = element;
    }

    @Override
    public T pop() throws EmptyStackException{
            if(isEmpty()){
                throw new EmptyStackException();
            }
            return array[--topIndex];
    }
    @Override
    public T top() throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return array[topIndex-1];
    }
    @Override
    public int size() {
        return topIndex;
    }

    public void reverse(){
        ArrayStack<T> as = new ArrayStack<>(array.length);
        while(!this.isEmpty()){
            as.push(this.pop());
        }
        this.array = as.array;
        this.topIndex = as.topIndex;
    }

    public void copy(ArrayStack<T> as) {
        this.array = as.array;
        this.topIndex = as.topIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayStack<?> that = (ArrayStack<?>) o;
        return topIndex == that.topIndex && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(topIndex);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + Arrays.toString(array) +
                ", topIndex=" + topIndex +
                '}';
    }
}
